package common;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private VistaFTP mainVistaFTP;
	
	public EventosVentanas(VistaPrincipal mainVistaPrincipal, VistaFTP ftpView, VistaCorreo mailView) {
		this.mainVistaPrincipal=mainVistaPrincipal;
		mainVistaCorreo = mailView;
		mailView.setVisible(true);
		mainVistaFTP = ftpView;
		ftpView.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(mainVistaPrincipal.getMainJmenuFTP()) ) {
			mainVistaPrincipal.setMainJpanelPanel(mainVistaFTP);
			System.out.println("Opcion FTP");
		}else if(e.getSource().equals(mainVistaPrincipal.getMainJmenuEmail())) {
			mainVistaPrincipal.setMainJpanelPanel(mainVistaCorreo);
			mainVistaPrincipal.repaint();
			System.out.println("Opcion correo");
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