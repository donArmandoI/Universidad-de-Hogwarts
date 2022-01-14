package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

public class HiloServer implements Runnable {

	private Thread h;
	private Socket cliente;

	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	
	private Datos data;
	private Conexion conn;

	private final String ROOTURL = "E://UNIVERSIDAD";

	private FTPServer ftpServer;

	public HiloServer(Socket cliente, FTPServer ftpServer) {
		h = new Thread(this);
		this.cliente = cliente;
		data = new Datos("universidadhogwarts");
		conn = new Conexion();
		conn.startConnection(data.getDriver_JDBC(), data.getUrl_JDBC(), data.getDb_DJBC(), data.getUsu_JDBC(),
				data.getPass_JDBC());

		this.ftpServer = ftpServer;

		try {
			dataIn = new DataInputStream(cliente.getInputStream());
			dataOut = new DataOutputStream(cliente.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String accion = "";

		do {
			try {
				System.out.println("\n" + h.getName() + " START ");

				accion = dataIn.readUTF();

				System.out.println("LEIDO");
				System.out.println(accion);
				
				switch (accion) {
				case "Iniciar Sesión":
					System.out.println("ENTRA EN LOG IN");
					String url = comprobarUsuario();
					dataOut.writeUTF(url);
					if (!url.equals("")) {

						String userName = dataIn.readUTF();
						String password = dataIn.readUTF();

						ftpServer.iniciarUsuario(userName, password, ROOTURL + url);

						enviarDatosUsuario(userName);

						ftpServer.listarUsuarios();
					}
					break;
				case "Registrarse":
					System.out.println("ENTRA EN SIGN IN");
					dataOut.writeBoolean(crearSesion());
					break;
				case "CERRAR":
					System.out.println("CERRANDO");
					break;
				default:
					System.err.println("ERROR");
					break;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!accion.equals("CERRAR"));
	}

	private void enviarDatosUsuario(String userName) {
		String sql = "SELECT name, surName, teacher, email FROM users WHERE userName = '" + userName + "'";
		System.out.println(sql);
		conn.setResultSet(sql);

		try {

			conn.getRs().next();

			dataOut.writeUTF(conn.getRs().getString(1));
			dataOut.writeUTF(conn.getRs().getString(2));
			dataOut.writeBoolean(conn.getRs().getBoolean(3));
			dataOut.writeUTF(conn.getRs().getString(4));

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private boolean crearSesion() {
		String userName;
		String name;
		String surName;
		boolean teacher;
		String email;
		String password;
		String url = "";

		String sql;

		try {
			userName = dataIn.readUTF();
			name = dataIn.readUTF();
			surName = dataIn.readUTF();
			teacher = dataIn.readBoolean();
			email = dataIn.readUTF();
			password = dataIn.readUTF();

			if (!teacher) {
				url = "\\\\alumnos\\\\";
			} else {
				url = "\\\\profesores\\\\";
			}

			url = url + userName;

			sql = "SELECT url FROM users WHERE userName = '" + userName + "'";

			conn.setResultSet(sql);

			if (conn.getRs().next()) {
				return false;
			} else {

				sql = "INSERT INTO users VALUES ( '" + userName + "', '" + name + "', '" + surName + "', " + teacher
						+ ", '" + email + "', MD5('" + password + "'), '" + url + "' )";
				System.out.println(sql);

				int filas = conn.setExecuteUpdate(sql);

				System.out.println("El numero de filas añadidas son: " + filas);

				File f = new File(ROOTURL + url);
				System.out.println(f.getPath());
				if (!f.exists()) {
					System.out.println("SE HA CREADO LA CARPETA");
					f.mkdir();
				}
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	private String comprobarUsuario() {

		// Se lee primero USERNAME y PASSWORD

		String userName;
		String password;

		String sql;

		try {
			userName = dataIn.readUTF();
			password = dataIn.readUTF();

			sql = "SELECT url FROM users WHERE userName = '" + userName + "' AND password = MD5('" + password + "')";

			System.out.println(sql);

			conn.setResultSet(sql);

			if (conn.getRs().next()) {

				return conn.getRs().getString(1);

			} else {
				System.err.println("CONTRASEÑA y/o USUARIO \n--INCORRECTO--");
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return "";
	}
}
