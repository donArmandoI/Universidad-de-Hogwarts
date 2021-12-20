package correo;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.DefaultListModel;

import common.TextES;
import correo.vistaCorreo.VistaCorreo;

public class ControllerMail {
	VistaCorreo mailView;
	
	public ControllerMail(VistaCorreo view) {
		mailView = view;
		Properties props = prepareConnectionProperties();
		readMails(props);
	}

	private void readMails(Properties props) {
		// TODO Auto-generated method stub
		Session session = Session.getDefaultInstance(props);
		Store store;
		Folder inbox;
		Message[] messages;
		String[] headers;
		DefaultListModel<String> headerList;
		
		try {
			store = session.getStore();
			store.connect(TextES.getControllerMailInboundUserName(), TextES.getControllerMailInboundPassword());
			inbox = store.getFolder(TextES.getControllerMailInboundTargetFolder());
			inbox.open(Folder.READ_ONLY);
			messages = inbox.getMessages();
			headerList = new DefaultListModel<String>();
			for (int i = 0; i < messages.length; i++) {
				headerList.addElement(extractHeader(messages[i]));
			}
			mailView.
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String extractHeader(Message message) {
		// TODO Auto-generated method stub
		StringBuilder header = new StringBuilder(166);
		StringBuilder sender = new StringBuilder(50);
		StringBuilder subject = new StringBuilder(100);
		StringBuilder date = new StringBuilder(16);
		Address[] senders;
		try {
			senders = message.getAllRecipients();
			for (int i = 0; i < senders.length; i++) {
				sender.append(senders[i].toString());
			}		
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		header.append(sender);
		header.append(subject);
		header.append(date);
		return header.toString();
	}

	private Properties prepareConnectionProperties() {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("mail.pop3.host", TextES.getControllerMailInboundHost());
		props.setProperty("mail.pop3.port", TextES.getControllerMailInboundPort());
		props.setProperty("mail.pop3.socketFactory.class", TextES.getControllerMailInboundSSLSocketFactoryClass());
		props.setProperty("mail.pop3.socketFactory.fallback", TextES.getControllerMailInboundSocketFactoryFallback());
		props.setProperty("mail.pop3.socketFactory.port", TextES.getControllerMailInboundSocketFactoryPort());
		return props;
	}
	// Acceder al correo y leer los mensajes de la carpeta de recibidos
	// Agregar cada correo como un item
	// Agregarle el evento a cada encabezado
	// Cuando se pulse en un encabezado, se extrae el n�mero de mensaje, se busca
		// el mensaje con ese n�mero y se lanza la vista del visor con ese mensaje
	// Listener bot�n crear
	// Listener bot�n nuevo -> enviar
	// Hilo de sincron�a
	// Tuber�a para la sincron�a
		
}
