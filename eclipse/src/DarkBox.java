
public class DarkBox extends Box {
// border=content	
		
	//zeichen <> ' '
	public DarkBox(char zeichen, Double hoehe, Double breite) {
		super(hoehe, breite, zeichen, zeichen);
	}

	// sets zeichen
	public void setZeichen(char zeichen){	
		rand = zeichen;
		inhalt = zeichen;
	}
}
