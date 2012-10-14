package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proben {

	private List<Probe> proben;

	public Proben() {

		proben = new ArrayList<Probe>();

	}

	public List<Probe> getProben() {
		return proben;
	}

	public void addProbe(double miete, String ort, Date datum_zeit, double dauer) {

		proben.add(new Probe(miete, ort, datum_zeit, dauer));

	}

	/**
	 * Fuegt eine Instanz von Probe zur Liste hinzu.
	 * 
	 * @param probe
	 *            Probe, die aufgenommen werden soll.
	 */
	public void addProbe(Probe probe) {
		proben.add(probe);
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
}
