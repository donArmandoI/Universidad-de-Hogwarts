package correo;

/**
 * @author Israel
 * Keeps the synchronization of the email folder.
 */
public class SynchThread extends Thread {
	MailContainer container;

	/**
	 * Main constructor.
	 * @param container - MailContainer - Pipe between the synch tread and the eMail controller.
	 */
	public SynchThread(MailContainer container) {
		super();
		this.container = container;
		System.out.println("Sincronía arrancado");
	}

	@Override
	public void run() {
		// Scans for new eMail every ten seconds
		while (container.isSynch()) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			container.checkNewMessages();
		}
	}

}
