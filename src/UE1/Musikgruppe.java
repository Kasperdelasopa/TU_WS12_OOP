package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Musikgruppe {

	private String ausrichtung;
	private String name;
	// name != null
	
	private Mitglieder mitglieder;
	// mitglieder != null
	
	private Besetzung besetzung;
	// besetzung != null

	private Ersatzmitglieder ersatzmitglieder;
	// ersatzmitglieder != null
	
	private Repertoire repertoire;
	// repertoire != null
	
	private Ereignisse ereignisse;
	// ereignisse != null
	
	private Orte orte;
	// orte != null
	
	
	// initialisiert die Musikgruppe
	public Musikgruppe() {
		init();
	}

	// initialisiert die Musikgruppe und setzt Name und Ausrichtung
	public Musikgruppe(String ausrichtung, String name) {
		init();
		this.setAusrichtung(ausrichtung);
		this.setName(name);
	}

	// initialisiert die Musikgruppe
	private void init() {
		this.orte = new Orte();

		this.setAusrichtung("NotChoosenYet");
		this.setName("NotChoosenYet");

		ersatzmitglieder = new Ersatzmitglieder();
		besetzung = new Besetzung();
		mitglieder = new Mitglieder(ersatzmitglieder, besetzung);

		ereignisse = new Ereignisse();
		repertoire = new Repertoire();
	}

	// liefert die Ausrichtung der Gruppe
	public String getAusrichtung() {
		return ausrichtung;
	}

	// setzt die Ausrichtung der Gruppe;
	// @param ausrichtung != null
	public void setAusrichtung(String ausrichtung) {
		this.ausrichtung = ausrichtung;
	}

	// liefert den Namen der Gruppe
	public String getName() {
		return name;
	}

	// setzt den Namen der Gruppe;
	// @param name != null
	public void setName(String name) {
		this.name = name;
	}

	// liefert alle Auftritte der Gruppe im angebenen Zeitraum;
	// @param von <= bis
	public List<Ereignis> getProben_Auftritte(Date von, Date bis) {

		List<Ereignis> tmp = new ArrayList<Ereignis>();

		tmp.addAll(ereignisse.getProben(von, bis));
		tmp.addAll(ereignisse.getAuftritte(von, bis));

		return tmp;
	}

	// liefert die Kosten aller Proben im angegeben Zeitraum;
	// @param von <= bis
	public double getKosten_Proben(Date von, Date bis) {

		double tmp = 0;

		for (Probe p : ereignisse.getProben()) {

			Date datum = p.getDatum_zeit();
			if ((von.before(datum) && bis.after(datum)) || von.equals(datum)
					|| bis.equals(datum)) {
				tmp += p.getRaummiete();
			}
		}

		return tmp;

	}

	// liefert den Gewinn aller Auftritte im angegebenen Zeitpunkt;
	// @param von <= bis
	public double getGewinn_Auftritte(Date von, Date bis) {

		double tmp = 0;

		for (Auftritt p : ereignisse.getAuftritte()) {

			Date datum = p.getDatum_zeit();
			if ((von.before(datum) && bis.after(datum)) || von.equals(datum)
					|| bis.equals(datum)) {
				tmp += p.getGage();
			}
		}

		return tmp;
	}

	// liefert die Differenz aus Gewinn aller Auftritte und Kosten aller Proben
	// im angegebenen Zeitpunkt;
	// von >= bis
	public double getGage_minus_Miete(Date von, Date bis) {

		return getGewinn_Auftritte(von, bis) - getKosten_Proben(von, bis);
	}

	// liefert alle Mitglieder der Gruppe
	public Mitglieder getMitglieder() {
		return mitglieder;
	}

	// liefert die aktuelle Besetzung der Gruppe
	public Besetzung getBesetzung() {
		return besetzung;
	}

	// liefert die Ersatzmitglieder der Gruppe
	public Ersatzmitglieder getErsatzmitglieder() {
		return ersatzmitglieder;
	}
	
	// liefert das Reportoire der Gruppe
	public Repertoire getRepertoire() {
		return repertoire;
	}

	// liefert alle Ereignisse, die der Gruppe zugeordnet sind
	public Ereignisse getEreignisse() {

		return ereignisse;
	}

	// liefert alle Orte, die der Gruppe zugeordnet sind
	public Orte getOrte() {
		return orte;
	}

	// verschiebt ein Ersatzmitglied in die aktuelle Besetzung sofern dies zulaessig ist.
	// @throws GesperrtException wenn das Ersatzmitglied fuer Auftritte gesperrt ist.
	public Boolean verschiebe(int rein, int raus) throws GesperrtException {

		if (besetzung.getMitglied(raus) != null
				&& ersatzmitglieder.getMitglied(rein) != null) {

			ersatzmitglieder.updateGesperrt(ereignisse);
			if (ersatzmitglieder.getMitglied(rein).getGesperrt())
				throw new GesperrtException("Mitglied mit ID "
						+ ersatzmitglieder.getMitglied(rein).getNummer()
						+ " ist gesperrt");

			besetzung.addMitglied(mitglieder.getMitglied(rein));
			ersatzmitglieder.addMitglied(mitglieder.getMitglied(raus));
			besetzung.deleteMitglied(raus);
			ersatzmitglieder.deleteMitglied(rein);
			return true;
		}

		return false;
	}

}
