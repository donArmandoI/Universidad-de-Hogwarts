package ftp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import common.Usuario;
import ftp.vistaFTP.VistaCreate;
import ftp.vistaFTP.VistaFTP;

public class ActionFTPButtons implements ActionListener {

	private VistaFTP vistaFTP;
	private Usuario user;
	private FTPClient ftpClient;

	public ActionFTPButtons(VistaFTP vistaFTP, Usuario user, FTPClient ftpClient) {
		this.ftpClient = ftpClient;
		this.user = user;
		this.vistaFTP = vistaFTP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton b = (JButton) e.getSource();

		if (b == vistaFTP.getFtpJbuttonCreate()) {
			// CREAR CARPETA

			// bloquearBotones(false);

			VistaCreate v = new VistaCreate("CREAR");
			v.setVisible(true);

			v.getCreateJbuttonConfirm().addActionListener(new ActionCreate(ftpClient, user, vistaFTP, v));

		} else if (b == vistaFTP.getFtpJbuttonDelete()) {
			// ELIMINAR ARCHIVO

			if (!user.getSelectedElement().equals("") && user.getSelectedElement() != null) {

				try {

					// boolean done = ftpClient.deleteFile();
					boolean done = ftpClient.deleteFile(user.getSelectedElement());

					if (done) {
						System.out.println("ARCHIVO ELIMINADO");
						vistaFTP.updateIconsView(ftpClient.listFiles(user.getUrlActual()));
						user.setSelectedElement("");
					} else {

						done = ftpClient.removeDirectory(user.getSelectedElement());

						if (done) {
							System.out.println("CARPETA ELIMINADO");
							vistaFTP.updateIconsView(ftpClient.listFiles(user.getUrlActual()));
							user.setSelectedElement("");
						} else {
							System.err.println("NO SE HA ELIMINADO EL ARCHIVO.");
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		} else if (b == vistaFTP.getFtpJbuttonDownload()) {
			// DESCARGAR ARCHIVO

			if (!user.getSelectedElement().equals("") && user.getSelectedElement() != null) {

				JFileChooser fileChooser = new JFileChooser();

				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setDialogTitle("Titulo");

				int returnVal = fileChooser.showDialog(fileChooser, "Aceptar");
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					String name = obtenerName();

					File f = new File(fileChooser.getSelectedFile().getAbsolutePath() + File.separator + name);
					try {

						FileOutputStream out = new FileOutputStream(f);

						ftpClient.retrieveFile(user.getSelectedElement(), out);

						user.setSelectedElement("");

						out.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}

		} else if (b == vistaFTP.getFtpJbuttonRename()) {
			// RENOMBRAR ARCHIVO

			if (!user.getSelectedElement().equals("") && user.getSelectedElement() != null) {

				// bloquearBotones(false);
				VistaCreate v = new VistaCreate("RENOMBRAR");
				v.setVisible(true);

				v.getCreateJbuttonConfirm().addActionListener(new ActionRename(ftpClient, user, vistaFTP, v));
			}

		} else if (b == vistaFTP.getFtpJbuttonReturn()) {
			// REGRESAR A LA ESTANCIA ANTERIOR

			System.out.println(user.getUrlActual());

			if (!user.getUrlActual().equals("/")) {
				String[] rutas = user.getUrlActual().split("/");

				String url = "/";

				for (int i = 0; i < rutas.length - 1; i++) {
					url += rutas[i] + "/";
				}

				System.out.println(url);

				user.setUrlActual(url);
				user.setSelectedElement("");

				try {
					vistaFTP.updateIconsView(ftpClient.listFiles(url));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				System.err.println("NO PUEDES IR SALIR DE TU CARPETA RAIZ.");
			}

		} else if (b == vistaFTP.getFtpJbuttonUpload()) {
			// SUBIR ARCHIVO

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fileChooser.setDialogTitle("Titulo");

			int returnVal = fileChooser.showDialog(fileChooser, "Aceptar");
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
				FileInputStream in;
				try {
					ftpClient.changeWorkingDirectory(user.getUrlActual());
					in = new FileInputStream(f);
					ftpClient.storeFile(f.getName(), in);

					if (user.isTeacher()) {
						ftpClient.changeWorkingDirectory("/alumnos/" + user.getUserName());
					} else {
						ftpClient.changeWorkingDirectory("/profesores/" + user.getUserName());
					}

					vistaFTP.updateIconsView(ftpClient.listFiles(user.getUrlActual()));

					in.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}

		} else {
			// REGRESAR A LA CARPETA DEFAULT DEL USUARIO
			try {
				if (!user.getUrlActual().equals(ftpClient.printWorkingDirectory())) {
					user.setUrlActual(ftpClient.printWorkingDirectory());
					user.setSelectedElement("");
					vistaFTP.updateIconsView(ftpClient.listFiles());
				} else {
					System.err.println("YA TE ENCUENTRAS EN TU RUTA DEFAULT");
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		// bloquearBotones(true);
		addDirectoryListeners();
	}

	private String obtenerName() {
		String name = "";

		String[] rutas = user.getSelectedElement().split("/");

		name = rutas[rutas.length - 1];

		return name;
	}

	private void addDirectoryListeners() {

		for (int i = 0; i < vistaFTP.getFtpArrayListFicheros().size(); i++) {

			vistaFTP.getFtpArrayListFicheros().get(i).getContentJbuttonImagenFile()
					.addMouseListener(new ActionSelected(vistaFTP, user, ftpClient));
		}
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
