package UE1;

import java.util.ArrayList;
import java.util.Collection;

public class Orte {

	private Collection<Ort> orte;

	public Orte() {
		orte = new ArrayList<Ort>();
	}

	public Collection<Ort> getOrte() {
		return orte;
	}

	public Collection<Ort> findOrteByInfrastructure(String infrastructure) {
		Collection<Ort> result = new ArrayList<Ort>();

		for (Ort o : getOrte()) {
			if (o.getInfrastructure().contains(infrastructure)) {
				result.add(o);
			}
		}
		return result;
	}

}
