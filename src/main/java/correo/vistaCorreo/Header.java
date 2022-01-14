package correo.vistaCorreo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

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
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(95, 158, 160));
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setAlignOnBaseline(true);
		setLayout(flowLayout);

		messageNumber = numMessage;

		lblDate = new JLabel(date);
		lblDate.setIconTextGap(10);
		lblDate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblDate.setBackground(new Color(230, 230, 250));
		lblDate.setOpaque(true);
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDate.setPreferredSize(new Dimension(180, 30));
		lblDate.setToolTipText("Date");
		add(lblDate);
		lblSender = new JLabel(sender);
		lblSender.setHorizontalTextPosition(SwingConstants.LEADING);
		lblSender.setIconTextGap(10);
		lblSender.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblSender.setOpaque(true);
		lblSender.setBackground(new Color(230, 230, 250));
		lblDate.setOpaque(true);
		lblSender.setHorizontalAlignment(SwingConstants.LEFT);
		lblSender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSender.setPreferredSize(new Dimension(600, 30));
		lblSender.setToolTipText("Sender");
		add(lblSender);

		lblSubject = new JLabel(subject);
		lblSubject.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblSubject.setOpaque(true);
		lblSubject.setBackground(new Color(230, 230, 250));
		lblDate.setOpaque(true);
		lblSubject.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubject.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSubject.setPreferredSize(new Dimension(700, 30));
		lblSubject.setToolTipText("Subject");
		add(lblSubject);
		this.setPreferredSize(new Dimension(1500, 44));
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
