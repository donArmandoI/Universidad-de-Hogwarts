package common;

/**
 * @author Israel
 *
 */
import java.io.IOException;
import java.net.Socket;

import common.vistaPrincipal.VistaPrincipal;
import login.vistaLoginSignin.VistaLogin;
import login.vistaLoginSignin.VistaSignin;

public class Main {

	public static void main(String[] args) {

		Tuberia tub = new Tuberia();

		VistaLogin login = new VistaLogin();
		VistaSignin signin = new VistaSignin();
//		VistaPrincipal mainView = new VistaPrincipal();
		login.setVisible(true);
		signin.setVisible(false);

		try {
			Socket cli = new Socket("localhost", 5000);

			EventAction ev = new EventAction(login, signin, cli);
			WindowsAct win = new WindowsAct(cli);

			login.getLoginJbuttonLogin().addActionListener(ev);
			login.getLoginJbuttonSignin().addActionListener(ev);
			login.addWindowListener(win);

			signin.getSigninJbuttonSignin().addActionListener(ev);
			signin.getSigninJbuttonLogin().addActionListener(ev);
			signin.addWindowListener(win);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
