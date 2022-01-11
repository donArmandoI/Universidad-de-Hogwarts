package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

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
	private ObjectOutputStream objectOut;
	private ObjectInputStream objectIn;

	private Datos data;
	private Conexion conn;

	private FtpServer ftpServ;
	private final int PORT = 5000;
	private String username = "";
	private String password = "";
	private String root = "";
	private FtpServerFactory serverFactory;
	private ListenerFactory listenerFactory;
	private BaseUser user;

	public HiloServer(Socket cliente) {
		h = new Thread(this);
		this.cliente = cliente;
		data = new Datos("universidadhogwarts");
		conn = new Conexion();
		conn.startConnection(data.getDriver_JDBC(), data.getUrl_JDBC(), data.getDb_DJBC(), data.getUsu_JDBC(),
				data.getPass_JDBC());

		try {
			dataIn = new DataInputStream(cliente.getInputStream());
			dataOut = new DataOutputStream(cliente.getOutputStream());

			objectOut = new ObjectOutputStream(cliente.getOutputStream());
			objectIn = new ObjectInputStream(cliente.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String accion = "";

		do {
			try {
				System.out.println(h.getName() + " START ");

				accion = dataIn.readUTF();

				System.out.println("LEIDO");

				switch (accion) {
				case "Log in":
					System.out.println("ENTRA EN LOG IN");
					String url = comprobarUsuario();
					dataOut.writeUTF(url);
					if (!url.equals("")) {
						enviarDatosUsuario(dataIn.readUTF());
					}
					break;
				case "Sign in":
					System.out.println("ENTRA EN SIGN IN");
					dataOut.writeBoolean(crearSesion());
					break;
				case "Subir":
					break;
				case "Bajar":
					break;
				case "Renombrar":
					break;
				case "Eliminar":
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
				url = "\\alumnos\\";
			} else {
				url = "\\profesores\\";
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
