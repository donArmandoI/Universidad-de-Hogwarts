/**
 * 
 */
package correo.vistaCorreo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class JdialogNuevoCorreo extends JDialog{
	TextES spanish = new TextES();
	JPanel emailcreateJpanelHeadlines = new JPanel(new GridLayout(0,1));
	JPanel emailcreateJpanelSubject = new JPanel();
	JPanel emailcreateJpanelUser = new JPanel();
	JPanel emailcreateJpanelText = new JPanel();
	JPanel emailcreateJpanelButtons = new JPanel();
	JLabel emailcreateJlabelSubject;
	JLabel emailcreateJlabelUser;
	JTextField emailcreateJtextfieldSubject;
	JTextField emailcreateJtextfieldUser;
	JTextArea emailcreateJtextareaText;
	JButton emailcreateJButtonSend;
	JButton emailcreateJbuttonCancel;

	public JdialogNuevoCorreo() {
		crearItems();
		propiedades();
	}

	private void crearItems() {
		// TODO Auto-generated method stub
		emailcreateJlabelSubject = new JLabel(spanish.getEmailStringSubject());
		emailcreateJlabelUser = new JLabel(spanish.getEmailStringPara());
		
		emailcreateJtextfieldSubject = new JTextField(50);
		emailcreateJtextfieldUser = new JTextField(51);
		
		emailcreateJtextareaText = new JTextArea(30,70);
		emailcreateJtextareaText.setBounds(100,80,20,20);
		
		emailcreateJButtonSend = new JButton(spanish.getEmailStringEnviar());
		emailcreateJbuttonCancel = new JButton(spanish.getEmailStringCancelar());
		
		emailcreateJpanelSubject.add(emailcreateJlabelSubject);
		emailcreateJpanelSubject.add(emailcreateJtextfieldSubject);
		emailcreateJpanelUser.add(emailcreateJlabelUser);
		emailcreateJpanelUser.add(emailcreateJtextfieldUser);
		
		emailcreateJpanelHeadlines.add(emailcreateJpanelSubject);
		emailcreateJpanelHeadlines.add(emailcreateJpanelUser);
		emailcreateJpanelHeadlines.setBackground(new Color(255, 253, 150));
		
		emailcreateJpanelText.add(emailcreateJtextareaText);
		
		emailcreateJpanelButtons.add(emailcreateJButtonSend);
		emailcreateJpanelButtons.add(emailcreateJbuttonCancel);
		
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		add(emailcreateJpanelHeadlines);
		add(emailcreateJpanelText);
		add(emailcreateJpanelButtons);
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(820,720));
		this.getContentPane().setBackground(new Color(255, 253, 150));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * @return the emailcreateJpanelHeadlines
	 */
	public JPanel getEmailcreateJpanelHeadlines() {
		return emailcreateJpanelHeadlines;
	}

	/**
	 * @return the emailcreateJpanelSubject
	 */
	public JPanel getEmailcreateJpanelSubject() {
		return emailcreateJpanelSubject;
	}

	/**
	 * @return the emailcreateJpanelUser
	 */
	public JPanel getEmailcreateJpanelUser() {
		return emailcreateJpanelUser;
	}

	/**
	 * @return the emailcreateJpanelText
	 */
	public JPanel getEmailcreateJpanelText() {
		return emailcreateJpanelText;
	}

	/**
	 * @return the emailcreateJpanelButtons
	 */
	public JPanel getEmailcreateJpanelButtons() {
		return emailcreateJpanelButtons;
	}

	/**
	 * @return the emailcreateJlabelSubject
	 */
	public JLabel getEmailcreateJlabelSubject() {
		return emailcreateJlabelSubject;
	}

	/**
	 * @return the emailcreateJlabelUser
	 */
	public JLabel getEmailcreateJlabelUser() {
		return emailcreateJlabelUser;
	}

	/**
	 * @return the emailcreateJtextfieldSubject
	 */
	public JTextField getEmailcreateJtextfieldSubject() {
		return emailcreateJtextfieldSubject;
	}

	/**
	 * @return the emailcreateJtextfieldUser
	 */
	public JTextField getEmailcreateJtextfieldUser() {
		return emailcreateJtextfieldUser;
	}

	/**
	 * @return the emailcreateJtextareaText
	 */
	public JTextArea getEmailcreateJtextareaText() {
		return emailcreateJtextareaText;
	}

	/**
	 * @return the emailcreateJButtonSend
	 */
	public JButton getEmailcreateJButtonSend() {
		return emailcreateJButtonSend;
	}

	/**
	 * @return the emailcreateJbuttonCancel
	 */
	public JButton getEmailcreateJbuttonCancel() {
		return emailcreateJbuttonCancel;
	}
	
	
}
