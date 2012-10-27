package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// FEHLER: Klasse Proben wird nicht mehr benoetigt - In Klasse Ereignisse befinden sich die Proben
public class Proben {

	private List<Probe> proben;

        // Initialisiert Proben
	public Proben() {

		proben = new ArrayList<Probe>();

	}

        // Gibt Proben zurueck
	public List<Probe> getProben() {
		return proben;
	}

        // Objekt Auftritt wird erzeugt und in Liste auftritte hinzugefuegt
	public void addProbe(double miete, Ort ort, Date datum_zeit, double dauer, Besetzung zusammensetzung) {

		proben.add(new Probe(miete, ort, datum_zeit, dauer, zusammensetzung));

	}

	// Fuegt eine Instanz von Probe zur Liste hinzu.
	public void addProbe(Probe probe) {
		proben.add(probe);
	}

        // Gibt Proben einer gegebenen Zeitspanne zurueck
        // @param von<bis
	public List<Probe> getProben(Date von, Date bis) {

		List<Probe> tmp = new ArrayList<Probe>();

		for (Probe e : getProben()) {

			Date date = e.getDatum_zeit();
			if ((von.before(date) && bis.after(date))
					|| (von.equals(date) || bis.equals(date))) {
				tmp.add(e);
			}
		}

		return tmp;
	}
}
