package common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {

		iniciarCliente();
	}

	private static void iniciarCliente() {

		DataOutputStream dataOut;
		DataInputStream dataIn;

		ObjectOutputStream objectOut;
		ObjectInputStream objectIn;

		Socket cli;

		Usuario user;

		try {
			cli = new Socket("localhost", 6000);

			dataOut = new DataOutputStream(cli.getOutputStream());
			dataIn = new DataInputStream(cli.getInputStream());

			objectOut = new ObjectOutputStream(cli.getOutputStream());
			objectIn = new ObjectInputStream(cli.getInputStream());

			user = new Usuario("alumnoPrueba", "Alumno", "De Prueba", false, "alumno@prueba.com", "A123456a",
					"\\alumnos\\alumnoPrueba\\");
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
