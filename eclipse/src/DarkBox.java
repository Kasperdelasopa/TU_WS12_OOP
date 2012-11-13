
public class DarkBox extends Box {
// instances represent 2-dimensional pictures
// consisting of printable characters
// instances dont have a border / border=content
		
	//initializes and creates a new instance of DarkBox
	//@param zeichen <> ' ' && zeichen NOT empty
	//@param breite, hoehe > 0
	public DarkBox(char zeichen, Double hoehe, Double breite) {
		super(hoehe, breite, zeichen, zeichen);
	}

	// set border and content
	// @param zeichen <> ' ' AND NOT empty
	public void setZeichen(char zeichen){	
		rand = zeichen;
		inhalt = zeichen;
	}
}
