package common;

import correo.ControllerMail;
import correo.MailContainer;
import correo.vistaCorreo.VistaCorreo;

/**
 * @author Israel
 *
 */
public class Main {

	public static void main(String[] args) {
		VistaCorreo vista = new VistaCorreo();
		MailContainer container = new MailContainer();
		ControllerMail conMail = new ControllerMail(vista, container);
//		VistaPrincipal vista = new VistaPrincipal();
		//VistaLogin vista = new VistaLogin();
//		vista.setVisible(true);

//		String name = "";
//		
//		Tools.showConsoleText(name);
	}

}
