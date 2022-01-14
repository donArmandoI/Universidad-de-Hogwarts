/**
 * 
 */
package ftp.vistaFTP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import common.TextES;


/**
 * @author Natalia
 *
 */
public class VistaFTP extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 284683610640490861L;
	JPanel ftpJpanelHeadline = new JPanel();
	JPanel ftpJpanelButtons = new JPanel();
	JPanel ftpJpanelContentFicheros = new JPanel();
	ArrayList<JpanelFichero> ftpArrayListFicheros = new ArrayList<JpanelFichero>();

	JList<Object> ftpJlistFilename;
	JScrollPane scroll;

	JButton ftpJbuttonUser;
	JTextField ftpJtextfieldURL;
	JButton ftpJbuttonReturn;

	JButton ftpJbuttonUpload;
	JButton ftpJbuttonDownload;
	JButton ftpJbuttonRename;
	JButton ftpJbuttonCreate;
	JButton ftpJbuttonDelete;

	public VistaFTP() {
		crearItems();
		propiedades();
	}

	private void crearItems() {
		// TODO Auto-generated method stub
		ftpJbuttonUser = new JButton();
		ftpJbuttonUser.setBackground(Color.white);

		ftpJtextfieldURL = new JTextField(60);

		ftpJbuttonReturn = new JButton();
		ftpJbuttonReturn.setSelectedIcon(new ImageIcon(VistaFTP.class.getResource("/ftp/vistaFTP/imagenesFTP/arrow.png")));
		ftpJbuttonReturn.setBackground(new Color(255, 253, 150));
		ftpJbuttonReturn.setBorder(null);

		ftpJbuttonReturn.setIcon(new ImageIcon(VistaFTP.class.getResource("/ftp/vistaFTP/imagenesFTP/arrow.png")));

		ftpJpanelHeadline.add(ftpJbuttonUser);
		ftpJpanelHeadline.add(ftpJtextfieldURL);
		ftpJpanelHeadline.add(ftpJbuttonReturn);

		ftpJbuttonUpload = new JButton(TextES.getFtpStringUpload());
		ftpJbuttonDownload = new JButton(TextES.getFtpStringDownload());
		ftpJbuttonRename = new JButton(TextES.getFtpStringRename());
		ftpJbuttonCreate = new JButton(TextES.getFtpStringCreate());
		ftpJbuttonDelete = new JButton(TextES.getFtpStringDelete());

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

		ftpJpanelHeadline.setBackground(new Color(255, 253, 150));

		ftpJpanelContentFicheros.setBackground(Color.white);
		ftpJpanelContentFicheros.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(255, 253, 150)));

		ftpJpanelButtons.setBackground(new Color(255, 253, 150));

		add(ftpJpanelHeadline, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(ftpJpanelButtons, BorderLayout.SOUTH);
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
