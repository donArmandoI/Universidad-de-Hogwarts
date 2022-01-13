package common;

import common.vistaPrincipal.*;
import ftp.vistaFTP.*;
import correo.vistaCorreo.*;

/**
 * @author Alvaro
 *
 */
public class ControllerMain {

	private VistaPrincipal mainVistaPrincipal;
	private VistaFTP mainVistaFTP;
//	private ControllerMail mainControllerMail;
	
	public ControllerMain() {
		mainVistaPrincipal = new VistaPrincipal();
		eleccionVentana();
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
		mainVistaPrincipal.getMainJmenuFTP().addMouseListener(new EventosVentanas(mainVistaPrincipal));
		mainVistaPrincipal.getMainJmenuEmail().addMouseListener(new EventosVentanas(mainVistaPrincipal));
		mainVistaPrincipal.getMainJmenuDisconnect().addMouseListener(new EventosVentanas(mainVistaPrincipal));
	}
	
}