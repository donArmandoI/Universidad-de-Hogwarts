package common;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import common.vistaPrincipal.VistaPrincipal;
import login.vistaLoginSignin.VistaLogin;
import login.vistaLoginSignin.VistaSignin;

public class EventAction implements ActionListener {

	private String action;

	private VistaLogin login;
	private VistaSignin signin;

	private ControllerMain mainController;

	private DataOutputStream dataOut;
	private DataInputStream dataIn;

	private Usuario user;

	public EventAction(VistaLogin login, VistaSignin signin, Socket cli) {

		this.login = login;
		this.signin = signin;
		this.mainController = new ControllerMain(cli);
		try {

			dataOut = new DataOutputStream(cli.getOutputStream());
			dataIn = new DataInputStream(cli.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buton = (JButton) e.getSource();

		action = buton.getText();

		System.out.println(action);

		if (buton == login.getLoginJbuttonLogin()) {
			iniciarLogin(action);
		}

		if (buton == login.getLoginJbuttonSignin()) {
			limpiarTextos();
			cambiarSignin();
		}

		if (buton == signin.getSigninJbuttonSignin()) {
			iniciarSignin(action);
		}

		if (buton == signin.getSigninJbuttonLogin()) {
			limpiarTextos();
			cambiarLogin();
		}
	}

	private void iniciarSignin(String action) {
		try {
			if (comprobarDatos(action)) {

				dataOut.writeUTF(action);

				dataOut.writeUTF(signin.getSigninJtextfieldUsername().getText());
				dataOut.writeUTF(signin.getSigninJtextfieldName().getText());
				dataOut.writeUTF(signin.getSigninJtextfieldSurname().getText());
				dataOut.writeBoolean(signin.getSigninJcheckboxTeacher().isSelected());
				dataOut.writeUTF(signin.getSigninJtextfieldEmail().getText());
				dataOut.writeUTF(String.valueOf(signin.getSigninJPasswordfieldPassword().getPassword()));

				if (dataIn.readBoolean()) {

					System.out.println("USUARIO CREADO");

					limpiarTextos();
					cambiarLogin();

				} else {

					signin.getSigninJtextfieldUsername().setBorder(new LineBorder(Color.red, 2));
					System.err.println("USUARIO NO CREADO");
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void iniciarLogin(String action) {
		try {
			if (comprobarDatos(action)) {

				dataOut.writeUTF(action);

				dataOut.writeUTF(login.getLoginJtextfieldUsername().getText());
				dataOut.writeUTF(String.valueOf(login.getLoginJPasswordfieldPassword().getPassword()));

				String url = dataIn.readUTF();

				if (!url.equals("")) {

					dataOut.writeUTF(login.getLoginJtextfieldUsername().getText());
					dataOut.writeUTF(String.valueOf(login.getLoginJPasswordfieldPassword().getPassword()));

					user = new Usuario(login.getLoginJtextfieldUsername().getText(), dataIn.readUTF(), dataIn.readUTF(),
							dataIn.readBoolean(), dataIn.readUTF(),
							String.valueOf(login.getLoginJPasswordfieldPassword().getPassword()), url);

					System.out.println(
							user.getUserName() + " " + user.getName() + " " + user.getSurName() + " " + user.isTeacher()
									+ " " + user.getEmail() + " " + user.getPassword() + " " + user.getUrl());
					
					mainController.setUser(user);
					mainController.generateElements();
					
				} else {

					System.err.println("USUARIO NO ENCONTRADO");
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean comprobarDatos(String vistaSeleccionada) {

		boolean correcto = true;

		if (vistaSeleccionada.equals(TextES.getSigninStringLogin())) {

			// COMPROBAR USERNAME
			if (!Tools.comprobarUserName(login.getLoginJtextfieldUsername().getText())) {
				login.getLoginJtextfieldUsername().setBorder(new LineBorder(Color.red, 2));
				correcto = false;
			} else {
				login.getLoginJtextfieldUsername().setBorder(new LineBorder(Color.black, 1));
			}

			// COMPROBAR PASSWORD
			if (!Tools.comprobarPassword(String.valueOf(login.getLoginJPasswordfieldPassword().getPassword()))) {
				login.getLoginJPasswordfieldPassword().setBorder(new LineBorder(Color.red, 2));
				correcto = false;
			} else {
				login.getLoginJPasswordfieldPassword().setBorder(new LineBorder(Color.black, 1));
			}

		} else {

			// COMPROBAR USERNAME
			if (!Tools.comprobarUserName(signin.getSigninJtextfieldUsername().getText())) {
				signin.getSigninJtextfieldUsername().setBorder(new LineBorder(Color.red, 2));
				correcto = false;
			} else {
				signin.getSigninJtextfieldUsername().setBorder(new LineBorder(Color.black, 1));
			}

			// COMPROBAR NAME
			if (!Tools.comprobarNameSurName(signin.getSigninJtextfieldName().getText())) {
				signin.getSigninJtextfieldName().setBorder(new LineBorder(Color.red, 2));
				correcto = false;
			} else {
				signin.getSigninJtextfieldName().setBorder(new LineBorder(Color.black, 1));
			}

			// COMPROBAR SURNAME
			if (!Tools.comprobarNameSurName(signin.getSigninJtextfieldSurname().getText())) {
				signin.getSigninJtextfieldSurname().setBorder(new LineBorder(Color.red, 2));
				correcto = false;
			} else {
				signin.getSigninJtextfieldSurname().setBorder(new LineBorder(Color.black, 1));
			}

			// COMPROBAR EMAIL
			if (!Tools.comprobarEmail(signin.getSigninJtextfieldEmail().getText())) {
				signin.getSigninJtextfieldEmail().setBorder(new LineBorder(Color.red, 2));
				correcto = false;
			} else {
				signin.getSigninJtextfieldEmail().setBorder(new LineBorder(Color.black, 1));
			}

			// COMPROBAR PASSWORD
			if (!Tools.comprobarPassword(String.valueOf(signin.getSigninJPasswordfieldPassword().getPassword()))) {
				signin.getSigninJPasswordfieldPassword().setBorder(new LineBorder(Color.red, 2));
				correcto = false;
			} else {
				signin.getSigninJPasswordfieldPassword().setBorder(new LineBorder(Color.black, 1));
			}
		}

		return correcto;
	}

	private void limpiarTextos() {
		// LOG IN
		login.getLoginJtextfieldUsername().setText("");
		login.getLoginJtextfieldUsername().setBorder(new LineBorder(Color.black, 1));

		login.getLoginJPasswordfieldPassword().setText("");
		login.getLoginJPasswordfieldPassword().setBorder(new LineBorder(Color.black, 1));

		// SIGN IN
		signin.getSigninJtextfieldUsername().setText("");
		signin.getSigninJtextfieldUsername().setBorder(new LineBorder(Color.black, 1));

		signin.getSigninJtextfieldName().setText("");
		signin.getSigninJtextfieldName().setBorder(new LineBorder(Color.black, 1));

		signin.getSigninJtextfieldSurname().setText("");
		signin.getSigninJtextfieldSurname().setBorder(new LineBorder(Color.black, 1));

		signin.getSigninJcheckboxTeacher().setSelected(false);

		signin.getSigninJtextfieldEmail().setText("");
		signin.getSigninJtextfieldEmail().setBorder(new LineBorder(Color.black, 1));

		signin.getSigninJPasswordfieldPassword().setText("");
		signin.getSigninJPasswordfieldPassword().setBorder(new LineBorder(Color.black, 1));
	}

	private void cambiarLogin() {
		signin.setVisible(false);
		login.setVisible(true);
	}

	private void cambiarSignin() {
		login.setVisible(false);
		signin.setVisible(true);
	}
}
