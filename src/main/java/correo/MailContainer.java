package correo;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;

import common.TextES;

public class MailContainer {
	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props);
	Store store;
	Folder inbox;
	boolean synch =  true;
	
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
			inbox.addMessageCountListener(new MessageCountListener() {
				
				@Override
				public void messagesRemoved(MessageCountEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void messagesAdded(MessageCountEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			inbox.open(Folder.READ_ONLY);
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
