package ftp;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import common.Usuario;
import ftp.vistaFTP.VistaFTP;

public class ActionSelected implements MouseListener {

	private VistaFTP vistaFtp;
	private Usuario user;
	private FTPClient ftpClient;

	public ActionSelected(VistaFTP vistaFtp, Usuario user, FTPClient ftpClient) {
		this.ftpClient = ftpClient;
		this.user = user;
		this.vistaFtp = vistaFtp;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		String name = comprobarBoton(e);

		if (e.getClickCount() == 1) {

			user.setSelectedElement(user.getUrlActual() + "/" + name);

		} else if (e.getClickCount() == 2) {

			try {

				FTPFile[] files = ftpClient.listFiles(user.getUrlActual());

				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().equals(name)) {
						if (files[i].getType() == 1) {

							user.setUrlActual(user.getUrlActual() + "/" + name);
							user.setSelectedElement("");

							vistaFtp.updateIconsView(ftpClient.listFiles(user.getUrlActual()));
							addDirectoryListeners();
						}
					}
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	private String comprobarBoton(MouseEvent e) {

		JButton button = (JButton) e.getSource();

		for (int i = 0; i < vistaFtp.getFtpArrayListFicheros().size(); i++) {

			if (button == vistaFtp.getFtpArrayListFicheros().get(i).getContentJbuttonImagenFile()) {

				// vistaFtp.getFtpArrayListFicheros().get(i).setBackground(Color.blue);

				return vistaFtp.getFtpArrayListFicheros().get(i).getContentJlabelFile().getText();
			}
		}

		return "";
	}

	private void addDirectoryListeners() {

		for (int i = 0; i < vistaFtp.getFtpArrayListFicheros().size(); i++) {

			System.out.println(
					"*****EVENTO A " + vistaFtp.getFtpArrayListFicheros().get(i).getContentJlabelFile().getText());

			vistaFtp.getFtpArrayListFicheros().get(i).getContentJbuttonImagenFile()
					.addMouseListener(new ActionSelected(vistaFtp, user, ftpClient));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
