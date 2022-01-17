package ftp;

import java.io.IOException;
import java.net.Socket;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import common.Usuario;
import common.WindowsAct;
import common.vistaPrincipal.VistaPrincipal;
import ftp.vistaFTP.VistaFTP;

public class ControladorFTPCliente {

	private VistaFTP vistaFTP;

	private WindowsAct win;

	private Usuario user;
	private Socket cli;

	private String servFTP = "localhost";

	private FTPClient ftpClient;

	public ControladorFTPCliente(Usuario user, Socket cli, VistaFTP vistaFtp) {

		this.user = user;
		this.cli = cli;
		this.vistaFTP = vistaFtp;

		this.ftpClient = new FTPClient();

		try {
			this.ftpClient.connect(servFTP, 6000);

			boolean login = ftpClient.login(user.getUserName(), user.getPassword());

			if (login) {

				win = new WindowsAct(cli, ftpClient);

//				vistaFTP = new VistaFTP();

				vistaFTP.getFtpJbuttonUser().setText(user.getName());
				vistaFTP.getFtpJtextfieldURL().setText(user.getUrl());

				user.setUrlActual(ftpClient.printWorkingDirectory());
				
				vistaFTP.setVisible(true);


				try {
					vistaFTP.updateIconsView(ftpClient.listFiles(user.getUrlActual()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				addListeners();
				addDirectoryListeners();

			} else {
				System.err.println("CLIENTE INCORRECTO");
				ftpClient.disconnect();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addDirectoryListeners() {

		for (int i = 0; i < vistaFTP.getFtpArrayListFicheros().size(); i++) {

			vistaFTP.getFtpArrayListFicheros().get(i).getContentJbuttonImagenFile()
					.addMouseListener(new ActionSelected(vistaFTP, user, ftpClient));
		}
	}

	private void addListeners() {

		ActionFTPButtons act = new ActionFTPButtons(vistaFTP, user, ftpClient);

		vistaFTP.getFtpJbuttonCreate().addActionListener(act);
		vistaFTP.getFtpJbuttonReturn().addActionListener(act);
		vistaFTP.getFtpJbuttonUser().addActionListener(act);
		vistaFTP.getFtpJbuttonDelete().addActionListener(act);
		vistaFTP.getFtpJbuttonDownload().addActionListener(act);
		vistaFTP.getFtpJbuttonRename().addActionListener(act);
		vistaFTP.getFtpJbuttonUpload().addActionListener(act);
	}
}
