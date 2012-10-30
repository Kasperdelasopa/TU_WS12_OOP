package UE1;

import java.util.ArrayList;
import java.util.Collection;

public class Orte {

	// Invariante: orte != null
	private Collection<Ort> orte;

	// initialisiert die Orte-Sammlung
	public Orte() {
		orte = new ArrayList<Ort>();
	}

	// liefert die gesammelten Orte zur�ck
	public Collection<Ort> getOrte() {
		return orte;
	}

	// liefert alle Orte zur�ck, an denen das Infrastrukturelement
	// "infrastructure" verf�gbar ist.
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
