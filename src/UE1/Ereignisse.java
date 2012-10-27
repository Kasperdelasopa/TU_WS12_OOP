package UE1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Ereignisse {

	private ArrayList<Auftritt> auftritte;
	private ArrayList<Probe> proben;
	private ArrayList<Zusatzbuchung> zusatzbuchungen;

        // Initialisiert Ereignisse
	public Ereignisse() {

		auftritte = new ArrayList<Auftritt>();
		proben = new ArrayList<Probe>();
		zusatzbuchungen = new ArrayList<Zusatzbuchung>();
	}

        // Gibt alle Zusatzbuchungen zurueck, deren Betrag > 0 ist
	public Collection<Zusatzbuchung> getZusatzkosten() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for (Zusatzbuchung b : zusatzbuchungen) {
			if (b.getBetrag() > 0.0) {
				result.add(b);
			}
		}
		return result;
	}

        // Gibt Zusatzbuchungen zurueck, deren Betrag < 0 ist
	public Collection<Zusatzbuchung> getZusatzertraege() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for (Zusatzbuchung b : zusatzbuchungen) {
			if (b.getBetrag() < 0.0) {
				result.add(b);
			}
		}
		return result;
	}

        // Gibt Zusatzbuchungen zurueck, deren Betrag = 0 ist
	public Collection<Zusatzbuchung> getNullBuchungen() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for (Zusatzbuchung b : zusatzbuchungen) {
			if (b.getBetrag() == 0.0) {
				result.add(b);
			}
		}
		return result;
	}

        // Gibt Auftritte und Proben zurueck
	public List<Ereignis> getEreignisse() {

		List<Ereignis> tmp = new ArrayList<Ereignis>();
		tmp.addAll(auftritte);
		tmp.addAll(proben);
		return tmp;
	}

        // Gibt vergangenen Ereignisse(Auftritte, Proben) zurueck
	public List<Ereignis> getVergangene() {

		List<Ereignis> tmp = new ArrayList<Ereignis>();

		for (Ereignis e : getEreignisse()) {

			if (e.getBestaetigt()) {
				tmp.add(e);
			}
		}

		return tmp;
	}

        // Gibt zukuenftigen Ereignisse(Auftritte, Proben) zurueck
	public List<Ereignis> getZukuenftige() {

		List<Ereignis> tmp = new ArrayList<Ereignis>();

		for (Ereignis e : getEreignisse()) {

			if (!e.getBestaetigt()) {
				tmp.add(e);
			}
		}

		return tmp;
	}

        // Gibt auftritte zurueck
	public List<Auftritt> getAuftritte() {

		return auftritte;
	}

        // Gibt proben zurueck
	public List<Probe> getProben() {

		return proben;
	}

        // Gibt Proben eines bestimmten Zeitraums zurueck
        // @param von<=bis
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

        // Gibt Auftritte eines bestimmten Zeitraums zurueck
        // @param von<=bis
	public List<Auftritt> getAuftritte(Date von, Date bis) {

		List<Auftritt> tmp = new ArrayList<Auftritt>();

		for (Auftritt e : getAuftritte()) {

			Date date = e.getDatum_zeit();
			if ((von.before(date) && bis.after(date))
					|| (von.equals(date) || bis.equals(date))) {
				tmp.add(e);
			}
		}

		return tmp;
	}

        // Gibt Ereignisse(Auftritte,Proben) eines bestimmten Zeitraums zurueck
        // @param von<=bis
	public List<Ereignis> getEreignisse(Date von, Date bis) {

		List<Ereignis> tmp = new ArrayList<Ereignis>();

		for (Ereignis e : getEreignisse()) {

			Date date = e.getDatum_zeit();
			if ((von.before(date) && bis.after(date))
					|| (von.equals(date) || bis.equals(date))) {
				tmp.add(e);
			}
		}

		return tmp;
	}

        // Entfernt Probe mit entsprechender id aus proben
        // @param id>=0
	public void delProbe(int id) {

		proben.remove(searchProbe(id));
	}
        
        // Entfernt Auftritt mit entsprechender id aus auftritte
        // @param id>=0
	public void delAuftritt(int id) {

		auftritte.remove(searchAuftritt(id));
	}

        // Entfernt Auftritt oder Probe mit der entsprechenden id
	public void delEreignis(int i) {

		auftritte.remove(searchAuftritt(i));
		proben.remove(searchProbe(i));

	}

        // Gibt Probe mit der entsprechenden ID zurueck
        // @param i>=0
	public int searchProbe(int i) {
		int pos = 0;

		for (Probe e : getProben()) {
			if (i == e.getId())
				return pos;

			pos++;
		}

		return -1;
	}

        // Gibt Auftritt mit der entsprechenden ID zurueck
        // @param i>=0
	public int searchAuftritt(int i) {
		int pos = 0;

		for (Auftritt e : getAuftritte()) {
			if (i == e.getId())
				return pos;
			pos++;
		}
		return -1;
	}

	
        // Fuegt ein Auftritt in die Liste auftritte
	public void addAuftritt(double gage, Ort ort, Date datum_zeit,
			double dauer, Besetzung zusammensetzung) {
		auftritte.add(new Auftritt(gage, ort, datum_zeit, dauer,
				zusammensetzung));
	}

        // Fuegt eine Probe in die Liste proben
	public void addProbe(double miete, Ort ort, Date datum_zeit, double dauer,
			Besetzung zusammensetzung) {
		proben.add(new Probe(miete, ort, datum_zeit, dauer, zusammensetzung));
	}
	
        // Fuegt eine Zusatzbuchung in die Liste zusatzbuchungen
	public void addZusatzbuchung(Zusatzbuchung buchung) {
		this.zusatzbuchungen.add(buchung);
	}
	
        //FEHLER: Override-Annotation vergessen - kein großer Fehler 
        // Gibt Ereignisse(Auftritte/Proben) im String-Format zurueck
	public String toString() {
		String ret = "Ereignisse:";
		for (Ereignis e : this.getEreignisse()) {
			ret += "\n" + e.toString();
		}
		return ret;
	}

}
