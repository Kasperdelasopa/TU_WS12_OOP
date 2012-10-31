package UE1;

import java.util.ArrayList;
import java.util.Collection;

public class Orte {
	
	// GOOD: Der Klassenzusammenhang hier ist sehr hoch.
	//       Die Objektkopplung ist schwach, da Orte nur in der Musikgruppe
	//       referenziert wird und nur wenig Nachrichten ausgetauscht werden.

	// Invariante: orte != null
	private Collection<Ort> orte;

	// initialisiert die Orte-Sammlung
	public Orte() {
		orte = new ArrayList<Ort>();
	}

	// liefert die gesammelten Orte zurueck
	public Collection<Ort> getOrte() {
		return orte;
	}

	// liefert alle Orte zurueck, an denen das Infrastrukturelement
	// "infrastructure" verfuegbar ist.
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
