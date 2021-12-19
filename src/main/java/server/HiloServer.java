package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

	}

	private boolean comprobarUsuario(String accion) {

		// Se lee primero USERNAME y PASSWORD

		String userName;
		String password;

		try {
			userName = dataIn.readUTF();
			password = dataIn.readUTF();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}
}
