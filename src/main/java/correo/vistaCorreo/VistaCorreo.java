/**
 * 
 */
package correo.vistaCorreo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.VerticalLayout;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class VistaCorreo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1183932292649499724L;
	JButton emailJbuttonCreate = new JButton(TextES.getEmailStringNewMail());
	JPanel board = new JPanel();

	public VistaCorreo() {
		propiedades();
	}

	public void addMessage(Header message) {
		board.add(message, 0);
		board.updateUI();
	}

	public void clearMessages() {
		board.removeAll();
		validate();
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(emailJbuttonCreate, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(board);
		board.setLayout(new VerticalLayout());
		getContentPane().add(scroll, BorderLayout.CENTER);
	}

	/**
	 * @return the emailJbuttonCreate
	 */
	public JButton getEmailJbuttonCreate() {
		return emailJbuttonCreate;
	}

}
