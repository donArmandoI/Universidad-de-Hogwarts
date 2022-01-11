package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import correo.vistaCorreo.JdialogNuevoCorreo;

public class NewMailButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JdialogNuevoCorreo newMailView = new JdialogNuevoCorreo();
		newMailView.getEmailcreateJButtonSend().addActionListener(new ButtonNewMailSendListener(newMailView));
		newMailView.getEmailcreateJbuttonCancel().addActionListener(new ButtonNewMailCancel(newMailView));
		newMailView.setVisible(true);
	}

}
