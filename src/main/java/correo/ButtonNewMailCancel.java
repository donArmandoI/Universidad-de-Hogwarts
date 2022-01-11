package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import correo.vistaCorreo.JdialogNuevoCorreo;

/**
 * @author Israel
 *
 */
public class ButtonNewMailCancel implements ActionListener {
	private JdialogNuevoCorreo newMailView;

	public ButtonNewMailCancel(JdialogNuevoCorreo newMailView) {
		// TODO Auto-generated constructor stub
		this.newMailView = newMailView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		newMailView.dispose();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
