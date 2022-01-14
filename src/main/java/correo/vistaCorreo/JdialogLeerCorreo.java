/**
 * 
 */
package correo.vistaCorreo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import org.jdesktop.swingx.JXEditorPane;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class JdialogLeerCorreo extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = -456739594043133809L;
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

	public JdialogLeerCorreo(String subject, String sender, JXEditorPane body) {
		
		crearItems();
		propiedades();
		
		emailreadJtextfieldSubject.setText(subject);
		emailreadJtextfieldUser.setText(sender);
		emailreadJpanelText.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailreadJpanelText.setBackground(new Color(95, 158, 160));
		emailreadJpanelText.add(body);
		
	}

	private void crearItems() {
		// TODO Auto-generated method stub
		emailreadJlabelSubject = new JLabel(TextES.getEmailStringSubject());
		emailreadJlabelUser = new JLabel(TextES.getEmailStringFrom());
		
		emailreadJtextfieldSubject = new JTextField(100);
		emailreadJtextfieldSubject.setBackground(new Color(230, 230, 250));
		emailreadJtextfieldUser = new JTextField(98);
		emailreadJtextfieldUser.setBackground(new Color(230, 230, 250));
		
//		emailreadJtextareaText = new JTextArea(30,70);
//		emailreadJtextareaText.setBounds(100,80,20,20);
		
		emailreadJbuttonCancel = new JButton(TextES.getEmailStringCancel());
		FlowLayout flowLayout = (FlowLayout) emailreadJpanelSubject.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		emailreadJpanelSubject.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailreadJpanelSubject.setBackground(new Color(95, 158, 160));
		
		emailreadJpanelSubject.add(emailreadJlabelSubject);
		emailreadJpanelSubject.add(emailreadJtextfieldSubject);
		FlowLayout flowLayout_1 = (FlowLayout) emailreadJpanelUser.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		emailreadJpanelUser.setBackground(new Color(95, 158, 160));
		emailreadJpanelUser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailreadJpanelUser.add(emailreadJlabelUser);
		emailreadJpanelUser.add(emailreadJtextfieldUser);
		
		emailreadJpanelHeadlines.add(emailreadJpanelSubject);
		emailreadJpanelHeadlines.add(emailreadJpanelUser);
		emailreadJpanelButtons.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailreadJpanelButtons.setBackground(new Color(95, 158, 160));
		
//		emailreadJpanelText.add(emailreadJtextareaText);

		emailreadJpanelButtons.add(emailreadJbuttonCancel);
		
	}

	private void propiedades() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		// TODO Auto-generated method stub
		JScrollPane scroll = new JScrollPane(emailreadJpanelText);		
		getContentPane().add(emailreadJpanelHeadlines, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);
		getContentPane().add(emailreadJpanelButtons, BorderLayout.SOUTH);
		this.setMinimumSize(new Dimension(1500,800));
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
