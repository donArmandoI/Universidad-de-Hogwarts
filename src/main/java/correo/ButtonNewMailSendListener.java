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
import common.Usuario;
import correo.vistaCorreo.JdialogNuevoCorreo;

public class ButtonNewMailSendListener implements ActionListener {
	JdialogNuevoCorreo newMailView;
	private Usuario user;
	
	public ButtonNewMailSendListener(JdialogNuevoCorreo newMailView, Usuario user) {
		// TODO Auto-generated constructor stub
		this.newMailView = newMailView;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			InternetAddress target = new InternetAddress(newMailView.getEmailcreateJtextfieldUser().getText(), true);
			if (addressVerification(target)) {
				// Connection properties object creation and configuration.
				Properties properties = propertiesSetup();

				// Session object creation to represent a mail session with the previously
				// specified properties.
				Session session = Session.getInstance(properties);

				// Create a message with the specified information.
				MimeMessage message = createMessage(target, session);

				// Create a transport.
				SMTPTransport transport = (SMTPTransport) session
						.getTransport(TextES.getButtonnewmailsendlistenertransportprotocolvalue());

				// Connect to Gmail using the SMTP username and password you specified above.
				transport.connect(TextES.getButtonnewmailsendlistenerhost(),
						user.getEmail(), user.getPassword());

				// Send the email.
				transport.sendMessage(message, message.getAllRecipients());
				System.out.println(message.getAllRecipients()[0].toString());
				JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(),
						TextES.getButtonnewmailsendlistenermessagemessagesentok());
				transport.close();
				newMailView.dispose();
			}
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(),
					TextES.getButtonnewmailsendlistenererrormessagemessagenotsent());
			e1.printStackTrace();
		}
	}

	/**
	 * Create a Message instance with data from the config and view.
	 * @param target - InternetAddress - Recipient address.
	 * @param session - Session - The actual connection session.
	 * @return - MimeMessage - The assembled new message.
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	private MimeMessage createMessage(InternetAddress target, Session session)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(user.getEmail(),
				user.getName()));
		message.setRecipient(Message.RecipientType.TO, target);
		message.setSubject(newMailView.getEmailcreateJtextfieldSubject().getText());
		message.setText(newMailView.getEmailcreateJtextareaText().getText(),
				TextES.getButtonnewmailsendlistenerencoding());
		message.setHeader(TextES.getButtonnewmailsendlistenerheaderpropertiy(),
				TextES.getButtonnewmailsendlistenerheadervalue());
		message.setSentDate(new Date());
		return message;
	}

	/**
	 * Checks the recipient address to be a format valid email address.
	 * @param address - InternetAddress - The eMail address to check.
	 * @return - boolean - returns true if the address format is correct or false if it is not.
	 */
	private boolean addressVerification(InternetAddress address) {
		String mail = address.toUnicodeString();
		if (mail.contains("@")) {
			String[] server = mail.split("@");
			if (server.length > 2) {
				JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(),
						TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
				return false;
			} else {
				if (server[1].contains(".")) {
					return true;
				} else {
					JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(),
							TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
					return false;
				}
			}
		} else {
			JOptionPane.showMessageDialog(newMailView.getEmailcreateJtextareaText(),
					TextES.getButtonnewmailsendlistenererrormessageincorrectaddress());
			return false;
		}

	}

	/**
	 * Create and configures the session properties.
	 * @return - Properties - The configured Gmail SMTP session properties.
	 */
	private Properties propertiesSetup() {
		Properties properties = System.getProperties();
		properties.put(TextES.getButtonnewmailsendlistenertransportprotocolproperty(),
				TextES.getButtonnewmailsendlistenertransportprotocolvalue());
		properties.put(TextES.getButtonnewmailsendlistenerprotocolhostproperty(),
				TextES.getButtonnewmailsendlistenerprotocolhostvalue());
		properties.put(TextES.getButtonnewmailsendlistenerprotocolportproperty(),
				TextES.getButtonnewmailsendlistenerprotocolportvalue());
		properties.put(TextES.getButtonnewmailsendlistenerstarttlsproperty(),
				TextES.getButtonnewmailsendlistenerstarttlsvalue());
		properties.put(TextES.getButtonnewmailsendlistenersmtpauthproperty(),
				TextES.getButtonnewmailsendlistenersmtpauthvalue());
		return properties;
	}

}
