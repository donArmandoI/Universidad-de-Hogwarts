package correo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.event.MessageCountAdapter;
import javax.mail.event.MessageCountEvent;
import javax.mail.internet.InternetAddress;

import common.TextES;
import correo.vistaCorreo.Header;
import correo.vistaCorreo.VistaCorreo;

/**
 * @author Israel
 * Pipe between the eMail controller and the synch thread.
 */
public class MailContainer {
	VistaCorreo mailView;
	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props);
	Store store;
	Folder inbox;
	Message[] messages;
	/**
	 * boolean - Keeps the synch thread running as long as it is true.
	 */
	boolean synch = true;

	/**
	 * Main constructor.
	 * @param mailView - VistaCorreo - eMail main view.
	 */
	public MailContainer(VistaCorreo mailView) {
		this.mailView = mailView;
	}

	/**
	 * Configure the properties of the IMAP connection session.
	 */
	public void prepareConnectionProperties() {
		props.setProperty(TextES.getMailContainerPropertiesProtocolProperty(),
				TextES.getMailContainerPropertiesProtocolValue());
		props.setProperty(TextES.getMailContainerPropertiesHostProperty(),
				TextES.getMailContainerPropertiesHostValue());
		props.setProperty(TextES.getMailContainerPropertiesPortProperty(),
				TextES.getMailContainerPropertiesPortValue());
		props.setProperty(TextES.getMailContainerPropertiesSSLSocketFactoryClassProperty(),
				TextES.getMailContainerPropertiesSSLSocketFactoryClassValue());
		props.setProperty(TextES.getMailContainerPropertiesSocketFactoryFallbackProperty(),
				TextES.getMailContainerPropertiesSocketFactoryFallbackValue());
		props.setProperty(TextES.getMailContainerPropertiesSocketFactoryPortProperty(),
				TextES.getMailContainerPropertiesSocketFactoryPortValue());
	}

	/**
	 * Establish the connection, create the store and download the selected folder, then activates the listener for new messages and call the message conversion.
	 */
	public synchronized void downloadMails() {
		session = Session.getInstance(props);
		try {
			store = session.getStore();
			store.connect(TextES.getMailContainerConnectUserName(), TextES.getMailContainerConnectPassword());
			inbox = store.getFolder(TextES.getMailContainerConnectTargetFolder());
			inbox.open(Folder.READ_ONLY);
			inbox.addMessageCountListener(new MessageCountAdapter() {
				public void messagesAdded(MessageCountEvent ev) {
					System.out.println("Mensajes actualizados");
					try {
						messages = inbox.getMessages();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					readMails();
				}
			});
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Checks the folder for new messages.
	 */
	public void checkNewMessages() {
		try {
			inbox.getMessageCount();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Converts each message in the folder to a Header view element and adds it to the main view.
	 */
	public void readMails() {
		try {
			messages = inbox.getMessages();
			mailView.clearMessages();
			for (int i = 0; i < messages.length; i++) {
				Header head = new Header(messages[i].getMessageNumber(), extractDate(messages[i]),
						extractSenders(messages[i]), messages[i].getSubject());
				head.getLblDate().addMouseListener(new HeaderListener(messages));
				head.getLblSender().addMouseListener(new HeaderListener(messages));
				head.getLblSubject().addMouseListener(new HeaderListener(messages));
				System.out.println(messages[i].getMessageNumber());
				mailView.addMessage(head);
			}
			mailView.repaint();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Extracts and returns the senders on the received message.
	 * @param message - Message - The message to extract the senders from.
	 * @return - Address[] - List of message's senders.
	 */
	private String extractSenders(Message message) {
		StringBuilder sender = new StringBuilder(150);
		Address[] senders;
		try {
			senders = message.getFrom();
			for (int i = 0; i < senders.length; i++) {
				InternetAddress address = new InternetAddress(senders[i].toString());
				sender.append(address.toUnicodeString() + " ");
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sender.toString();
	}

	/**
	 * Extracts and returns the reception date from the message received.
	 * @param message - Message - Message to extract the reception date from.
	 * @return - String - The message received date.
	 */
	private String extractDate(Message message) {
		String date = null;
		Date dateRecived;
		try {
			dateRecived = message.getSentDate();
			DateFormat dateFormat = new SimpleDateFormat(TextES.getMailContainerDateFormat());
			date = dateFormat.format(dateRecived);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * @return - Folder - The selected eMail folder.
	 */
	public Folder getInbox() {
		return inbox;
	}

	/**
	 * Keeps the synch thread running while is true.
	 * @return - boolean - returns the synch thread keeper state.
	 */
	public boolean isSynch() {
		return synch;
	}

	/**
	 * Sets the synch thread running indicator.
	 * @param synch - boolean - set the shync thread keeper state.
	 */
	public void setSynch(boolean synch) {
		this.synch = synch;
	}
}
