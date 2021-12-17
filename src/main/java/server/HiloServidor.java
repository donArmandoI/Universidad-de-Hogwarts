package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;

public class HiloServidor implements Runnable {

	private Socket cliente;
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private ObjectOutputStream objectOut;
	private ObjectInputStream objectIn;
	private String rutaDefault;
	private String nombre;
	private boolean profesor;
	private String rutaCentral;
	private String rutaActual;
	private String action;
	private boolean login;

	public HiloServidor(Socket cliente) {
		this.cliente = cliente;
		rutaCentral = "C:\\UNI";
		rutaActual = rutaDefault;
		login = true;
		profesor = false;
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
			rutaDefault = dataIn.readUTF();
			rutaActual = rutaDefault;
			nombre = dataIn.readUTF();
			profesor = dataIn.readBoolean();

			File f = new File(rutaCentral + rutaDefault);
			if (f.exists() && f.isDirectory()) {
				System.out.println("Ya existe la carpeta");
			} else {
				f.mkdir();
			}

			listarArchivos(f);
			while (login) {
				action = dataIn.readUTF();

				if (!action.toLowerCase().equals("cerrar")) {
					rutaActual = rutaDefault + dataIn.readUTF();
				}

				switch (action.toLowerCase()) {
				case "subir":
					subirElemento("");
					break;
				case "bajar":
					bajarElemento("");
					break;
				case "renombrar":

					break;
				case "crear":
					f = new File(rutaActual + dataIn.readUTF());
					crearCarpeta(f);
					break;
				case "eliminar":
					boolean completado = eliminarElemento(rutaActual + dataIn.readUTF());
					dataOut.writeBoolean(completado);
					break;
				case "cambiar":
					cambiarDirectorio(dataIn.readUTF());
					break;
				case "cerrar":
					login = false;
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void subirElemento(String nombre) {
		File f = new File(rutaDefault + rutaActual + nombre);
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
				out.writeObject(out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}

	private void bajarElemento(String nombre) {
		File f = new File(rutaDefault + rutaActual + nombre);
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
			byte[] conjunto = new byte[(int) f.length()];
			int i = 0;
			int j = 0;

			while ((i = in.read()) != -1) {
				conjunto[j] = (byte) i;
				j++;
			}

			dataOut.writeInt(conjunto.length);

			for (i = 0; i < conjunto.length; i++) {
				dataOut.writeByte(conjunto[i]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void renombrarElemento() {

	}

	private boolean crearCarpeta(File f) {
		if (!f.exists()) {
			f.mkdir();
			return true;
		}
		return false;
	}

	private void cambiarDirectorio(String nuevaRuta) {
		rutaActual = rutaDefault + nuevaRuta;
		File f = new File(rutaActual);
		listarArchivos(f);
	}

	private boolean eliminarElemento(String ruta) {
		String grupo;
		int posUni = -1;
		String[] rutas = ruta.split("\\\\");
		for (int i = 0; i < rutas.length; i++) {
			if (rutas[i].equals("UNI") && posUni == -1) {
				posUni = i;
			}
		}
		grupo = rutas[posUni + 1];

		if (nombre.equals(rutas[posUni + 2])) {
			// Si se puede borrar porque es tú carpeta
			if (posUni + 3 == rutas.length) {
				// Estas intentando borrar tu propia carpeta
				return false;
			}
			File eliminar = new File(ruta);
			if (eliminar.isDirectory()) {
				eliminacionRecursiva(eliminar.listFiles());
			} else {
				eliminar.delete();
			}
			return true;
		} else {
			// No se puede borrar porque no es tú carpeta
			return false;
		}
	}

	private void eliminacionRecursiva(File[] files) {
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory()) {
				eliminacionRecursiva(f.listFiles());
			} else {
				f.delete();
			}
		}
	}

	private void listarArchivos(File f2) {
		File[] f = f2.listFiles();

		try {
			dataOut.writeInt(f.length);
			for (int i = 0; i < f.length; i++) {
				objectOut.writeObject(f[i]);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
