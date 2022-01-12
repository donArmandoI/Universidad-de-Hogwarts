package correo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import correo.vistaCorreo.Header;
import correo.vistaCorreo.JdialogLeerCorreo;

/**
 * @author Israel
 *
 */
public class HeaderListener implements MouseListener {
	private Message[] messages;
	JTextArea body = null;
	Message message = null;

	public HeaderListener(Message[] messages) {
		// TODO Auto-generated constructor stub
		this.messages = messages;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			JLabel selected = (JLabel) e.getSource();
			Header head = (Header) selected.getParent();
			System.out.println("Mensaje " + head.getMessageNumber());
			body = new JTextArea(30, 40);
			body.setLineWrap(true);
			body.setEditable(false);
			try {
				getTextFromMessage(messages[head.getMessageNumber() - 1]);
			} catch (IOException | MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JdialogLeerCorreo readMail = new JdialogLeerCorreo(head.getLblSubject().getText(),
					head.getLblSender().getText(), body);
			readMail.getEmailreadJbuttonCancel().addActionListener(new ButtonCancel(readMail));
			System.out.println(body.getText());
			readMail.setVisible(true);
		}
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

	private void getTextFromMessage(Message message) throws IOException, MessagingException {
		if (message.isMimeType("text/plain")) {
			body.append(message.getContent().toString());
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			getTextFromMimeMultipart(mimeMultipart);
		}
	}

	private void getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws IOException, MessagingException {
		int count = mimeMultipart.getCount();
		if (count == 0)
			throw new MessagingException("Multipart with no body parts not supported.");
		boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
		if (multipartAlt)
			getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			getTextFromBodyPart(bodyPart);
		}
	}

	private void getTextFromBodyPart(BodyPart bodyPart) throws IOException, MessagingException {
		if (bodyPart.isMimeType("text/plain")) {
			body.append(((String) bodyPart.getContent()));
			body.append(System.getProperty("line.separator"));
		} else if (bodyPart.isMimeType("text/html")) {
			String html = (String) bodyPart.getContent();
			body.append(org.jsoup.Jsoup.parse(html).text());
			body.append(System.getProperty("line.separator"));
		} else if (bodyPart.getContent() instanceof MimeMultipart) {
			getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
		}
	}
}
