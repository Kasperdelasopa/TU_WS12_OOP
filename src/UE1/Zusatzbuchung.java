package UE1;

import java.util.Date;

public class Zusatzbuchung extends Ereignis {

	private String beschreibung;
	private double betrag;
	// FEHLER: fuer Betrag haette man evtl. eine Invariante angeben koennen um Nullbuchungen zu vermeiden.
	// Aus rechtlicher Sicht koennte eine Beschreibung zwingend erforderlich sein.

	// initialisiert die Zusatzbuchung
	public Zusatzbuchung(Date datum_zeit, double betrag, String beschreibung) {
		super(null, datum_zeit, 0);

		this.beschreibung = beschreibung;
		this.betrag = betrag;
	}

	// liefert eine String-Repraesentation der Zusatzbuchung zurueck
	@Override
	public String toString() {
		return "Zusatzaufwand [beschreibung=" + beschreibung + ", betrag="
				+ betrag + "]";
	}

	// liefert den Beschreibungstext der Beschreibung zurueck
	public String getBeschreibung() {
		return beschreibung;
	}

	// setzt den Beschreibungstext der Zusatzbuchung
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	// liefert den Betrag der Zusatzbuchung zurueck
	public double getBetrag() {
		return betrag;
	}

	// setzt den Betrag der Zusatzbuchung
	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}
}
