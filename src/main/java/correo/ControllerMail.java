package correo;

import common.Usuario;
import correo.vistaCorreo.VistaCorreo;

/**
 * @author Israel
 * Initializes the eMail section view, synch thread and Listeners.
 */
public class ControllerMail {
	VistaCorreo mailView;

	/**
	 * Starts the view, synch thread and listener.
	 * @param user 
	 */
	public ControllerMail(VistaCorreo mailView, Usuario user) {
		this.mailView = mailView;
		MailContainer container = new MailContainer(mailView);
		container.prepareConnectionProperties();
		container.downloadMails(user.getEmail(), user.getPassword());
		SynchThread synch = new SynchThread(container);
		synch.start();
		container.readMails();
		mailView.getEmailJbuttonCreate().addActionListener(new NewMailButtonListener(user));
		mailView.setVisible(true);
	}

	/**
	 * @return VistaCorreo - returns the eMail main view
	 */
	public VistaCorreo getMailView() {
		return mailView;
	}
}
