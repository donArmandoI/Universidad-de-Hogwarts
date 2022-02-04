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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import common.TextES;

/**
 * @author Natalia
 *
 */
public class JdialogNuevoCorreo extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1297126512803696014L;
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
		emailcreateJlabelSubject = new JLabel(TextES.getEmailStringSubject());
		emailcreateJlabelSubject.setHorizontalAlignment(SwingConstants.LEFT);
		emailcreateJlabelUser = new JLabel(TextES.getEmailStringTo());
		emailcreateJlabelUser.setHorizontalAlignment(SwingConstants.LEFT);
		
		emailcreateJtextfieldSubject = new JTextField(73);
		emailcreateJtextfieldSubject.setBackground(new Color(230, 230, 250));
		emailcreateJtextfieldUser = new JTextField(70);
		emailcreateJtextfieldUser.setBackground(new Color(230, 230, 250));
		
		emailcreateJtextareaText = new JTextArea(30,80);
		emailcreateJtextareaText.setBackground(new Color(230, 230, 250));
		emailcreateJtextareaText.setBounds(100,80,20,20);
		
		emailcreateJButtonSend = new JButton(TextES.getEmailStringSend());
		emailcreateJbuttonCancel = new JButton(TextES.getEmailStringCancel());
		FlowLayout flowLayout_1 = (FlowLayout) emailcreateJpanelSubject.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		flowLayout_1.setHgap(10);
		emailcreateJpanelSubject.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailcreateJpanelSubject.setBackground(new Color(95, 158, 160));
		
		emailcreateJpanelSubject.add(emailcreateJlabelSubject);
		emailcreateJpanelSubject.add(emailcreateJtextfieldSubject);
		FlowLayout flowLayout = (FlowLayout) emailcreateJpanelUser.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEADING);
		emailcreateJpanelUser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailcreateJpanelUser.setBackground(new Color(95, 158, 160));
		emailcreateJpanelUser.add(emailcreateJlabelUser);
		emailcreateJpanelUser.add(emailcreateJtextfieldUser);
		
		emailcreateJpanelHeadlines.add(emailcreateJpanelSubject);
		emailcreateJpanelHeadlines.add(emailcreateJpanelUser);
		emailcreateJpanelHeadlines.setBackground(new Color(255, 253, 150));
		FlowLayout flowLayout_2 = (FlowLayout) emailcreateJpanelText.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(10);
		emailcreateJpanelText.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailcreateJpanelText.setBackground(new Color(95, 158, 160));
		
		emailcreateJpanelText.add(emailcreateJtextareaText);
		emailcreateJpanelButtons.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		emailcreateJpanelButtons.setBackground(new Color(95, 158, 160));
		
		emailcreateJpanelButtons.add(emailcreateJButtonSend);
		emailcreateJpanelButtons.add(emailcreateJbuttonCancel);
		
	}

	private void propiedades() {
		// TODO Auto-generated method stub
		getContentPane().setLayout(new BorderLayout());
		this.setSize(new Dimension(820,720));
		this.getContentPane().setBackground(new Color(255, 253, 150));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(emailcreateJpanelHeadlines, BorderLayout.NORTH);
		getContentPane().add(emailcreateJpanelText, BorderLayout.CENTER);
		getContentPane().add(emailcreateJpanelButtons, BorderLayout.SOUTH);
		
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
