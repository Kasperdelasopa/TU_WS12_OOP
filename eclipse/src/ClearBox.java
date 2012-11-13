
public class ClearBox extends Box {

	public ClearBox(Double hoehe, Double breite) {
		super(hoehe, breite, '*', ' ');
	}

	// getSeitenverhaeltniss() > 0
	public Double getSeitenverhaeltniss(){	
		return breite / hoehe;
	}
}
