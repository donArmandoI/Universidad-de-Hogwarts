package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {

		ServerSocket server;
		Socket cliente;
		int puerto = 6000;
		Thread hiloServ;

		try {
			server = new ServerSocket(puerto);
			System.out.println("Servidor iniciado...");

			while (true) {
				cliente = new Socket();
				cliente = server.accept();

				hiloServ = new Thread(new HiloServer(cliente));
				hiloServ.start();
			}
		} catch (IOException e) {
		}

	}

}
