package common;

import common.vistaPrincipal.VistaPrincipal;
import correo.vistaCorreo.VistaCorreo;
import ftp.vistaFTP.VistaFTP;
import login.vistaLoginSignin.VistaLogin;

public class Main {

	public static void main(String[] args) {
		VistaCorreo vista = new VistaCorreo();
		//VistaPrincipal vista = new VistaPrincipal();
		//VistaLogin vista = new VistaLogin();
		vista.setVisible(true);

		String name = "";
		
		Tools.showConsoleText(name);
	}

}
