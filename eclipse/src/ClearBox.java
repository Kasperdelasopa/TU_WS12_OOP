
public class ClearBox extends Box {

	public ClearBox(Double hoehe, Double breite) {
		super(hoehe, breite, '*', ' ');
	}

	// getSeitenverh�ltniss() > 0
	public Double getSeitenverh�ltniss(){	
		return breite / hoehe;
	}
}
