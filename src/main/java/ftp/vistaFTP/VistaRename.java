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
public class VistaRename extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3321828120533472312L;
	JTextField renameJtextfieldName = new JTextField(15);
	JButton renameJbuttonConfirm = new JButton("Confirmar");
	
	public VistaRename() {
		propiedades();
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		add(renameJtextfieldName);
		add(renameJbuttonConfirm);
		this.setLayout(new FlowLayout());
		this.setTitle("Renombrar");
		getContentPane().setBackground(new Color(255, 253, 150));
		this.setSize(new Dimension(320, 100));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * @return the renameJtextfieldName
	 */
	public JTextField getRenameJtextfieldName() {
		return renameJtextfieldName;
	}

	/**
	 * @return the renameJbuttonConfirm
	 */
	public JButton getRenameJbuttonConfirm() {
		return renameJbuttonConfirm;
	}
	
}
