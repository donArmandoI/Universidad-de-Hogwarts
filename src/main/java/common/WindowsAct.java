package common;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.apache.commons.net.ftp.FTPClient;

public class WindowsAct implements WindowListener {

	private DataOutputStream dataOut;
	private Socket cli;
	private FTPClient ftpClient;

	public WindowsAct(Socket cli) {
		this.cli = cli;
		this.ftpClient = null;
	}

	public WindowsAct(Socket cli, FTPClient ftpClient) {
		this.cli = cli;
		this.ftpClient = ftpClient;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			dataOut = new DataOutputStream(cli.getOutputStream());
			dataOut.writeUTF("CERRAR");

			dataOut.close();
			cli.close();
			
			if (ftpClient != null) {
				ftpClient.disconnect();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
