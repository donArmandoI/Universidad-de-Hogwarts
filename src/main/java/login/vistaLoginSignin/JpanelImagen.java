/**
 * 
 */
package login.vistaLoginSignin;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

/**
 * @author Natalia
 *
 */
public class JpanelImagen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6254104319360821422L;
	ImageIcon imagen;
	String nombreImagen;

	public JpanelImagen(String nombreImagen) {
		// TODO Auto-generated constructor stub
		this.nombreImagen = nombreImagen;
	}
	
	public void paint(Graphics g) {
		Dimension dimension = getSize();
		imagen = new ImageIcon(getClass().getResource(nombreImagen));
		g.drawImage(imagen.getImage(),0,0,dimension.width, dimension.height,null);
		setOpaque(false);
		super.paint(g);
	}
}
