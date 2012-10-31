package UE1;

import java.util.ArrayList;
import java.util.Collection;

public class Ort {

	// GOOD: Der Klassenzusammenhang hier ist hoch, da Methoden und Variablen
	//       gut miteinander zusammenarbeiten.
	
	private String address;
	private String country;
	private String name;
	// Invariante: infrastructure != null
	private Collection<String> infrastructure;

	// initialisiert Ort
	public Ort() {
		this.infrastructure = new ArrayList<String>();
	}

	// initialisiert Ort mit Standardparametern
	// @param infrastructure != null
	// FEHLER: die Bedingung infrastructure != null wird nicht auf Einhaltung
	// geprueft
	public Ort(String address, String country, String name,
			Collection<String> infrastructure) {
		this();

		this.address = address;
		this.country = country;
		this.name = name;

		this.infrastructure.addAll(infrastructure);
	}

	// liefert einen Hashcode fuer den Ort zurueck
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((infrastructure == null) ? 0 : infrastructure.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// prueft den Ort auf Gleichheit mit dem Parameter obj und gibt true zurueck
	// wenn der Paremeter dem Objekt gleicht.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ort other = (Ort) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (infrastructure == null) {
			if (other.infrastructure != null)
				return false;
		} else if (!infrastructure.equals(other.infrastructure))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// liefert eine String-Repraesentation des Objekts zurueck
	@Override
	public String toString() {
		return "Ort [address=" + address + ", country=" + country + ", name="
				+ name + ", infrastructure=" + infrastructure + "]";
	}

	// liefert die Adresse des Orts zurueck
	public String getAddress() {
		return address;
	}

	// setzt die Adresse des Ortes
	public void setAddress(String address) {
		this.address = address;
	}

	// liefert das Land des Ortes zurueck
	public String getCountry() {
		return country;
	}

	// setzt das Land des Ortes
	public void setCountry(String country) {
		this.country = country;
	}

	// liefert den Namen des Ortes zurueck
	public String getName() {
		return name;
	}

	// setzt den Namen des Ortes
	public void setName(String name) {
		this.name = name;
	}

	// liefert die verfuegbare Inrastruktur des Ortes zurueck
	public Collection<String> getInfrastructure() {
		return infrastructure;
	}

	// ersetzt die Infrastruktur des Ortes
	// @param infrastructure != null
	// FEHLER: die Invariante "infrastructure != NulL" wird nicht geprueft
	public void setInfrastructure(Collection<String> infrastructure) {
		this.infrastructure = infrastructure;
	}
}
