/**
 * 
 */
package correo.vistaCorreo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Natalia
 *
 */
public class VistaCorreo extends JPanel{
	JdialogNuevoCorreo correo = new JdialogNuevoCorreo();
	JPanel emailJpanelHeadline = new JPanel();
	JList<Object> emailJlistHeadlist;
	JButton emailJbuttonCreate;
	
	
	public VistaCorreo(ArrayList<String> message) {
		crearItems(message);
		propiedades();
	}

	private void crearItems(ArrayList<String> message) {
		// TODO Auto-generated method stub
		emailJlistHeadlist = new JList<Object>(message.toArray());
		emailJbuttonCreate = new JButton("Escribir nuevo correo");
		
		//emailJdialogContent.add(correo);
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		
		add(emailJlistHeadlist, BorderLayout.CENTER);
		add(emailJbuttonCreate, BorderLayout.SOUTH);
		
		emailJlistHeadlist.setBackground(new Color(255, 253, 150));
		emailJlistHeadlist.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));

		this.setVisible(true);
		this.setSize(new Dimension(820, 500));
	}

	/**
	 * @return the emailJlistHeadlist
	 */

	public JList<Object> getEmailJlistHeadlist() {
		return emailJlistHeadlist;
	}
	
}
