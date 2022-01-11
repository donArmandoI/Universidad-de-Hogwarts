package correo;

public class SynchThread extends Thread{
	MailContainer container;

	public SynchThread(MailContainer container) {
		super();
		this.container = container;
		System.out.println("Sincron�a arrancado");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(container.isSynch()) {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			container.downloadMails();
			System.out.println("Correo sincronizado");
		}
	}
	
	
}