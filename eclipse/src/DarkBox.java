
public class DarkBox extends Box {
// instances represent 2-dimensional pictures
// consisting of printable characters
// instances dont have a border / border=content
		
	//@param zeichen <> ' '
	//@param hoehe = breite
	public DarkBox(char zeichen, Double hoehe, Double breite) {
		super(hoehe, breite, zeichen, zeichen);
	}

	// set border and content
	// @param zeichen <> ' '
	public void setZeichen(char zeichen){	
		rand = zeichen;
		inhalt = zeichen;
	}
}
