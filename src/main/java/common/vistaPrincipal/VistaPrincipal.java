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
import ftp.vistaFTP.JpanelFichero;

/**
 * @author Natalia
 *
 */
public class VistaPrincipal extends JFrame {
	TextES spanish = new TextES();
	JMenuBar mainJmenubarMenuBar;
	JMenu mainJmenuFTP, mainJmenuEmail, mainJmenuDisconnect;
	JPanel mainJpanelPanel = new JPanel(new GridLayout(0,1));

	public VistaPrincipal() {
		crearItems();
		propiedades();
	}

	private void crearItems() {
		// TODO Auto-generated method stub
		mainJmenubarMenuBar = new JMenuBar();
		//mainJmenuFTP = new JMenu(spanish.getMainStringFTP());
		//mainJmenuEmail = new JMenu(spanish.getMainStringCorreo());
		//mainJmenuDisconnect = new JMenu(spanish.getMainStringDisconnect());
		mainJmenubarMenuBar.add(mainJmenuFTP);
		mainJmenubarMenuBar.add(mainJmenuEmail);
		mainJmenubarMenuBar.add(mainJmenuDisconnect);
	}
	
	public void addJpanel(JPanel panel) {
		mainJpanelPanel.add(panel);
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		//this.setTitle(spanish.getMainStringTitle());
		this.setSize(new Dimension(860, 680));
		this.setLayout(new BorderLayout());

		add(mainJmenubarMenuBar, BorderLayout.NORTH);
		add(mainJpanelPanel, BorderLayout.CENTER);

		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
