/**
 * 
 */
package login.vistaLoginSignin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class VistaSignin extends JFrame {
	TextES spanish = new TextES();
	
	JPanel signinJPanelLabel = new JPanel();
	JPanel signinJPanelTextfield = new JPanel();

	JPanel signinJPanelLogin = new JPanel();
	JPanel signinJPanelSignin = new JPanel();
	JPanel signinJPanelButton = new JPanel();

	JLabel signinJlabelUsername;
	JTextField signinJtextfieldUsername;

	JLabel signinJlabelName;
	JTextField signinJtextfieldName;

	JLabel signinJlabelSurname;
	JTextField signinJtextfieldSurname;

	JLabel signinJlabelTeacher;
	JCheckBox signinJcheckboxTeacher;

	JLabel signinJlabelEmail;
	JTextField signinJtextfieldEmail;

	JLabel signinJlabelPassword;
	JPasswordField signinJPasswordfieldPassword;

	JLabel signinJlabelLogin;
	JButton signinJbuttonLogin;
	JButton signinJbuttonSignin;

	public VistaSignin() {
		crearSignin();
		propiedades();
	}

	private void crearSignin() {
		// TODO Auto-generated method stub
		signinJlabelUsername = new JLabel(spanish.getSigninStringUserName());
		signinJtextfieldUsername = new JTextField(15);

		signinJlabelName = new JLabel(spanish.getSigninStringName());
		signinJtextfieldName = new JTextField(15);

		signinJlabelSurname = new JLabel(spanish.getSigninStringSurname());
		signinJtextfieldSurname = new JTextField(15);

		signinJlabelTeacher = new JLabel(spanish.getSigninStringTeacher());
		signinJcheckboxTeacher = new JCheckBox();

		signinJlabelEmail = new JLabel(spanish.getSigninStringEmail());
		signinJtextfieldEmail = new JTextField(15);

		signinJlabelPassword = new JLabel(spanish.getSigninStringPassword());
		signinJPasswordfieldPassword = new JPasswordField(15);

		signinJlabelLogin = new JLabel(spanish.getSigninStringInfo());
		signinJbuttonSignin = new JButton(spanish.getSigninStringSignin());
		signinJbuttonLogin = new JButton(spanish.getSigninStringLogin());

		signinJPanelLabel.add(signinJlabelUsername);
		signinJPanelTextfield.add(signinJtextfieldUsername);

		signinJPanelLabel.add(signinJlabelName);
		signinJPanelTextfield.add(signinJtextfieldName);

		signinJPanelLabel.add(signinJlabelSurname);
		signinJPanelTextfield.add(signinJtextfieldSurname);

		signinJPanelLabel.add(signinJlabelTeacher);
		signinJPanelTextfield.add(signinJcheckboxTeacher);

		signinJPanelLabel.add(signinJlabelEmail);
		signinJPanelTextfield.add(signinJtextfieldEmail);

		signinJPanelLabel.add(signinJlabelPassword);
		signinJPanelTextfield.add(signinJPasswordfieldPassword);
		
		signinJPanelLogin.add(signinJlabelLogin);
		signinJPanelLogin.add(signinJbuttonLogin);
		signinJPanelSignin.add(signinJbuttonSignin);
	}

	private void propiedades() {
		// TODO Auto-generated method stub;´
		JPanel contenido = new JPanel(new BorderLayout());
		signinJPanelButton.setLayout(new BoxLayout(signinJPanelButton, BoxLayout.Y_AXIS));
		
		JpanelImagen fondo = new JpanelImagen("/imagenLogin/Hogwarts-logo-1.png");
		add(fondo);
		signinJPanelLabel.setLayout(new GridLayout(0,1));
		signinJPanelTextfield.setLayout(new GridLayout(0,1));
		
		signinJPanelButton.add(signinJPanelSignin);
		signinJPanelButton.add(signinJPanelLogin);
		
		contenido.add(signinJPanelLabel,BorderLayout.WEST);
		contenido.add(signinJPanelTextfield,BorderLayout.CENTER);
		
		contenido.add(signinJPanelButton,BorderLayout.SOUTH);
		add(contenido);
	

		this.setTitle("Signin");
		this.setSize(new Dimension(400, 400));
		this.setLayout(new GridLayout(0,1));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @return the signinJlabelUsername
	 */
	public JLabel getSigninJlabelUsername() {
		return signinJlabelUsername;
	}

	/**
	 * @param signinJlabelUsername the signinJlabelUsername to set
	 */
	public void setSigninJlabelUsername(JLabel signinJlabelUsername) {
		this.signinJlabelUsername = signinJlabelUsername;
	}

	/**
	 * @return the signinJtextfieldUsername
	 */
	public JTextField getSigninJtextfieldUsername() {
		return signinJtextfieldUsername;
	}

	/**
	 * @param signinJtextfieldUsername the signinJtextfieldUsername to set
	 */
	public void setSigninJtextfieldUsername(JTextField signinJtextfieldUsername) {
		this.signinJtextfieldUsername = signinJtextfieldUsername;
	}

	/**
	 * @return the signinJlabelName
	 */
	public JLabel getSigninJlabelName() {
		return signinJlabelName;
	}

	/**
	 * @param signinJlabelName the signinJlabelName to set
	 */
	public void setSigninJlabelName(JLabel signinJlabelName) {
		this.signinJlabelName = signinJlabelName;
	}

	/**
	 * @return the signinJtextfieldName
	 */
	public JTextField getSigninJtextfieldName() {
		return signinJtextfieldName;
	}

	/**
	 * @param signinJtextfieldName the signinJtextfieldName to set
	 */
	public void setSigninJtextfieldName(JTextField signinJtextfieldName) {
		this.signinJtextfieldName = signinJtextfieldName;
	}

	/**
	 * @return the signinJlabelSurname
	 */
	public JLabel getSigninJlabelSurname() {
		return signinJlabelSurname;
	}

	/**
	 * @param signinJlabelSurname the signinJlabelSurname to set
	 */
	public void setSigninJlabelSurname(JLabel signinJlabelSurname) {
		this.signinJlabelSurname = signinJlabelSurname;
	}

	/**
	 * @return the signinJtextfieldSurname
	 */
	public JTextField getSigninJtextfieldSurname() {
		return signinJtextfieldSurname;
	}

	/**
	 * @param signinJtextfieldSurname the signinJtextfieldSurname to set
	 */
	public void setSigninJtextfieldSurname(JTextField signinJtextfieldSurname) {
		this.signinJtextfieldSurname = signinJtextfieldSurname;
	}

	/**
	 * @return the signinJlabelTeacher
	 */
	public JLabel getSigninJlabelTeacher() {
		return signinJlabelTeacher;
	}

	/**
	 * @param signinJlabelTeacher the signinJlabelTeacher to set
	 */
	public void setSigninJlabelTeacher(JLabel signinJlabelTeacher) {
		this.signinJlabelTeacher = signinJlabelTeacher;
	}

	/**
	 * @return the signinJcheckboxTeacher
	 */
	public JCheckBox getSigninJcheckboxTeacher() {
		return signinJcheckboxTeacher;
	}

	/**
	 * @param signinJcheckboxTeacher the signinJcheckboxTeacher to set
	 */
	public void setSigninJcheckboxTeacher(JCheckBox signinJcheckboxTeacher) {
		this.signinJcheckboxTeacher = signinJcheckboxTeacher;
	}

	/**
	 * @return the signinJlabelEmail
	 */
	public JLabel getSigninJlabelEmail() {
		return signinJlabelEmail;
	}

	/**
	 * @param signinJlabelEmail the signinJlabelEmail to set
	 */
	public void setSigninJlabelEmail(JLabel signinJlabelEmail) {
		this.signinJlabelEmail = signinJlabelEmail;
	}

	/**
	 * @return the signinJtextfieldEmail
	 */
	public JTextField getSigninJtextfieldEmail() {
		return signinJtextfieldEmail;
	}

	/**
	 * @param signinJtextfieldEmail the signinJtextfieldEmail to set
	 */
	public void setSigninJtextfieldEmail(JTextField signinJtextfieldEmail) {
		this.signinJtextfieldEmail = signinJtextfieldEmail;
	}

	/**
	 * @return the signinJlabelPassword
	 */
	public JLabel getSigninJlabelPassword() {
		return signinJlabelPassword;
	}

	/**
	 * @param signinJlabelPassword the signinJlabelPassword to set
	 */
	public void setSigninJlabelPassword(JLabel signinJlabelPassword) {
		this.signinJlabelPassword = signinJlabelPassword;
	}

	/**
	 * @return the signinJPasswordfieldPassword
	 */
	public JPasswordField getSigninJPasswordfieldPassword() {
		return signinJPasswordfieldPassword;
	}

	/**
	 * @param signinJPasswordfieldPassword the signinJPasswordfieldPassword to set
	 */
	public void setSigninJPasswordfieldPassword(JPasswordField signinJPasswordfieldPassword) {
		this.signinJPasswordfieldPassword = signinJPasswordfieldPassword;
	}

	/**
	 * @return the signinJbuttonLogin
	 */
	public JButton getSigninJbuttonLogin() {
		return signinJbuttonLogin;
	}

	/**
	 * @param signinJbuttonLogin the signinJbuttonLogin to set
	 */
	public void setSigninJbuttonLogin(JButton signinJbuttonLogin) {
		this.signinJbuttonLogin = signinJbuttonLogin;
	}

	/**
	 * @return the signinJbuttonSignin
	 */
	public JButton getSigninJbuttonSignin() {
		return signinJbuttonSignin;
	}

	/**
	 * @param signinJbuttonSignin the signinJbuttonSignin to set
	 */
	public void setSigninJbuttonSignin(JButton signinJbuttonSignin) {
		this.signinJbuttonSignin = signinJbuttonSignin;
	}

}
