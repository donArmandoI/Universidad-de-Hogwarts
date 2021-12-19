/**
 * 
 */
package correo.vistaCorreo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
public class JdialogLeerCorreo extends JDialog{
	TextES spanish = new TextES();
	JPanel emailreadJpanelHeadlines = new JPanel(new GridLayout(0,1));
	JPanel emailreadJpanelSubject = new JPanel();
	JPanel emailreadJpanelUser = new JPanel();
	JPanel emailreadJpanelText = new JPanel();
	JPanel emailreadJpanelButtons = new JPanel();
	JLabel emailreadJlabelSubject;
	JLabel emailreadJlabelUser;
	JTextField emailreadJtextfieldSubject;
	JTextField emailreadJtextfieldUser;
	JTextArea emailreadJtextareaText;
	JButton emailreadJbuttonCancel;

	public JdialogLeerCorreo() {
		crearItems();
		propiedades();
	}

	private void crearItems() {
		// TODO Auto-generated method stub
		emailreadJlabelSubject = new JLabel(spanish.getEmailStringSubject());
		emailreadJlabelUser = new JLabel(spanish.getEmailStringDe());
		
		emailreadJtextfieldSubject = new JTextField(50);
		emailreadJtextfieldUser = new JTextField(52);
		
		emailreadJtextareaText = new JTextArea(30,70);
		emailreadJtextareaText.setBounds(100,80,20,20);
		
		emailreadJbuttonCancel = new JButton(spanish.getEmailStringCancelar());
		
		emailreadJpanelSubject.add(emailreadJlabelSubject);
		emailreadJpanelSubject.add(emailreadJtextfieldSubject);
		emailreadJpanelUser.add(emailreadJlabelUser);
		emailreadJpanelUser.add(emailreadJtextfieldUser);
		
		emailreadJpanelHeadlines.add(emailreadJpanelSubject);
		emailreadJpanelHeadlines.add(emailreadJpanelUser);
		
		emailreadJpanelText.add(emailreadJtextareaText);

		emailreadJpanelButtons.add(emailreadJbuttonCancel);
		
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		add(emailreadJpanelHeadlines);
		add(emailreadJpanelText);
		add(emailreadJpanelButtons);
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(820,720));
		this.getContentPane().setBackground(new Color(255, 253, 150));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * @return the emailreadJtextfieldSubject
	 */
	public JTextField getEmailreadJtextfieldSubject() {
		return emailreadJtextfieldSubject;
	}

	/**
	 * @return the emailreadJtextfieldUser
	 */
	public JTextField getEmailreadJtextfieldUser() {
		return emailreadJtextfieldUser;
	}

	/**
	 * @return the emailreadJtextareaText
	 */
	public JTextArea getEmailreadJtextareaText() {
		return emailreadJtextareaText;
	}


	/**
	 * @return the emailreadJbuttonCancel
	 */
	public JButton getEmailreadJbuttonCancel() {
		return emailreadJbuttonCancel;
	}

	/**
	 * @param emailreadJtextfieldSubject the emailreadJtextfieldSubject to set
	 */
	public void setEmailreadJtextfieldSubject(JTextField emailreadJtextfieldSubject) {
		this.emailreadJtextfieldSubject = emailreadJtextfieldSubject;
	}

	/**
	 * @param emailreadJtextfieldUser the emailreadJtextfieldUser to set
	 */
	public void setEmailreadJtextfieldUser(JTextField emailreadJtextfieldUser) {
		this.emailreadJtextfieldUser = emailreadJtextfieldUser;
	}

	/**
	 * @param emailreadJtextareaText the emailreadJtextareaText to set
	 */
	public void setEmailreadJtextareaText(JTextArea emailreadJtextareaText) {
		this.emailreadJtextareaText = emailreadJtextareaText;
	}

	/**
	 * @param emailreadJbuttonCancel the emailreadJbuttonCancel to set
	 */
	public void setEmailreadJbuttonCancel(JButton emailreadJbuttonCancel) {
		this.emailreadJbuttonCancel = emailreadJbuttonCancel;
	}
	
	
}
