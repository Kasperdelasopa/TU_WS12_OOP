public class Repeated<P> extends AbstractCompositePict<P> {
	// instances represent pict compositions, that are scaled with
	// a scale factor
	
	private double skalierungsfaktor;
	// skalierungsfaktor > 0.0
	
	public Repeated(P[][] inhalt) {
		this.inhalt = inhalt;
		this.skalierungsfaktor = 1.0;
	}
	// inhalt != null; 
	// creates a new instance of Repeated and initializes the content array
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		
		return sb.toString();
	}
	// returns the picture as String

	@Override
	public void scale(double factor) {
		this.skalierungsfaktor *= factor;
	}
	// 0.1 <= factor <= 10.0; resize the picture composition

}
