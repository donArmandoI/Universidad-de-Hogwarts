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
import javax.mail.internet.InternetAddress;
import javax.swing.DefaultListModel;

import common.TextES;
import correo.vistaCorreo.Header;
import correo.vistaCorreo.VistaCorreo;

public class ControllerMail {
	VistaCorreo mailView;
	MailContainer container;
	Message[] messages;
	
	public VistaCorreo getMailView() {
		return mailView;
	}

	public ControllerMail(VistaCorreo view, MailContainer container) {
		mailView = view;
		this.container = container;
		container.prepareConnectionProperties();
		container.downloadMails();		
		SynchThread synch = new SynchThread(container);
		synch.start();
		readMails();
		mailView.getEmailJbuttonCreate().addMouseListener(new NewMailButtonListener());
		mailView.setVisible(true);
		while(container.isSynch()) {
			readMails();
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Acceder al correo y leer los mensajes de la carpeta de recibidos - Listo
		// Agregar cada correo como un item - Listo
		// Agregarle el evento a cada encabezado - Listo
		// Cuando se pulse en un encabezado, se extrae el número de mensaje, se busca
			// el mensaje con ese número y se lanza la vista del visor con ese mensaje
		// Listener botón nuevo -> enviar
		// Hilo de sincronía`- Listo
		// Tubería para la sincronía - Listo
			
	}

	private void readMails() {
		// TODO Auto-generated method stub
		try {
			messages = container.getInbox().getMessages();
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
	
}
