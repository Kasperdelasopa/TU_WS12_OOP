package UE1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Ereignisse {

	private ArrayList<Auftritt> auftritte;
	private ArrayList<Probe> proben;
	private ArrayList<Zusatzbuchung> zusatzbuchungen;

	public Ereignisse() {

		auftritte = new ArrayList<Auftritt>();
		proben = new ArrayList<Probe>();
		zusatzbuchungen = new ArrayList<Zusatzbuchung>();
	}

	public Collection<Zusatzbuchung> getZusatzkosten() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for (Zusatzbuchung b : zusatzbuchungen) {
			if (b.getBetrag() > 0.0) {
				result.add(b);
			}
		}
		return result;
	}

	public Collection<Zusatzbuchung> getZusatzertraege() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for (Zusatzbuchung b : zusatzbuchungen) {
			if (b.getBetrag() < 0.0) {
				result.add(b);
			}
		}
		return result;
	}

	public Collection<Zusatzbuchung> getNullBuchungen() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for (Zusatzbuchung b : zusatzbuchungen) {
			if (b.getBetrag() == 0.0) {
				result.add(b);
			}
		}
		return result;
	}

	public List<Ereignis> getEreignisse() {

		List<Ereignis> tmp = new ArrayList<Ereignis>();
		tmp.addAll(auftritte);
		tmp.addAll(proben);
		return tmp;
	}

	public List<Ereignis> getVergangene() {

		List<Ereignis> tmp = new ArrayList<Ereignis>();

		for (Ereignis e : getEreignisse()) {

			if (e.getBestaetigt()) {
				tmp.add(e);
			}
		}

		return tmp;
	}

	public List<Ereignis> getZukuenftige() {

		List<Ereignis> tmp = new ArrayList<Ereignis>();

		for (Ereignis e : getEreignisse()) {

			if (!e.getBestaetigt()) {
				tmp.add(e);
			}
		}

		return tmp;
	}

	public List<Auftritt> getAuftritte() {

		return auftritte;
	}

	public List<Probe> getProben() {

		return proben;
	}

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

	public void delProbe(int id) {

		proben.remove(searchProbe(id));
	}

	public void delAuftritt(int id) {

		auftritte.remove(searchAuftritt(id));
	}

	public void delEreignis(int i) {

		auftritte.remove(searchAuftritt(i));
		proben.remove(searchProbe(i));

	}

	public int searchProbe(int i) {
		int pos = 0;

		for (Probe e : getProben()) {
			if (i == e.getId())
				return pos;

			pos++;
		}

		return -1;
	}

	public int searchAuftritt(int i) {
		int pos = 0;

		for (Auftritt e : getAuftritte()) {
			if (i == e.getId())
				return pos;
			pos++;
		}
		return -1;
	}

	/*
	 * public Auftritt getAuftritt(int i){ return auftritte.get(i); }
	 */

	/**
	 * Fuegt ein Ereignis zur Liste hinzu.
	 * 
	 * @param gage
	 *            /miete Höhe der Gage/Miete
	 * @param ort
	 *            Ort des Ereignisses
	 * @param datum_zeit
	 *            Datum des Ereignisses
	 * @param dauer
	 *            Dauer des Ereignisses
	 */

	public void addAuftritt(double gage, Ort ort, Date datum_zeit,
			double dauer, Besetzung zusammensetzung) {
		auftritte.add(new Auftritt(gage, ort, datum_zeit, dauer,
				zusammensetzung));
	}

	public void addProbe(double miete, Ort ort, Date datum_zeit, double dauer,
			Besetzung zusammensetzung) {
		proben.add(new Probe(miete, ort, datum_zeit, dauer, zusammensetzung));
	}
	
	public void addZusatzbuchung(Zusatzbuchung buchung) {
		this.zusatzbuchungen.add(buchung);
	}
	
	public String toString() {
		String ret = "Ereignisse:";
		for (Ereignis e : this.getEreignisse()) {
			ret += "\n" + e.toString();
		}
		return ret;
	}

}