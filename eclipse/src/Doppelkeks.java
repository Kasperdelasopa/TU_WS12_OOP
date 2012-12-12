
public class Doppelkeks extends Crunchable {
	// instances represent double-cookies which consist of two separate cookies
	// merged together into one ultimate super-cookie.
	
	private Keks keks1;
	// keks1 != null
	
	private Keks keks2;
	// keks2 != null
	
	private Fuellung fuellung;
	// fuellung != null
	
	public Doppelkeks(Keks keks1, Keks keks2, Fuellung fuellung) {
		this.keks1 = keks1;
		this.keks2 = keks2;
		this.fuellung = fuellung;
	}
	// initializes a new instance of Doppelkeks
	// @param keks1 != null
	// @param keks2 != null
	// @param fuellung != null

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Doppelkeks [keks1=");
		builder.append(keks1);
		builder.append(", keks2=");
		builder.append(keks2);
		builder.append(", fuellung=");
		builder.append(fuellung);
		builder.append("]");
		return builder.toString();
	}
	// Returns a string representation of the object.

	public Keks getKeks1() {
		return keks1;
	}
	// returns the first sub-cookie
	// returned value != null

	public void setKeks1(Keks keks1) {
		this.keks1 = keks1;
	}
	// sets the first sub-cookie
	// @param keks1 != null

	public Keks getKeks2() {
		return keks2;
	}
	// returns the second sub-cookie
	// @returned value != null

	public void setKeks2(Keks keks2) {
		this.keks2 = keks2;
	}
	// sets the second sub-cookie
	// @param keks2 != null

	public Fuellung getFuellung() {
		return fuellung;
	}
	// returns the stuffing used for this cookie
	// returned value != null

	public void setFuellung(Fuellung fuellung) {
		this.fuellung = fuellung;
	}
	// sets the stuffing for the cookie
	// @param fuellung != null

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Doppelkeks other = (Doppelkeks) obj;
		if (fuellung != other.fuellung) {
			return false;
		}
		if (keks1 == null) {
			if (other.keks1 != null) {
				return false;
			}
		} else if (!keks1.equals(other.keks1)) {
			return false;
		}
		if (keks2 == null) {
			if (other.keks2 != null) {
				return false;
			}
		} else if (!keks2.equals(other.keks2)) {
			return false;
		}
		return true;
	}
	// Indicates whether some other object is "equal to" this one.
}
