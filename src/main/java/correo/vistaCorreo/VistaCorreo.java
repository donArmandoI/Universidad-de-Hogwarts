/**
 * 
 */
package correo.vistaCorreo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
public class VistaCorreo extends JFrame{
	//JdialogNuevoCorreo correo = new JdialogNuevoCorreo();
	JPanel emailJpanelHeadline = new JPanel();
	JList<Object> emailJlistHeadlist;
	JButton emailJbuttonCreate;
	ArrayList<String>m = new ArrayList<String>();

	
	
	public VistaCorreo() {
		ArrayList<ArrayList<String>> message = new ArrayList<ArrayList<String>>();
		m.add("ppppp");
		m.add("fy3rt");
		m.add("hfdsawe");
		message.add(m);
		crearItems(message);
		propiedades();
	}

	private void crearItems(ArrayList<ArrayList<String>> message) {
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

		this.setSize(new Dimension(820, 500));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
