
public class Keks extends Crunchable implements Cloneable {
	// instances represent cookies
	
	private final Teigart teigart;
	// teigart != null
	
	private final Form form;
	// form != null
	
	public Keks(Teigart teigart, Form form) {
		this.teigart = teigart;
		this.form = form;
	}
	// initializes a new instance of Keks
	// @param teigart != null
	// @param form != null
	
	@Override 
	public Keks clone() {
		return new Keks(getTeigart(), getForm());
	}
	// Creates and returns a copy of this object.

	public Teigart getTeigart() {
		return teigart;
	}
	// returns the dough type of the cookie

	public Form getForm() {
		return form;
	}
	// returns the form of the cookie

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Keks [teigart=");
		builder.append(teigart);
		builder.append(", form=");
		builder.append(form);
		builder.append("]");
		return builder.toString();
	}
	// Returns a string representation of the object.

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
		Keks other = (Keks) obj;
		if (form != other.form) {
			return false;
		}
		if (teigart != other.teigart) {
			return false;
		}
		return true;
	}
	// Indicates whether some other object is "equal to" this one.
}
