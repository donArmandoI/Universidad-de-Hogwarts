package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import common.Usuario;

public class HiloServer implements Runnable {

	private Thread h;
	private Socket cliente;

	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private ObjectOutputStream objectOut;
	private ObjectInputStream objectIn;

	private Usuario user;
	private Datos data;
	private Conexion conn;

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
		try {

			String accion = dataIn.readUTF();

			switch (accion) {
			case "Log in":
				objectOut.writeObject(comprobarUsuario());
				break;
			case "Sign in":
				crearSesion();
				break;
			default:
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Usuario crearSesion() {
		String userName;
		String name;
		String surName;
		boolean teacher;
		String email;
		String password;
		String url;

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

			url = url + userName + "\\";

			sql = "SELECT * FROM users WHERE userName = '" + userName + "'";

			conn.setResultSet(sql);

			if (conn.getRs().next()) {
				return null;
			} else {
				return new Usuario(userName, name, surName, teacher, email, password, url);
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Usuario comprobarUsuario() {

		// Se lee primero USERNAME y PASSWORD

		String userName;
		String password;

		String sql;

		try {
			userName = dataIn.readUTF();
			password = dataIn.readUTF();

			sql = "SELECT * FROM users WHERE userName = '" + userName + "' AND password = MD5('" + password + "')";

			System.out.println(sql);

			conn.setResultSet(sql);

			if (conn.getRs().next()) {

				return new Usuario(conn.getRs().getString(1), conn.getRs().getString(2), conn.getRs().getString(3),
						conn.getRs().getBoolean(4), conn.getRs().getString(5), password, conn.getRs().getString(6));

			} else {
				System.err.println("NO HAY USUARIO CON ESA CONTRASEÑA");
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
