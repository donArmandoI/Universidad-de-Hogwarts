package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import common.vistaPrincipal.VistaPrincipal;
import correo.vistaCorreo.VistaCorreo;
import ftp.vistaFTP.VistaFTP;
/**
 * @author Alvaro
 *
 */
public class EventosVentanas implements MouseListener {

	private VistaPrincipal mainVistaPrincipal;
	private VistaCorreo mainVistaCorreo;
	private ControllerMail mainControllerCorreo;
	private VistaFTP mainVistaFTP;
	
	public EventosVentanas(VistaPrincipal mainVistaPrincipal) {
		this.mainVistaPrincipal=mainVistaPrincipal;
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(mainVistaPrincipal.getMainJmenuFTP()) ) {
			System.out.println("Opcion FTP");
			new VistaFTP();
			mainVistaPrincipal.setMainJpanelPanel(mainVistaFTP);
		}else if(e.getSource().equals(mainVistaPrincipal.getMainJmenuEmail())) {
			System.out.println("Opcion correo");
			mainVistaPrincipal.setMainJpanelPanel(mainVistaCorreo);
			mainControllerCorreo = new ControllerMail(mainVistaCorreo);
			mainVistaPrincipal.setMainJpanelPanel(mainControllerCorreo.getMailView());
			
		}else {
			System.exit(1);
		}
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}