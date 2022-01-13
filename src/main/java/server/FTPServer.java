package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

public class FTPServer {

	private FtpServer ftpServ;
	private final String HOST = "localhost";
	private final int PORT = 6000;
	private String username = "";
	private String password = "";
	private String root = "";
	private FtpServerFactory serverFactory;
	private ListenerFactory listenerFactory;
	private BaseUser user;

	public FTPServer() {
		this.serverFactory = new FtpServerFactory();
		this.listenerFactory = new ListenerFactory();
		this.listenerFactory.setServerAddress(HOST);
		this.listenerFactory.setPort(PORT);

		serverFactory.addListener("default", listenerFactory.createListener());

		ftpServ = serverFactory.createServer();
		try {
			ftpServ.start();

			ServerSocket server;
			Socket cliente;
			int puerto = 5000;
			Thread hiloServ;

			try {
				server = new ServerSocket(puerto);
				System.out.println("Servidor iniciado...");

				while (true) {
					cliente = new Socket();
					cliente = server.accept();

					hiloServ = new Thread(new HiloServer(cliente, this));
					hiloServ.start();
				}
			} catch (IOException e) {
			}
		} catch (FtpException e1) {
			e1.printStackTrace();
		}

	}

	public synchronized void listarUsuarios() {
		try {

			String[] usuarios = serverFactory.getUserManager().getAllUserNames();

			for (int i = 0; i < usuarios.length; i++) {
				System.out.println(usuarios[i]);
			}

		} catch (FtpException e) {
			e.printStackTrace();
		}

	}

	public synchronized void iniciarUsuario(String userName, String password, String url) {
		try {

			if (serverFactory.getUserManager().getUserByName(userName) == null) {
				ArrayList<Authority> authorities = new ArrayList<Authority>();
				authorities.add(new WritePermission());

				this.user = new BaseUser();
				this.user.setName(userName);
				this.user.setPassword(password);
				this.user.setHomeDirectory(url);
				this.user.setAuthorities(authorities);

				serverFactory.getUserManager().save(user);

				System.out.println("El usuario " + userName + " ha sido creado y almacenado.");

			} else {

				System.out.println("El usuario " + userName + " ya existe.");
			}

		} catch (FtpException e) {
			e.printStackTrace();
		}
	}
}
