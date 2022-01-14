/**
 * 
 */
package common.vistaPrincipal;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class VistaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6627484408359795635L;
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
		mainJmenuFTP = new JMenu(TextES.getMainStringFTP());
		mainJmenuEmail = new JMenu(TextES.getMainStringMail());
		mainJmenuDisconnect = new JMenu(TextES.getMainStringDisconnect());
		mainJmenubarMenuBar.add(mainJmenuFTP);
		mainJmenubarMenuBar.add(mainJmenuEmail);
		mainJmenubarMenuBar.add(mainJmenuDisconnect);
	}
	
	public void addJpanel(JPanel panel) {
		mainJpanelPanel.add(panel);
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		this.setTitle(TextES.getMainStringTitle());
		mainJpanelPanel.setPreferredSize(new Dimension(1520, 780));
		this.setSize(new Dimension(1530, 820));
		this.setLayout(new BorderLayout());

		add(mainJmenubarMenuBar, BorderLayout.NORTH);
		add(mainJpanelPanel, BorderLayout.CENTER);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JMenuBar getMainJmenubarMenuBar() {
		return mainJmenubarMenuBar;
	}

	public void setMainJmenubarMenuBar(JMenuBar mainJmenubarMenuBar) {
		this.mainJmenubarMenuBar = mainJmenubarMenuBar;
	}

	public JMenu getMainJmenuFTP() {
		return mainJmenuFTP;
	}

	public void setMainJmenuFTP(JMenu mainJmenuFTP) {
		this.mainJmenuFTP = mainJmenuFTP;
	}

	public JMenu getMainJmenuEmail() {
		return mainJmenuEmail;
	}

	public void setMainJmenuEmail(JMenu mainJmenuEmail) {
		this.mainJmenuEmail = mainJmenuEmail;
	}

	public JMenu getMainJmenuDisconnect() {
		return mainJmenuDisconnect;
	}

	public void setMainJmenuDisconnect(JMenu mainJmenuDisconnect) {
		this.mainJmenuDisconnect = mainJmenuDisconnect;
	}

	public JPanel getMainJpanelPanel() {
		return mainJpanelPanel;
	}

	public void setMainJpanelPanel(JPanel mainJpanelPanel) {
		this.mainJpanelPanel.removeAll();
		this.mainJpanelPanel.add(mainJpanelPanel);
		this.mainJpanelPanel.updateUI();
	}
}
