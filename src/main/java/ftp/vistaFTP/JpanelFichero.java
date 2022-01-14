/**
 * 
 */
package ftp.vistaFTP;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXImagePanel;

/**
 * @author Natalia
 *
 */
public class JpanelFichero extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2331535779547863710L;
	JXImagePanel contentJlabelImagenFile = new JXImagePanel();
	JLabel contentJlabelFile = new JLabel();
	
	public JpanelFichero(boolean directorio, String name) {
		tipoFichero(directorio,name);
		propiedades();
	}

	public void tipoFichero(boolean directorio, String name) {
		// TODO Auto-generated method stub
		ImageIcon icono;
		if (directorio) {
			icono = new ImageIcon(VistaFTP.class.getResource("/ftp/vistaFTP/imagenesFTP/carpetita.png"));
			contentJlabelFile.setText(name);
		} else {
			icono = new ImageIcon(VistaFTP.class.getResource("/ftp/vistaFTP/imagenesFTP/doc.png"));
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
	public JXImagePanel getContentJlabelImagenFile() {
		return contentJlabelImagenFile;
	}

	/**
	 * @return the contentJlabelFile
	 */
	public JLabel getContentJlabelFile() {
		return contentJlabelFile;
	}
	
}
