package correo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import correo.vistaCorreo.JdialogNuevoCorreo;

public class NewMailButtonListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JdialogNuevoCorreo newMailView = new JdialogNuevoCorreo();
		newMailView.getEmailcreateJButtonSend().addMouseListener(new ButtonNewMailSendListener(newMailView.getEmailcreateJtextfieldUser(), 
				newMailView.getEmailcreateJtextfieldSubject(), newMailView.getEmailcreateJtextareaText()));
		newMailView.getEmailcreateJbuttonCancel().addMouseListener(new ButtonNewMailCancel());
		newMailView.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
