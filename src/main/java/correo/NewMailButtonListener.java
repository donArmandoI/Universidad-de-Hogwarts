package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.Usuario;
import correo.vistaCorreo.JdialogNuevoCorreo;

/**
 * @author Israel
 * Listener to create a new mail.
 */
public class NewMailButtonListener implements ActionListener {
	private Usuario user;
	
	public NewMailButtonListener(Usuario user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}

	/**
	 * Generate an enable the new mail view.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JdialogNuevoCorreo newMailView = new JdialogNuevoCorreo();
		newMailView.getEmailcreateJButtonSend().addActionListener(new ButtonNewMailSendListener(newMailView, user));
		newMailView.getEmailcreateJbuttonCancel().addActionListener(new ButtonCancel(newMailView));
		newMailView.setVisible(true);
	}
}
