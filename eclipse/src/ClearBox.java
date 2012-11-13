
public class ClearBox extends Box {
	// instances represent 2-dimensional pictures
	// consisting of printable characters
	// content has to be blank -> ' '; border = '*'

	// initializes and creates a new instance of ClearBox
	// @param breite, hoehe > 0
	public ClearBox(Double hoehe, Double breite) {
		super(hoehe, breite, '*', ' ');
	}

	// returns ratio between breite and hoehe
	// getSeitenverhaeltniss() > 0
	public Double getSeitenverhaeltniss(){	
		return breite / hoehe;
	}
}
