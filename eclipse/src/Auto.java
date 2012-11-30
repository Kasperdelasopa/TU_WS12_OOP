
public abstract class Auto {

	private Fahrtrichtung richtung;
	private Strategie strategie;
	private Feld currentField;
	private int punkte;
	private AutoEventListener autoEventListeners; 
	private int anzahlSchritte;
	public int GESCHWINDIGKEIT;
	public final int MAX_SCHRITTE = 200;
	
	
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
	public AutoEventListener getAutoEventListeners() {
		return autoEventListeners;
	}
	public int getAnzahlSchritte() {
		return anzahlSchritte;
	}
	public int getGESCHWINDIGKEIT() {
		return GESCHWINDIGKEIT;
	}
	public int getMAX_SCHRITTE() {
		return MAX_SCHRITTE;
	}
}
