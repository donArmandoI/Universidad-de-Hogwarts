package common;

public class Tuberia {

	private boolean programaCerrado;

	public Tuberia() {
		this.programaCerrado = false;
	}

	public synchronized boolean isProgramaCerrado() {
		return programaCerrado;
	}

	public synchronized void setProgramaCerrado(boolean programaCerrado) {
		this.programaCerrado = programaCerrado;
	}

}
