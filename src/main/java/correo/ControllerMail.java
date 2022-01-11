package correo;

import correo.vistaCorreo.VistaCorreo;

public class ControllerMail {
	VistaCorreo mailView;
	
	

	public ControllerMail() {
		mailView = new VistaCorreo();
		MailContainer container = new MailContainer(mailView);
		container.prepareConnectionProperties();
		container.downloadMails();		
		SynchThread synch = new SynchThread(container);
		synch.start();
		container.readMails();
		mailView.getEmailJbuttonCreate().addMouseListener(new NewMailButtonListener());
		mailView.setVisible(true);
//		while(container.isSynch()) {
//			readMails();
//			try {
//				Thread.sleep(30000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		// Acceder al correo y leer los mensajes de la carpeta de recibidos - Listo
		// Agregar cada correo como un item - Listo
		// Agregarle el evento a cada encabezado - Listo
		// Cuando se pulse en un encabezado, se extrae el número de mensaje, se busca
			// el mensaje con ese número y se lanza la vista del visor con ese mensaje
		// Listener botón nuevo -> enviar
		// Hilo de sincronía`- Listo
		// Tubería para la sincronía - Listo
			
	}

	
	public VistaCorreo getMailView() {
		return mailView;
	}
}
