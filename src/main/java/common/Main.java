package common;

import login.vistaLoginSignin.VistaLogin;

public class Main {

	public static void main(String[] args) {

		VistaLogin login = new VistaLogin();
		// signin = new VistaSignin();
		login.setVisible(true);
		// signin.setVisible(false);

		/*
		try {
			Socket cli = new Socket("localhost", 6000);

			login.getLoginJbuttonLogin().addActionListener(new EventAction("Log in", 0, login, signin, cli));
			login.getLoginJbuttonSignin().addActionListener(new EventAction("Sign in", 0, login, signin, cli));

			signin.getSigninJbuttonSignin().addActionListener(new EventAction("Sign in", 1, login, signin, cli));
			signin.getSigninJbuttonLogin().addActionListener(new EventAction("Log in", 1, login, signin, cli));

		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
}
