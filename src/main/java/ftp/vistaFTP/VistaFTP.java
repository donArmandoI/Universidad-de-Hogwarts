/**
 * 
 */
package ftp.vistaFTP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.apache.commons.net.ftp.FTPFile;

/**
 * @author Natalia
 *
 */
public class VistaFTP extends JPanel {
	JPanel ftpJpanelHeadline = new JPanel();
	JPanel ftpJpanelButtons = new JPanel();
	JPanel ftpJpanelContentFicheros = new JPanel();
	ArrayList<JpanelFichero> ftpArrayListFicheros = new ArrayList<JpanelFichero>();

	JScrollPane scroll;

	JButton ftpJbuttonUser;
	JTextField ftpJtextfieldURL;
	JButton ftpJbuttonReturn;

	JButton ftpJbuttonUpload;
	JButton ftpJbuttonDownload;
	JButton ftpJbuttonRename;
	JButton ftpJbuttonCreate;
	JButton ftpJbuttonDelete;

	private JPanel panelPrueba;

	public VistaFTP() {
		crearItems();
		propiedades();
	}

	private void crearItems() {
		// TODO Auto-generated method stub
		ftpJbuttonUser = new JButton();
		ftpJbuttonUser.setBackground(Color.white);

		ftpJtextfieldURL = new JTextField(60);
		ftpJtextfieldURL.setEditable(false);

		ftpJbuttonReturn = new JButton();
		ftpJbuttonReturn.setBackground(new Color(255, 253, 150));
		// ftpJbuttonReturn.setBorder(null);

		ftpJbuttonReturn.setIcon(new ImageIcon("imagenesFTP/arrow.png"));

		ftpJpanelHeadline.add(ftpJbuttonUser);
		ftpJpanelHeadline.add(ftpJtextfieldURL);
		ftpJpanelHeadline.add(ftpJbuttonReturn);

		ftpJbuttonUpload = new JButton("Subir");
		ftpJbuttonDownload = new JButton("Bajar");
		ftpJbuttonRename = new JButton("Renombrar");
		ftpJbuttonCreate = new JButton("Crear");
		ftpJbuttonDelete = new JButton("Eliminar");

		ftpJpanelButtons.add(ftpJbuttonUpload);
		ftpJpanelButtons.add(ftpJbuttonDownload);
		ftpJpanelButtons.add(ftpJbuttonRename);
		ftpJpanelButtons.add(ftpJbuttonCreate);
		ftpJpanelButtons.add(ftpJbuttonDelete);

		scroll = new JScrollPane(ftpJpanelContentFicheros);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	}

	private void propiedades() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());

		this.setPreferredSize(new Dimension(1520, 750));

		ftpJpanelHeadline.setBackground(new Color(255, 253, 150));

		ftpJpanelContentFicheros.setBackground(Color.white);
		ftpJpanelContentFicheros.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(255, 253, 150)));

		ftpJpanelButtons.setBackground(new Color(255, 253, 150));

		panelPrueba = new JPanel();

		panelPrueba.setLayout(new FlowLayout());

		this.add(ftpJpanelHeadline, BorderLayout.NORTH);
		// this.add(scroll, BorderLayout.CENTER);
		this.add(ftpJpanelButtons, BorderLayout.SOUTH);
	}

	public void updateIconsView(FTPFile[] files) {

		ftpArrayListFicheros.clear();

		for (int i = 0; i < files.length; i++) {
			addDocsIcons(files[i].getType(), files[i].getName());

			System.out.println(files[i].getType() + " " + files[i].getName());
		}

		// this.remove(panelPrueba);

		panelPrueba.removeAll();

		for (int i = 0; i < ftpArrayListFicheros.size(); i++) {
			panelPrueba.add(ftpArrayListFicheros.get(i));
		}

		this.add(panelPrueba, BorderLayout.CENTER);
		this.updateUI();
	}

	private void addDocsIcons(int type, String name) {

		JpanelFichero fichero;

		if (type == 0) {
			// Es archivo
			fichero = new JpanelFichero(false, name);
		} else {
			// Es directorio
			fichero = new JpanelFichero(true, name);
		}

		ftpArrayListFicheros.add(fichero);
	}

	/**
	 * @return the ftpJpanelContentFicheros
	 */
	public JPanel getFtpJpanelContentFicheros() {
		return ftpJpanelContentFicheros;
	}

	/**
	 * @return the ftpArrayListFicheros
	 */
	public ArrayList<JpanelFichero> getFtpArrayListFicheros() {
		return ftpArrayListFicheros;
	}

	/**
	 * @return the scroll
	 */
	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * @return the ftpJbuttonUser
	 */
	public JButton getFtpJbuttonUser() {
		return ftpJbuttonUser;
	}

	/**
	 * @return the ftpJtextfieldURL
	 */
	public JTextField getFtpJtextfieldURL() {
		return ftpJtextfieldURL;
	}

	/**
	 * @return the ftpJbuttonReturn
	 */
	public JButton getFtpJbuttonReturn() {
		return ftpJbuttonReturn;
	}

	/**
	 * @return the ftpJbuttonUpload
	 */
	public JButton getFtpJbuttonUpload() {
		return ftpJbuttonUpload;
	}

	/**
	 * @return the ftpJbuttonDownload
	 */
	public JButton getFtpJbuttonDownload() {
		return ftpJbuttonDownload;
	}

	/**
	 * @return the ftpJbuttonRename
	 */
	public JButton getFtpJbuttonRename() {
		return ftpJbuttonRename;
	}

	/**
	 * @return the ftpJbuttonCreate
	 */
	public JButton getFtpJbuttonCreate() {
		return ftpJbuttonCreate;
	}

	/**
	 * @return the ftpJbuttonDelete
	 */
	public JButton getFtpJbuttonDelete() {
		return ftpJbuttonDelete;
	}

}
