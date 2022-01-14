package common;

import common.vistaPrincipal.*;
import ftp.vistaFTP.*;
import correo.ControllerMail;
import correo.vistaCorreo.*;

/**
 * @author Alvaro
 *
 */
public class ControllerMain {

	private VistaPrincipal mainView;
	private VistaFTP ftpView;
	private VistaCorreo mailView;
//	private ControladorFTPCliente ftpController;
	private ControllerMail mailController;
	
	public ControllerMain() {
		mainView = new VistaPrincipal();
		ftpView =  new VistaFTP();
		mailView = new VistaCorreo();
//		mainView.setMainJpanelPanel(ftpView);
		eleccionVentana();
		mainView.setVisible(true);
//		ftpController = new ControladorFTPCliente(ftpView);
		mailController = new ControllerMail(mailView);
		
	}
	
	private void eleccionVentana() {
		mainView.getMainJmenuFTP().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
		mainView.getMainJmenuEmail().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
		mainView.getMainJmenuDisconnect().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
	}
	
}