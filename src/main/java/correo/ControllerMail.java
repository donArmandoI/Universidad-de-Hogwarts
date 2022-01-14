package correo;

import correo.vistaCorreo.VistaCorreo;

/**
 * @author Israel
 * Initializes the eMail section view, synch thread and Listeners.
 */
public class ControllerMail {
	VistaCorreo mailView;

	/**
	 * Starts the view, synch thread and listener.
	 */
	public ControllerMail(VistaCorreo mailView) {
		this.mailView = mailView;
		MailContainer container = new MailContainer(mailView);
		container.prepareConnectionProperties();
		container.downloadMails();
		SynchThread synch = new SynchThread(container);
		synch.start();
		container.readMails();
		mailView.getEmailJbuttonCreate().addActionListener(new NewMailButtonListener());
		mailView.setVisible(true);
	}

	/**
	 * @return VistaCorreo - returns the eMail main view
	 */
	public VistaCorreo getMailView() {
		return mailView;
	}
}
