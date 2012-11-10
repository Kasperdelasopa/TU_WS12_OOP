
public class ClearBox extends Box {

	public ClearBox(Double hoehe, Double breite) {
		super(hoehe, breite, '*', ' ');
	}

	// getSeitenverhältniss() > 0
	public Double getSeitenverhältniss(){	
		return breite / hoehe;
	}
}
