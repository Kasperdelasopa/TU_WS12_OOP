package UE1;

import java.util.Date;

public class Zusatzbuchung extends Ereignis {

	private String beschreibung;
	private double betrag;

	public Zusatzbuchung(Date datum_zeit, double betrag, String beschreibung) {
		super(null, datum_zeit, 0);

		this.beschreibung = beschreibung;
		this.betrag = betrag;
	}

	@Override
	public String toString() {
		return "Zusatzaufwand [beschreibung=" + beschreibung + ", betrag="
				+ betrag + "]";
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}
}
