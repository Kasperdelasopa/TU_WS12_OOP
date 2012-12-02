
public abstract class Auto implements Runnable {

	public final int MAX_SCHRITTE = 200;
	
	private Fahrtrichtung richtung;
	private Strategie strategie;
	private Feld currentField;
	private int punkte = 0;
	private AutoEventListener autoEventListener; 
	private int anzahlSchritte = 0;
		
	protected abstract void move();
	
	public abstract int getGeschwindigkeit();
	
	public Auto(Feld startFeld, Fahrtrichtung initialRichtung, Strategie strategie) {
		this.currentField = startFeld;
		this.richtung = initialRichtung;
		this.strategie = strategie;
	}
	
	@Override
	public void run() {
		boolean run = true;
		
		while(run) {
			move();
			try {
				this.wait( 1 / getGeschwindigkeit() );
			} catch (InterruptedException e) {
				run = false;
			}
		}
	}
	
	public Fahrtrichtung getRichtung() {
		return richtung;
	}
	
	public Strategie getStrategie() {
		return strategie;
	}
	
	public Feld getCurrentField() {
		return currentField;
	}
	
	public int getPunkte() {
		return punkte;
	}
	
	public AutoEventListener getAutoEventListener() {
		return autoEventListener;
	}
	
	public void setAutoEventListener(AutoEventListener autoEventListener) {
		this.autoEventListener = autoEventListener;
	}
	
	public int getAnzahlSchritte() {
		return anzahlSchritte;
	}
}
