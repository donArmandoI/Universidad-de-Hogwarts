/**
 * 
 */
package correo.vistaCorreo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class VistaCorreo extends JPanel{
	TextES spanish = new TextES();
	JList<Object> emailJlistHeadlist = new JList<Object>();
	JButton emailJbuttonCreate = new JButton(spanish.getEmailStringNuevoCorreo());
	
	public VistaCorreo() {
		propiedades();
	}

	public void addItemsJlist(DefaultListModel modelo) {
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
	public JList<Object> getEmailJlistHeadlist() {
		return emailJlistHeadlist;
	}

	/**
	 * @return the emailJbuttonCreate
	 */
	public JButton getEmailJbuttonCreate() {
		return emailJbuttonCreate;
	}
	

}
