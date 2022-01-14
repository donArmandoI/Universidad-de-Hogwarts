/**
 * 
 */
package ftp.vistaFTP;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Natalia
 *
 */
public class JpanelFichero extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7729068013802018591L;
	JButton contentJbuttonImagenFile = new JButton();
	JLabel contentJlabelFile = new JLabel();

	public JpanelFichero(boolean directorio, String name) {
		tipoFichero(directorio, name);
		propiedades();
	}

	private void tipoFichero(boolean directorio, String name) {

		if (directorio) {

			contentJbuttonImagenFile.setIcon(new ImageIcon("imagenesFTP/carpetita.png"));

		} else {

			contentJbuttonImagenFile.setIcon(new ImageIcon("imagenesFTP/doc.png"));
		}

		contentJlabelFile.setText(name);

		this.remove(contentJbuttonImagenFile);
		this.remove(contentJlabelFile);
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		this.add(contentJbuttonImagenFile);
		contentJlabelFile.setForeground(Color.BLACK);
		this.add(contentJlabelFile);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setBackground(new Color(209, 242, 235));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setVisible(true);
	}

	/**
	 * @return the contentJlabelImagenFile
	 */
	public JButton getContentJbuttonImagenFile() {
		return contentJbuttonImagenFile;
	}

	/**
	 * @return the contentJlabelFile
	 */
	public JLabel getContentJlabelFile() {
		return contentJlabelFile;
	}

}
