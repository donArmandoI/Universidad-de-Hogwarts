/**
 * 
 */
package correo.vistaCorreo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class VistaCorreo extends JFrame{
	JList<String> emailJlistHeadlist = new JList<String>();
	JButton emailJbuttonCreate = new JButton(TextES.getEmailStringNuevoCorreo());
	
	public VistaCorreo() {
		propiedades();
	}

	public void addItemsJlist(DefaultListModel<String> modelo) {
		emailJlistHeadlist.setModel(modelo);
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		
		add(emailJlistHeadlist, BorderLayout.CENTER);
		add(emailJbuttonCreate, BorderLayout.SOUTH);
		
		emailJlistHeadlist.setBackground(new Color(255, 253, 150));
		emailJlistHeadlist.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.white));
	}

	/**
	 * @return the emailJlistHeadlist
	 */
	public JList<String> getEmailJlistHeadlist() {
		return emailJlistHeadlist;
	}

	/**
	 * @return the emailJbuttonCreate
	 */
	public JButton getEmailJbuttonCreate() {
		return emailJbuttonCreate;
	}
	

}
