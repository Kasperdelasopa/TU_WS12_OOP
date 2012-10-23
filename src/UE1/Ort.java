package UE1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Diese Entität beschreibt einen Ort, an dem Ereignisse stattfinden können.
 * 
 * @author Peter Nirschl
 */
public class Ort {

	private String address;
	private String country;
	private String name;
	private Collection<String> infrastructure;

	public Ort() {
		this.infrastructure = new ArrayList<String>();
	}

	public Ort(String address, String country, String name,
			Collection<String> infrastructure) {
		this();

		this.address = address;
		this.country = country;
		this.name = name;

		this.infrastructure.addAll(infrastructure);
	}

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

	@Override
	public String toString() {
		return "Ort [address=" + address + ", country=" + country + ", name="
				+ name + ", infrastructure=" + infrastructure + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<String> getInfrastructure() {
		return infrastructure;
	}

	public void setInfrastructure(Collection<String> infrastructure) {
		this.infrastructure = infrastructure;
	}
}
