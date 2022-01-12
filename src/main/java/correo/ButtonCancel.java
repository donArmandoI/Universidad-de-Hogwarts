package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

/**
 * @author Israel
 * Closes the view containing the button.
 */
public class ButtonCancel implements ActionListener {
	private JDialog view;

	/**
	 * Closes the view containing the button.
	 * @param view - JDialog - The view that contains the button.
	 */
	public ButtonCancel(JDialog view) {
		// TODO Auto-generated constructor stub
		this.view = (JDialog) view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		view.dispose();
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
