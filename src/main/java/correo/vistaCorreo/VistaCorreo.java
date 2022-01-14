/**
 * 
 */
package correo.vistaCorreo;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.VerticalLayout;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class VistaCorreo extends JPanel {
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
		setPreferredSize(new Dimension(1520, 750));
		setLayout(new BorderLayout());
//		board.setPreferredSize(new Dimension(1500, 700));
		board.setMaximumSize(new Dimension(1500, 40000));
		board.setLayout(new VerticalLayout());
		add(emailJbuttonCreate, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(board);
		add(scroll, BorderLayout.CENTER);
	}

	/**
	 * @return the emailJbuttonCreate
	 */
	public JButton getEmailJbuttonCreate() {
		return emailJbuttonCreate;
	}

}
