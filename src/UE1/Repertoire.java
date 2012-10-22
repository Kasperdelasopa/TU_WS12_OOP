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

	public Musikstueck getMusikstueckByName(String name){
		
		for(Musikstueck ms : this.getRepertoire()){
			if(ms.getName().equals(name))
				return ms;
		}
		return null;
		
	}
	public void addMusikstueck(String name, double dauer) {
		repertoire.add(new Musikstueck(name, dauer));
	}
	
	public void addMusikstueck(Musikstueck m) {
		if(m != null)
			repertoire.add(m);
	}

	/**
	 * Fuegt ein Musikstueck zur Liste hinzu.
	 * 
	 * @param name
	 *            Name des Musikstuecks
	 * @param dauer
	 *            Dauer des Musikstuecks
	 * @param gespieltAb
	 *            Zeitpunkt der ersten Auffuehrung
	 */
	public void addMusikstueck(String name, double dauer, Date gespieltAb) {
		Musikstueck m = new Musikstueck(name, dauer);
		m.setGespieltAb(gespieltAb);
		repertoire.add(m);
	}

	/**
	 * Setzt das Spielende eines Musikstuecks.
	 * 
	 * @param name
	 *            Name des Musikstuecks
	 * @param gespieltBis
	 *            Zeitpunkt der letzten Auffuehrung
	 * @return true wenn das angegebene Musikstueck gefunden und geaendert wurde
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
	@Override
	public String toString(){
		String ret = "";
		if(getRepertoire(new Date()).size() > 0)
			 ret = "Musikstuecke:\n";
		else
			ret = "Musikstuecke:\n<emty>\n";
		
		for(Musikstueck ms : this.getRepertoire(new Date())){
			ret += ms.toString() + "\n";
		}
		
		return ret;
	}
}
