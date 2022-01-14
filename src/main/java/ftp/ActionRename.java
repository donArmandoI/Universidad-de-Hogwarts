package ftp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

import common.Usuario;
import ftp.vistaFTP.VistaCreate;
import ftp.vistaFTP.VistaFTP;

public class ActionRename implements ActionListener {

	private FTPClient ftpClient;
	private Usuario user;
	private VistaFTP vistaFTP;
	private VistaCreate v;

	public ActionRename(FTPClient ftpClient, Usuario user, VistaFTP vistaFTP, VistaCreate v) {
		this.ftpClient = ftpClient;
		this.user = user;
		this.vistaFTP = vistaFTP;
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String name = v.getCreateJtextfieldName().getText();
		String url = user.getUrlActual() + "/" + name;

		try {
			ftpClient.rename(user.getSelectedElement(), url);

			user.setSelectedElement("");

			vistaFTP.updateIconsView(ftpClient.listFiles(user.getUrlActual()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
