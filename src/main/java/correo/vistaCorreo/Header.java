package correo.vistaCorreo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;

public class Header extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7747205704388338181L;
	private int messageNumber;

	public int getMessageNumber() {
		return messageNumber;
	}

	private JLabel lblDate;
	private JLabel lblSender;
	private JLabel lblSubject;

	public Header(int numMessage, String date, String sender, String subject) {
		setBackground(new Color(240, 230, 140));
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		setLayout(flowLayout);

		messageNumber = numMessage;

		lblDate = new JLabel(date);
		lblDate.setBackground(new Color(240, 230, 140));
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setPreferredSize(new Dimension(180, 30));
		lblDate.setToolTipText("Date");
		add(lblDate);
		lblSender = new JLabel(sender);
		lblSender.setBackground(new Color(240, 230, 140));
		lblSender.setHorizontalAlignment(SwingConstants.LEFT);
		lblSender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSender.setPreferredSize(new Dimension(600, 30));
		lblSender.setToolTipText("Sender");
		add(lblSender);

		lblSubject = new JLabel(subject);
		lblSubject.setBackground(new Color(240, 230, 140));
		lblSubject.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubject.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSubject.setPreferredSize(new Dimension(700, 30));
		lblSubject.setToolTipText("Subject");
		add(lblSubject);
		this.setPreferredSize(this.getPreferredSize());
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
