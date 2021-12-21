package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import login.vistaLoginSignin.VistaLogin;
import login.vistaLoginSignin.VistaSignin;

public class EventAction implements ActionListener {

	private String action;
	private int position;

	private VistaLogin login;
	private VistaSignin signin;

	private Socket cli;

	private DataOutputStream dataOut;
	private DataInputStream dataIn;

	private ObjectOutputStream objectOut;
	private ObjectInputStream objectIn;

	private Usuario user;

	public EventAction(String action, int position, VistaLogin login, VistaSignin signin, Socket cli) {
		this.action = action;
		this.position = position;

		this.login = login;
		this.signin = signin;

		this.cli = cli;

		try {

			dataOut = new DataOutputStream(cli.getOutputStream());
			dataIn = new DataInputStream(cli.getInputStream());

			objectOut = new ObjectOutputStream(cli.getOutputStream());
			objectIn = new ObjectInputStream(cli.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (action.equals("Log in")) {
			if (position == 0) {
				try {
					dataOut.writeUTF(action);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				iniciarLogin();
			} else {
				cambiarSignin();
			}
		} else {
			if (position == 0) {
				try {
					dataOut.writeUTF(action);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				iniciarSignin();
			} else {
				cambiarLogin();
			}
		}
	}

	private void cambiarLogin() {

	}

	private void cambiarSignin() {

	}

	private void iniciarSignin() {
		try {

			if (comprobarUserName(signin.getSigninJtextfieldUsername().getText())) {
				System.out.println("\nNOMBRE CORRECTO\n");
			} else {
				System.out.println("\nNOMBRE INCORRECTO\n");
			}

			dataOut.writeUTF(signin.getSigninJtextfieldUsername().getText());
			dataOut.writeUTF(signin.getSigninJtextfieldName().getText());
			dataOut.writeUTF(signin.getSigninJtextfieldSurname().getName());
			dataOut.writeBoolean(signin.getSigninJcheckboxTeacher().isSelected());
			dataOut.writeUTF(signin.getSigninJtextfieldEmail().getText());
			dataOut.writeUTF(String.valueOf(signin.getSigninJPasswordfieldPassword().getPassword()));

			user = (Usuario) objectIn.readObject();

			if (user != null) {

				System.out.println("USUARIO CREADO");

			} else {

				System.err.println("USUARIO NO CREADO");

			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private boolean comprobarUserName(String userName) {

		boolean correcto = userName.matches("/[.,+*%&@':;|#=?$]/");

		return correcto;
	}

	private void iniciarLogin() {
		try {

			dataOut.writeUTF(login.getLoginJtextfieldUsername().getText());
			dataOut.writeUTF(String.valueOf(login.getLoginJPasswordfieldPassword().getPassword()));

			user = (Usuario) objectIn.readObject();

			if (user != null) {

				System.out.println("USUARIO ENCONTRADO");

			} else {

				System.err.println("USUARIO NO ENCONTRADO");

			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
