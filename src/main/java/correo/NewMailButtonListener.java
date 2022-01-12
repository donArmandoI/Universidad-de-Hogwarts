package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import correo.vistaCorreo.JdialogNuevoCorreo;

/**
 * @author Israel
 *
 */
public class NewMailButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JdialogNuevoCorreo newMailView = new JdialogNuevoCorreo();
		newMailView.getEmailcreateJButtonSend().addActionListener(new ButtonNewMailSendListener(newMailView));
		newMailView.getEmailcreateJbuttonCancel().addActionListener(new ButtonCancel(newMailView));
		newMailView.setVisible(true);
	}
}
