package correo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	
	public VistaCorreo getMailView() {
		return mailView;
	}

	public ControllerMail(VistaCorreo view) {
		mailView = view;
		Properties props = prepareConnectionProperties();
		readMails(props);
		System.out.println("Activando vista");
		mailView.setVisible(true);
		System.out.println("Fin");
		// Acceder al correo y leer los mensajes de la carpeta de recibidos - Listo
		// Agregar cada correo como un item - Listo
		// Agregarle el evento a cada encabezado
		// Cuando se pulse en un encabezado, se extrae el número de mensaje, se busca
			// el mensaje con ese número y se lanza la vista del visor con ese mensaje
		// Listener botón crear
		// Listener botón nuevo -> enviar
		// Hilo de sincronía
		// Tubería para la sincronía
			
	}

	private void readMails(Properties props) {
		// TODO Auto-generated method stub
		Session session = Session.getDefaultInstance(props);
		Store store;
		Folder inbox;
		Message[] messages;
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
			mailView.addItemsJlist(headerList);
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
			senders = message.getFrom();
			for (int i = 0; i < senders.length; i++) {
				sender.append(senders[i].toString());
			}
			subject.append(message.getSubject());
		    Date dateRecived = message.getSentDate();  
		    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");  
		    date.append(dateFormat.format(dateRecived));  
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		header.append(sender);
		header.append(subject);
		header.append(date);
		System.out.println(header.toString());
		return header.toString();
	}

	private Properties prepareConnectionProperties() {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "pop3");
		props.setProperty("mail.pop3.starttls.enable", "true");
		props.setProperty("mail.pop3.host", TextES.getControllerMailInboundHost());
		props.setProperty("mail.pop3.port", TextES.getControllerMailInboundPort());
		props.setProperty("mail.pop3.socketFactory.class", TextES.getControllerMailInboundSSLSocketFactoryClass());
		props.setProperty("mail.pop3.socketFactory.fallback", TextES.getControllerMailInboundSocketFactoryFallback());
		props.setProperty("mail.pop3.socketFactory.port", TextES.getControllerMailInboundSocketFactoryPort());
		return props;
	}
	
}
