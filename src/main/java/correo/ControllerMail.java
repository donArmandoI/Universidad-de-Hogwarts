package correo;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

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
		try {
			Store store = session.getStore();
			store.connect(TextES.getControllerMailInboundUserName(), TextES.getControllerMailInboundPassword());
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
