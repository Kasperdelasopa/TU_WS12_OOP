package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Musikgruppe {

	private String ausrichtung;
	private String name;
	private Mitglieder mitglieder;
	private Repertoire repertoire;
	private Proben proben;
	private Auftritte auftritte;

	public Musikgruppe() {
		init();
	}

	public Musikgruppe(String ausrichtung, String name) {
		init();
		this.setAusrichtung(ausrichtung);
		this.setName(name);
	}

	private void init() {
		this.setAusrichtung("NotChoosenYet");
		this.setName("NotChoosenYet");

		mitglieder = new Mitglieder();
		proben = new Proben();
		auftritte = new Auftritte();
		repertoire = new Repertoire();
	}

	public String getAusrichtung() {
		return ausrichtung;
	}

	public void setAusrichtung(String ausrichtung) {
		this.ausrichtung = ausrichtung;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ereignis> getProben_Auftritte(Date von, Date bis) {

		List<Ereignis> tmp = new ArrayList<Ereignis>();

		tmp.addAll(proben.getProben(von, bis));
		tmp.addAll(auftritte.getAuftritte(von, bis));

		return tmp;
	}

	public double getKosten_Proben(Date von, Date bis) {

		double tmp = 0;

		for (Probe p : proben.getProben()) {

			Date datum = p.getDatum_zeit();
			if ((von.before(datum) && bis.after(datum)) || von.equals(datum)
					|| bis.equals(datum)) {
				tmp += p.getRaummiete();
			}
		}

		return tmp;

	}

	public double getGewinn_Auftritte(Date von, Date bis) {

		double tmp = 0;

		for (Auftritt p : auftritte.getAuftritte()) {

			Date datum = p.getDatum_zeit();
			if ((von.before(datum) && bis.after(datum)) || von.equals(datum)
					|| bis.equals(datum)) {
				tmp += p.getGage();
			}
		}

		return tmp;
	}

	public double getGage_minus_Miete(Date von, Date bis) {

		return getGewinn_Auftritte(von, bis) - getKosten_Proben(von, bis);
	}

	public Mitglieder getMitglieder() {
		return mitglieder;
	}

	public Repertoire getRepertoire() {
		return repertoire;
	}

	public Auftritte getAuftritte() {
		return auftritte;
	}

	public Proben getProben() {
		return proben;
	}
}
