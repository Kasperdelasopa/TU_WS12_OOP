package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repertoire {

	private ArrayList<Musikstueck> repertoire;
	// Invariante: reportoire != null
	// Invariante: fuer alle Musikstuecke m1...mn in reportioire gilt: 
	//             m1.getName() != m2.getName() != ... != mn.getName()

	// initialisiert das Reportoire
	public Repertoire() {

		repertoire = new ArrayList<Musikstueck>();
	}

	// Liefert alle Musikstuecke des Reportoires zurueck
	public List<Musikstueck> getRepertoire() {
		return repertoire;
	}

	// liefert jene Musikstuecke, die sich zum gegebenen Zeitpunk im Reportoire
	// befanden
	// @param am <> null
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

	// durchsucht das Reportoire nach einem Musikstueck, das auf Grund des
	// gegebenen Namens identifiziert wird, oder null falls der Name nicht im
	// Reportoire vorhanden ist.
	// @param name != null
	public Musikstueck getMusikstueckByName(String name) {

		for (Musikstueck ms : this.getRepertoire()) {
			if (ms.getName().equals(name))
				return ms;
		}
		return null;

	}

	// erstellt eine Instanz von Musikstueck und fuegt dieses zum Reportoire hinzu
	// @param name != null
	public void addMusikstueck(String name, double dauer) {
		repertoire.add(new Musikstueck(name, dauer));
	}

	// fuegt ein Musikstueck zum Reportoire hinzu
	// @param m != null
	public void addMusikstueck(Musikstueck m) {
		if (m != null)
			repertoire.add(m);
	}

	// erstellt eine Instanz von Musikstueck und fuegt dieses zum Reportoire hinzu
	// @param name != null
	// @param dauer > 0
	public void addMusikstueck(String name, double dauer, Date gespieltAb) {
		Musikstueck m = new Musikstueck(name, dauer);
		m.setGespieltAb(gespieltAb);
		repertoire.add(m);
	}

	// setzt fuer das Musikstueck den Zeitpunkt, bis zu dem es gespielt wurde.
	// @param name != null
	// FEHLER: die Vorgehensweise im Code widerspricht der Invariante, 
	//         dass der Name des Musikstuecks unique im Reportoire sein muss.
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

	// liefert eine String-Repraesentation des Reportoires und listet die 
	// String-Repraesentationen aller Musikstuecke auf
	@Override
	public String toString() {
		String ret = "";
		if (getRepertoire(new Date()).size() > 0)
			ret = "Musikstuecke:\n";
		else
			ret = "Musikstuecke:\n<emty>\n";

		for (Musikstueck ms : this.getRepertoire(new Date())) {
			ret += ms.toString() + "\n";
		}

		return ret;
	}
}
