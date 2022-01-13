package common;

import common.vistaPrincipal.*;
import ftp.vistaFTP.*;
import correo.vistaCorreo.*;

/**
 * @author Alvaro
 *
 */
public class ControllerMain {

	private VistaPrincipal mainView;
	private VistaFTP ftpView;
	private VistaCorreo mailView;
	private ControladorFTPCliente ftpController
	private ControllerMail mailController;
	
	public ControllerMain() {
		mainView = new VistaPrincipal();
		ftpView =  new VistaFTP();
		ftpController = new ControladorFTPCliente(ftpView);
		mailController = new ControllerMail(mailView);
		eleccionVentana();
		mainView.setVisible(true);
	}
	
//	private void eleccionVentana() {
//		mainVistaPrincipal = new VistaPrincipal();
//		
//		if(mainVistaPrincipal.getMainJmenubarMenuBar().getMenu(0).isSelected()) {
//			mainVistaFTP = new VistaFTP();
//			mainVistaPrincipal.getMainJmenubarMenuBar().getMenu(0).addActionListener(null);
//		}else if(mainVistaPrincipal.getMainJmenubarMenuBar().getMenu(1).isSelected()) {
//			mainVistaCorreo = new VistaCorreo();
//			mainVistaPrincipal.getMainJmenubarMenuBar().getMenu(1).addActionListener(null);
//		}else {
//			mainVistaPrincipal.getDefaultCloseOperation();
//			mainVistaPrincipal.getMainJmenubarMenuBar().getMenu(0).addActionListener(null);
//		}
//	}
//	
	private void eleccionVentana() {
		mainView.getMainJmenuFTP().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
		mainView.getMainJmenuEmail().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
		mainView.getMainJmenuDisconnect().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
	}
	
}