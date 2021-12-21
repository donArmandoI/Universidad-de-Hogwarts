package correo.vistaCorreo;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7747205704388338181L;
	JLabel lblSender;
	JLabel lblSubject;
	JLabel lblDate;
	
	public Header(String sender, String subject, String date) {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		lblSender = new JLabel("Sender");
		lblSender.setMaximumSize(new Dimension(150, 20));
		lblSender.setText(sender);
		lblSender.setToolTipText("Sender");
		add(lblSender);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setMaximumSize(new Dimension(400, 20));
		lblSubject.setText(subject);
		lblSubject.setToolTipText("Subject");
		add(lblSubject);
		
		lblDate = new JLabel("Date");
		lblDate.setMaximumSize(new Dimension(50, 20));
		lblDate.setText(date);
		lblDate.setToolTipText("Date");
		add(lblDate);
	}

	public JLabel getLblDate() {
		return lblDate;
	}

	public JLabel getLblSender() {
		return lblSender;
	}

	public JLabel getLblSubject() {
		return lblSubject;
	}

	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public void setLblSender(JLabel lblSender) {
		this.lblSender = lblSender;
	}

	public void setLblSubject(JLabel lblSubject) {
		this.lblSubject = lblSubject;
	}

}
