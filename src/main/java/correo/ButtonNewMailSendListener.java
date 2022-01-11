package correo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.mail.smtp.SMTPTransport;

import common.TextES;

public class ButtonNewMailSendListener implements MouseListener {
	JTextField user;
	JTextField subject;
	JTextArea bodyText;
	
	public ButtonNewMailSendListener(JTextField emailcreateJtextfieldUser, JTextField emailcreateJtextfieldSubject,
			JTextArea emailcreateJtextareaText) {
		// TODO Auto-generated constructor stub
		user = emailcreateJtextfieldUser;
		subject = emailcreateJtextfieldSubject;
		bodyText = emailcreateJtextareaText;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Verificación de dirección, ensamblaje del mensaje y envio
		try {
			InternetAddress target = new InternetAddress(user.getText(), true);
			if (addressVerification(target)) {
				// Connection properties object creation and configuration.
				Properties properties = propertiesSetup();
	
		        // Session object creation to represent a mail session with the previously specified properties. 
		    	Session session = Session.getInstance(properties);
	
		        // Create a message with the specified information.
		        MimeMessage message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("ialonsocalzado.sanjose@alumnado.fundacionloyola.net","Israel"));
		        message.setRecipient(Message.RecipientType.TO, target);
		        message.setSubject(subject.getText());
		        message.setText(bodyText.getText(), "UTF-8");
		        message.setHeader("X-Mailer", "smtpsend");
		        message.setSentDate(new Date());
		            
		        // Create a transport.
		        SMTPTransport transport =
		        		(SMTPTransport)session.getTransport(TextES.getButtonnewmailsendlistenertransportprotocolvalue());
//		        Transport transport = session.getTransport(TextES.getButtonnewmailsendlistenertransportprotocolvalue());
		                    
		        // Connect to Gmail using the SMTP username and password you specified above.
	            transport.connect(TextES.getButtonnewmailsendlistenerhost(), TextES.getButtonnewmailsendlistenersmtpusername(), TextES.getButtonnewmailsendlistenersmtppassword());
//	        	transport.connect();
	        	
	            // Send the email.
	            transport.sendMessage(message, message.getAllRecipients());
	            System.out.println(message.getAllRecipients()[0].toString());
				transport.close();
	            JOptionPane.showMessageDialog(bodyText, TextES.getButtonnewmailsendlistenermessagemessagesentok());
			}
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(bodyText, TextES.getButtonnewmailsendlistenererrormessagemessagenotsent());
			e1.printStackTrace();
		}
		
	        
		
		
		
		
	}
	
	private boolean addressVerification (InternetAddress address) {
		// TODO comrobar arroba y punto después de arroba
		String mail = address.toUnicodeString();
		if (mail.contains("@")) {
			String[] server = mail.split("@");
			if(server.length > 2) {
				JOptionPane.showMessageDialog(bodyText, TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
				return false;
			} else {
				if (server[1].contains(".")) {
					return true;
				} else {
					JOptionPane.showMessageDialog(bodyText, TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
					return false;
				}
			} 
		} else {
			JOptionPane.showMessageDialog(bodyText, TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
			return false;
		}

	}

	private Properties propertiesSetup() {
		Properties properties = System.getProperties();
		properties.put(TextES.getButtonnewmailsendlistenertransportprotocolproperty(), TextES.getButtonnewmailsendlistenertransportprotocolvalue());
    	properties.put(TextES.getButtonnewmailsendlistenerprotocolhostproperty(), TextES.getButtonnewmailsendlistenerprotocolhostvalue());
    	properties.put(TextES.getButtonnewmailsendlistenerprotocolportproperty(), TextES.getButtonnewmailsendlistenerprotocolportvalue()); 
    	properties.put(TextES.getButtonnewmailsendlistenerstarttlsproperty(), TextES.getButtonnewmailsendlistenerstarttlsvalue());
    	properties.put(TextES.getButtonnewmailsendlistenersmtpauthproperty(), TextES.getButtonnewmailsendlistenersmtpauthvalue());
		return properties;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
