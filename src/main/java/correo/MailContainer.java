package correo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.event.MessageCountAdapter;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.internet.InternetAddress;

import common.TextES;
import correo.vistaCorreo.Header;
import correo.vistaCorreo.VistaCorreo;

public class MailContainer {
	VistaCorreo mailView;
	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props);
	Store store;
	Folder inbox;
	Message[] messages;
	boolean synch =  true;
	
	public MailContainer(VistaCorreo mailView) {
		// TODO Auto-generated constructor stub
		this.mailView =  mailView;
	}

	public void prepareConnectionProperties() {
		// TODO Auto-generated method stub
		props.setProperty("mail.store.protocol", "imap");
		props.setProperty("mail.imap.host", TextES.getControllerMailInboundHost());
		props.setProperty("mail.imap.port", TextES.getControllerMailInboundPort());
		props.setProperty("mail.imap.socketFactory.class", TextES.getControllerMailInboundSSLSocketFactoryClass());
		props.setProperty("mail.imap.socketFactory.fallback", TextES.getControllerMailInboundSocketFactoryFallback());
		props.setProperty("mail.imap.socketFactory.port", TextES.getControllerMailInboundSocketFactoryPort());
	}
	
	public synchronized void downloadMails() {
		// TODO Auto-generated method stub
		session = Session.getDefaultInstance(props);
		
		try {
			store = session.getStore();
			store.connect(TextES.getControllerMailInboundUserName(), TextES.getControllerMailInboundPassword());
			inbox = store.getFolder(TextES.getControllerMailInboundTargetFolder());
			inbox.open(Folder.READ_ONLY);
			inbox.addMessageCountListener(new MessageCountAdapter() {
				public void messagesAdded(MessageCountEvent ev) {
				    System.out.println("Mensajes actualizados");
					messages = ev.getMessages();
				    readMails();
				}
		    });
			
//			inbox.addMessageCountListener(new MessageCountListener() {
//				
//				@Override
//				public void messagesRemoved(MessageCountEvent e) {
//					// TODO Auto-generated method stub
//					readMails();
//				}
//				
//				@Override
//				public void messagesAdded(MessageCountEvent e) {
//					// TODO Auto-generated method stub
//					readMails();
//				}
//			});
			
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readMails() {
		// TODO Auto-generated method stub
		try {
			messages = inbox.getMessages();
			mailView.clearMessages();
			for (int i = 0; i < messages.length; i++) {
				Header head = new Header(messages[i].getMessageNumber(), extractDate(messages[i]), 
						extractSenders(messages[i]), messages[i].getSubject());
				head.getLblDate().addMouseListener(new HeaderListener(messages));
				head.getLblSender().addMouseListener(new HeaderListener(messages));
				head.getLblSubject().addMouseListener(new HeaderListener(messages));
				System.out.println(messages[i].getMessageNumber());
				mailView.addMessage(head);
			}
			mailView.repaint();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String extractSenders(Message message) {
		StringBuilder sender = new StringBuilder(150);
		Address[] senders;
		try {
			senders = message.getFrom();
			for (int i = 0; i < senders.length; i++) {
				InternetAddress address = new InternetAddress(senders[i].toString());
				sender.append(address.toUnicodeString() + " ");
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sender.toString();
	}
	
	private String extractDate(Message message) {
		String date = null;
		Date dateRecived;
		try {
			dateRecived = message.getSentDate();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
		    date = dateFormat.format(dateRecived);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    return date;
	}

	public Folder getInbox() {
		return inbox;
	}

	public boolean isSynch() {
		return synch;
	}

	public void setSynch(boolean synch) {
		this.synch = synch;
	}
}
