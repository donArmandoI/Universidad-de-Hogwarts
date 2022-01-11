package correo;

public class SynchThread extends Thread{
	MailContainer container;

	public SynchThread(MailContainer container) {
		super();
		this.container = container;
		System.out.println("Sincronía arrancado");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(container.isSynch()) {
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Correo sincronizado");
		}
	}
	
	
}
