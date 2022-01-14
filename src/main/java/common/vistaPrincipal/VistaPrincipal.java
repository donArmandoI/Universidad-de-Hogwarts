/**
 * 
 */
package common.vistaPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import common.TextES;
import ftp.vistaFTP.VistaFTP;

/**
 * @author Natalia
 *
 */
public class VistaPrincipal extends JFrame {
	TextES spanish = new TextES();
	JMenuBar mainJmenubarMenuBar;
	JMenu mainJmenuFTP, mainJmenuEmail, mainJmenuDisconnect;
	JPanel mainJpanelPanel = new JPanel();

	public VistaPrincipal() {
		crearItems();
		propiedades();
	}

	private void crearItems() {
		// TODO Auto-generated method stub
		mainJmenubarMenuBar = new JMenuBar();
		mainJmenuFTP = new JMenu("FTP");
		mainJmenuEmail = new JMenu("CORREO");
		mainJmenuDisconnect = new JMenu("DESCONECTAR");
		mainJmenubarMenuBar.add(mainJmenuFTP);
		mainJmenubarMenuBar.add(mainJmenuEmail);
		mainJmenubarMenuBar.add(mainJmenuDisconnect);
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		this.setTitle("HOGWARTS");
		this.setSize(new Dimension(860, 680));
		this.setLayout(new BorderLayout());
		
		this.add(mainJmenubarMenuBar, BorderLayout.NORTH);
		this.add(mainJpanelPanel, BorderLayout.CENTER);

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel getMainJpanelPanel() {
		return mainJpanelPanel;
	}

	public void setMainJpanelPanel(JPanel vista) {
		this.remove(mainJpanelPanel);
		this.mainJpanelPanel = vista;
		this.add(mainJpanelPanel, BorderLayout.CENTER);
		this.repaint();
	}

}
