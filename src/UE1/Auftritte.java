package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Auftritte {

	List<Auftritt> auftritte;

	public Auftritte() {

		this.auftritte = new ArrayList<Auftritt>();
	}

	public List<Auftritt> getAuftritte() {
		return auftritte;
	}

	public void addAuftritt(double gage, Ort ort, Date datum_zeit,
			double dauer, Besetzung zusammensetzung) {
		
		auftritte.add(new Auftritt(gage, ort, datum_zeit, dauer, zusammensetzung));
	}

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
