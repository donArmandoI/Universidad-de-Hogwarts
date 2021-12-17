/**
 * 
 */
package ftp.vistaFTP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Natalia
 *
 */
public class JpanelFichero extends JPanel {
	JLabel contentJlabelImagenFile = new JLabel();
	JLabel contentJlabelFile = new JLabel();
	
	public JpanelFichero(boolean directorio, String name) {
		tipoFichero(directorio,name);
		propiedades();
	}

	public void tipoFichero(boolean directorio, String name) {
		// TODO Auto-generated method stub
		ImageIcon icono;
		if (directorio) {
			icono = new ImageIcon(getClass().getResource("/imagenesFTP/carpetita.png"));
			contentJlabelImagenFile.setIcon(icono);
			contentJlabelFile.setText(name);
		} else {
			icono = new ImageIcon(getClass().getResource("/imagenesFTP/doc.png"));
			contentJlabelImagenFile.setIcon(icono);
			contentJlabelFile.setText(name);
		}

	}

	private void propiedades() {
		// TODO Auto-generated method stub
		add(contentJlabelImagenFile);
		contentJlabelFile.setForeground(Color.BLACK);
		add(contentJlabelFile);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setBackground(new Color(209, 242, 235));
		this.setLayout(new FlowLayout());
	}

	/**
	 * @return the contentJlabelImagenFile
	 */
	public JLabel getContentJlabelImagenFile() {
		return contentJlabelImagenFile;
	}

	/**
	 * @return the contentJlabelFile
	 */
	public JLabel getContentJlabelFile() {
		return contentJlabelFile;
	}
	
}
