/**
 * 
 */
package ftp.vistaFTP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author Natalia
 *
 */
public class VistaCreate extends JFrame{
	JTextField createJtextfieldName = new JTextField(15);
	JButton createJbuttonConfirm = new JButton("Confirmar");
	
	public VistaCreate() {
		propiedades();
	}
	
	private void propiedades() {
		// TODO Auto-generated method stub
		add(createJtextfieldName);
		add(createJbuttonConfirm);
		this.setLayout(new FlowLayout());
		this.setTitle("Crear");
		getContentPane().setBackground(new Color(255, 253, 150));
		this.setSize(new Dimension(320, 100));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * @return the createJtextfieldName
	 */
	public JTextField getCreateJtextfieldName() {
		return createJtextfieldName;
	}
	
}
