package common;

import java.net.Socket;

import common.vistaPrincipal.VistaPrincipal;
import correo.ControllerMail;
import correo.vistaCorreo.VistaCorreo;
import ftp.ControladorFTPCliente;
import ftp.vistaFTP.VistaFTP;

/**
 * @author Alvaro
 *
 */
public class ControllerMain {

	private VistaPrincipal mainView;
	private VistaFTP ftpView;
	private VistaCorreo mailView;
	private Usuario user;
	private Socket cli;
	
	public ControllerMain(Socket cli) {
		this.cli = cli;
		this.mainView = new VistaPrincipal();
		mainView.addWindowListener(new WindowsAct(cli));
	}

	public void generateElements() {
		ftpView =  new VistaFTP();
		mailView = new VistaCorreo();
		mainView.setMainJpanelPanel(ftpView);
		new ControladorFTPCliente(user, cli, ftpView);
		new ControllerMail(mailView);
		eleccionVentana();
		mainView.setVisible(true);
		
	}
	
	private void eleccionVentana() {
		mainView.getMainJmenuFTP().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
		mainView.getMainJmenuEmail().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
		mainView.getMainJmenuDisconnect().addMouseListener(new EventosVentanas(mainView, ftpView, mailView));
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	
}