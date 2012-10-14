package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repertoire {

	private ArrayList<Musikstueck> repertoire;

	public Repertoire() {

		repertoire = new ArrayList<Musikstueck>();
	}

	public List<Musikstueck> getRepertoire() {
		return repertoire;
	}

	public List<Musikstueck> getRepertoire(Date am) {

		List<Musikstueck> tmp = new ArrayList<Musikstueck>();

		for (Musikstueck e : getRepertoire()) {

			Date dvon = e.getGespieltAb();
			Date dbis = e.getGespieltBis();
			if ((dvon.before(am) && dbis.after(am))
					|| (dvon.equals(am) || dbis.equals(am))) {
				tmp.add(e);
			}
		}

		return tmp;
	}

	public void addMusikstueck(String name, double dauer) {
		repertoire.add(new Musikstueck(name, dauer));
	}

	/**
	 * F�gt ein Musikst�ck zur Liste hinzu.
	 * 
	 * @param name
	 *            Name des Musikst�cks
	 * @param dauer
	 *            Dauer des Musikst�cks
	 * @param gespieltAb
	 *            Zeitpunkt der ersten Auff�hrung
	 */
	public void addMusikstueck(String name, double dauer, Date gespieltAb) {
		Musikstueck m = new Musikstueck(name, dauer);
		m.setGespieltAb(gespieltAb);
		repertoire.add(m);
	}

	/**
	 * Setzt das Spielende eines Musikst�cks.
	 * 
	 * @param name
	 *            Name des Musikst�cks
	 * @param gespieltBis
	 *            Zeitpunkt der letzten Auff�hrung
	 * @return true wenn das angegebene Musikst�ck gefunden und ge�ndert wurde
	 */
	public Boolean deleteMusikstueck(String name, Date gespieltBis) {
		Boolean ret = false;
		ArrayList<Musikstueck> tmp = new ArrayList<Musikstueck>();

		for (Musikstueck m : getRepertoire()) {
			if (m.getName().equals(name)) {
				tmp.add(m);
				ret = true;
			}
		}

		for (int i = 0; i < tmp.size(); i++) {
			tmp.get(i).setGespieltBis(gespieltBis);
		}

		return ret;
	}
}
