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
	 * Fügt ein Musikstück zur Liste hinzu.
	 * @param name Name des Musikstücks
	 * @param dauer Dauer des Musikstücks
	 * @param gespieltAb Zeitpunkt der ersten Aufführung
	 */
	public void addMusikstueck(String name, double dauer, Date gespieltAb) {
		Musikstueck m = new Musikstueck(name, dauer);
		m.setGespieltAb(gespieltAb);
		repertoire.add(m);
	}

	/**
	 * Setzt das Spielende eines Musikstücks.
	 * 
	 * @param name
	 *            Name des Musikstücks
	 * @param gespieltBis
	 *            Zeitpunkt der letzten Aufführung
	 * @return true wenn das angegebene Musikstück gefunden und geändert wurde
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

	// TODO ggf das Code-Segment überarbeiten
	// Anmerkung von Peter Nirschl: der Code wird eine Exception auslösen.
	// Grund dafür ist, dass die List nicht bearbeitet werden darf solange ein
	// Iterator darüberläuft.
	// //Wird nicht gelöscht, sondern das gespieltBis Attribut gesetzt auf heute
	// public Boolean deleteMusikstueck(String name){
	// Boolean ret = false;
	//
	// List<Musikstueck> tmp = getRepertoire();
	//
	// for(Musikstueck m : getRepertoire()){
	// if(m.getName() == name){
	// m.setGespieltBis(new Date());
	// ret = true;
	// }
	//
	// tmp.add(m);
	//
	// }
	//
	// this.repertoire = (ArrayList<Musikstueck>)tmp;
	//
	// return ret;
	//
	// }
}
