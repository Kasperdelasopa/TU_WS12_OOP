public class Repeated<P> extends AbstractCompositePict<P> {
	// instances represent pict compositions, that are scaled with
	// a scale factor
	
	private double skalierungsfaktor;
	// skalierungsfaktor > 0.0
	
	public Repeated(P[][] inhalt) {
		super(inhalt);
		this.skalierungsfaktor = 1.0;
	}
	// inhalt != null; 
	// inhalt.length > 0;
	// creates a new instance of Repeated and initializes the content array
	
	@Override
	public String toString() {
		String[] lines = super.toString().split(LINE_FEED);
		StringBuffer output = new StringBuffer();
		
		int lineWidth = lines[0].length();
		int outWidth = (int) Math.ceil(lineWidth * skalierungsfaktor);
		int outHeight = (int) Math.ceil(lines.length * skalierungsfaktor);
		
		for(int i = 0; i < outHeight; i++) {
			for(int j = 0; j < outWidth; j++) {
				output.append( lines[i % lines.length].charAt(j % lines[i % lines.length].length()) );
			}
			output.append(LINE_FEED);
		}	
		return output.toString();
	}
	// returns the picture as String
	
	@Override
	public void scale(double factor) {
		this.skalierungsfaktor *= factor;
	}
	// 0.1 <= factor <= 10.0; resize the picture composition
}
