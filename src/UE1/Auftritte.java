package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// FEHLER: Klasse Auftritte wird nicht mehr benoetigt - In Klasse Ereignisse befinden sich die Auftritte
public class Auftritte {

	List<Auftritt> auftritte;

        // Initialisiert Auftritte
	public Auftritte() {

		this.auftritte = new ArrayList<Auftritt>();
	}

        // Gibt Auftritte zurueck
	public List<Auftritt> getAuftritte() {
		return auftritte;
	}

        // Objekt Auftritt wird erzeugt und in Liste auftritte hinzugefuegt
	public void addAuftritt(double gage, Ort ort, Date datum_zeit,
			double dauer, Besetzung zusammensetzung) {
		
		auftritte.add(new Auftritt(gage, ort, datum_zeit, dauer, zusammensetzung));
	}

        // Gibt Auftritte einer gegebenen Zeitspanne zurueck
        // @param von<bis
	public List<Auftritt> getAuftritte(Date von, Date bis) {

		List<Auftritt> tmp = new ArrayList<Auftritt>();

		for (Auftritt e : getAuftritte()) {

			Date date = e.getDatum_zeit();
			if ((von.before(date) && bis.after(date)) || von.equals(date)
					|| bis.equals(date)) {
				tmp.add(e);
			}
		}

		return tmp;
	}
}
