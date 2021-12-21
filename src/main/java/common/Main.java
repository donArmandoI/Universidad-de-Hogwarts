package common;

import correo.ControllerMail;
import correo.vistaCorreo.VistaCorreo;

public class Main {

	public static void main(String[] args) {
		VistaCorreo vista = new VistaCorreo();
		ControllerMail conMail = new ControllerMail(vista);
//		VistaPrincipal vista = new VistaPrincipal();
		//VistaLogin vista = new VistaLogin();
//		vista.setVisible(true);

//		String name = "";
//		
//		Tools.showConsoleText(name);
	}

}
