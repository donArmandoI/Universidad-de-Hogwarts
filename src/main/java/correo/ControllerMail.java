package correo;

import correo.vistaCorreo.VistaCorreo;

/**
 * @author Israel
 *
 */
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
		mailView.getEmailJbuttonCreate().addActionListener(new NewMailButtonListener());
		mailView.setVisible(true);
	}

	public VistaCorreo getMailView() {
		return mailView;
	}
}
