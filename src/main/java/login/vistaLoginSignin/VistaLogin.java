/**
 * 
 */
package login.vistaLoginSignin;

import java.awt.*;
import javax.swing.*;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class VistaLogin extends JFrame {
	TextES spanish = new TextES();
	
	Box verti = Box.createVerticalBox();
	JPanel loginJPanelUsername = new JPanel();
	JPanel loginJPanelPassword = new JPanel();
	JPanel loginJPanelLogin = new JPanel();
	JPanel loginJPanelSignin = new JPanel();
	
	
	JLabel loginJlabelUsername;
	JTextField loginJtextfieldUsername;
	JLabel loginJlabelPassword;
	JPasswordField loginJPasswordfieldPassword;
	JButton loginJbuttonLogin;
	JLabel loginJlabelSignin;
	JButton loginJbuttonSignin ;
	
	public VistaLogin() {
		crearLogin();
		propiedades();
	}

	private void crearLogin() {
		// TODO Auto-generated method stub
		/*loginJlabelUsername = new JLabel(spanish.getSigninStringUserName());
		loginJtextfieldUsername = new JTextField(15);
		loginJlabelPassword = new JLabel(spanish.getSigninStringPassword());
		loginJPasswordfieldPassword = new JPasswordField(15);
		loginJbuttonLogin = new JButton(spanish.getSigninStringLogin());
		
		loginJPanelUsername.add(loginJlabelUsername);
		loginJPanelUsername.add(loginJtextfieldUsername);
		loginJPanelPassword.add(loginJlabelPassword);
		loginJPanelPassword.add(loginJPasswordfieldPassword);
		loginJPanelLogin.add(loginJbuttonLogin);
		
		loginJlabelSignin = new JLabel(spanish.getLoginStringInfo());
		loginJbuttonSignin = new JButton(spanish.getSigninStringSignin());
		
		loginJPanelSignin.add(loginJlabelSignin);
		loginJPanelSignin.add(loginJbuttonSignin);*/
	}


	private void propiedades() {
		// TODO Auto-generated method stub
		JpanelImagen fondo = new JpanelImagen("/imagenLogin/Hogwarts-logo-1.png");
		add(fondo);
		verti.add(loginJPanelUsername);
		verti.add(loginJPanelPassword);
		verti.add(loginJPanelLogin);
		verti.add(loginJPanelSignin);
		add(verti);
		this.setTitle("Login");
		this.setSize(new Dimension(360,480));
		this.setLayout(new GridLayout(0,1));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @return the loginJPanelSignin
	 */
	public JPanel getLoginJPanelSignin() {
		return loginJPanelSignin;
	}

	/**
	 * @param loginJPanelSignin the loginJPanelSignin to set
	 */
	public void setLoginJPanelSignin(JPanel loginJPanelSignin) {
		this.loginJPanelSignin = loginJPanelSignin;
	}

	/**
	 * @return the loginJlabelUsername
	 */
	public JLabel getLoginJlabelUsername() {
		return loginJlabelUsername;
	}

	/**
	 * @param loginJlabelUsername the loginJlabelUsername to set
	 */
	public void setLoginJlabelUsername(JLabel loginJlabelUsername) {
		this.loginJlabelUsername = loginJlabelUsername;
	}

	/**
	 * @return the loginJtextfieldUsername
	 */
	public JTextField getLoginJtextfieldUsername() {
		return loginJtextfieldUsername;
	}

	/**
	 * @param loginJtextfieldUsername the loginJtextfieldUsername to set
	 */
	public void setLoginJtextfieldUsername(JTextField loginJtextfieldUsername) {
		this.loginJtextfieldUsername = loginJtextfieldUsername;
	}

	/**
	 * @return the loginJlabelPassword
	 */
	public JLabel getLoginJlabelPassword() {
		return loginJlabelPassword;
	}

	/**
	 * @param loginJlabelPassword the loginJlabelPassword to set
	 */
	public void setLoginJlabelPassword(JLabel loginJlabelPassword) {
		this.loginJlabelPassword = loginJlabelPassword;
	}

	/**
	 * @return the loginJPasswordfieldPassword
	 */
	public JPasswordField getLoginJPasswordfieldPassword() {
		return loginJPasswordfieldPassword;
	}

	/**
	 * @param loginJPasswordfieldPassword the loginJPasswordfieldPassword to set
	 */
	public void setLoginJPasswordfieldPassword(JPasswordField loginJPasswordfieldPassword) {
		this.loginJPasswordfieldPassword = loginJPasswordfieldPassword;
	}

	/**
	 * @return the loginJbuttonLogin
	 */
	public JButton getLoginJbuttonLogin() {
		return loginJbuttonLogin;
	}

	/**
	 * @param loginJbuttonLogin the loginJbuttonLogin to set
	 */
	public void setLoginJbuttonLogin(JButton loginJbuttonLogin) {
		this.loginJbuttonLogin = loginJbuttonLogin;
	}

	/**
	 * @return the loginJlabelSignin
	 */
	public JLabel getLoginJlabelSignin() {
		return loginJlabelSignin;
	}

	/**
	 * @param loginJlabelSignin the loginJlabelSignin to set
	 */
	public void setLoginJlabelSignin(JLabel loginJlabelSignin) {
		this.loginJlabelSignin = loginJlabelSignin;
	}

	/**
	 * @return the loginJbuttonSignin
	 */
	public JButton getLoginJbuttonSignin() {
		return loginJbuttonSignin;
	}

	/**
	 * @param loginJbuttonSignin the loginJbuttonSignin to set
	 */
	public void setLoginJbuttonSignin(JButton loginJbuttonSignin) {
		this.loginJbuttonSignin = loginJbuttonSignin;
	}
	
}
