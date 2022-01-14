package ftp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import common.Usuario;
import ftp.vistaFTP.VistaCreate;
import ftp.vistaFTP.VistaFTP;

public class ActionCreate implements ActionListener {

	private FTPClient ftpClient;
	private Usuario user;
	private VistaFTP vistaFTP;
	private VistaCreate v;

	public ActionCreate(FTPClient ftpClient, Usuario user, VistaFTP vistaFTP, VistaCreate v) {
		this.ftpClient = ftpClient;
		this.user = user;
		this.vistaFTP = vistaFTP;
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String name = v.getCreateJtextfieldName().getText();
		String url = user.getUrlActual() + "//" + name;

		try {
			ftpClient.makeDirectory(url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		v.dispose();

		try {
			vistaFTP.updateIconsView(ftpClient.listFiles(user.getUrlActual()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		bloquearBotones(true);
	}

	private void bloquearBotones(boolean habilitado) {
		vistaFTP.getFtpJbuttonCreate().setEnabled(habilitado);
		vistaFTP.getFtpJbuttonDelete().setEnabled(habilitado);
		vistaFTP.getFtpJbuttonDownload().setEnabled(habilitado);
		vistaFTP.getFtpJbuttonRename().setEnabled(habilitado);
		vistaFTP.getFtpJbuttonReturn().setEnabled(habilitado);
		vistaFTP.getFtpJbuttonUpload().setEnabled(habilitado);
		vistaFTP.getFtpJbuttonUser().setEnabled(habilitado);
	}
}
