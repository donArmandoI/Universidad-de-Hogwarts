package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import com.sun.mail.smtp.SMTPTransport;

import common.TextES;
import correo.vistaCorreo.JdialogNuevoCorreo;

public class ButtonNewMailSendListener implements ActionListener {
	JdialogNuevoCorreo newMailView;
	
	public ButtonNewMailSendListener(JdialogNuevoCorreo newMailView) {
		// TODO Auto-generated constructor stub
		this.newMailView = newMailView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Verificación de dirección, ensamblaje del mensaje y envio
				try {
					InternetAddress target = new InternetAddress(newMailView.getEmailcreateJtextfieldUser().getText(), true);
					if (addressVerification(target)) {
						// Connection properties object creation and configuration.
						Properties properties = propertiesSetup();
			
				        // Session object creation to represent a mail session with the previously specified properties. 
				    	Session session = Session.getInstance(properties);
			
				        // Create a message with the specified information.
				        MimeMessage message = new MimeMessage(session);
				        message.setFrom(new InternetAddress("ialonsocalzado.sanjose@alumnado.fundacionloyola.net","Israel"));
				        message.setRecipient(Message.RecipientType.TO, target);
				        message.setSubject(newMailView.getEmailcreateJtextfieldSubject().getText());
				        message.setText(newMailView.getEmailcreateJtextareaText().getText(), "UTF-8");
				        message.setHeader("X-Mailer", "smtpsend");
				        message.setSentDate(new Date());
				            
				        // Create a transport.
				        SMTPTransport transport =
				        		(SMTPTransport)session.getTransport(TextES.getButtonnewmailsendlistenertransportprotocolvalue());
//				        Transport transport = session.getTransport(TextES.getButtonnewmailsendlistenertransportprotocolvalue());
				                    
				        // Connect to Gmail using the SMTP username and password you specified above.
			            transport.connect(TextES.getButtonnewmailsendlistenerhost(), TextES.getButtonnewmailsendlistenersmtpusername(), TextES.getButtonnewmailsendlistenersmtppassword());
//			        	transport.connect();
			        	
			            // Send the email.
			            transport.sendMessage(message, message.getAllRecipients());
			            System.out.println(message.getAllRecipients()[0].toString());
						transport.close();
			            JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(), TextES.getButtonnewmailsendlistenermessagemessagesentok());
					}
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(), TextES.getButtonnewmailsendlistenererrormessagemessagenotsent());
					e1.printStackTrace();
				}
	}

	private boolean addressVerification (InternetAddress address) {
		// TODO comrobar arroba y punto después de arroba
		String mail = address.toUnicodeString();
		if (mail.contains("@")) {
			String[] server = mail.split("@");
			if(server.length > 2) {
				JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(), TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
				return false;
			} else {
				if (server[1].contains(".")) {
					return true;
				} else {
					JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(), TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
					return false;
				}
			} 
		} else {
			JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(), TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
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

}
