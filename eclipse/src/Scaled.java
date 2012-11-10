public class Scaled<P extends Pict> extends AbstractCompositePict<P> {
	// instances represent pict compositions, that are scaled with
	// their own scale-implementation.
	
	private final static String LINE_FEED = System.getProperty("line.separator");
	// constant holding the line feed for performance reasons
	
	public Scaled(P[][] inhalt) {
		this.inhalt = inhalt;
	}
	// inhalt != null; 
	// creates a new instance of Scaled and initializes the content array

	@Override
	public String toString() {
		StringBuilder stringRep = new StringBuilder();
				
		for(P[] row : inhalt) {
			for(P column : row) {
				stringRep.append(column.toString());
			}
			stringRep.append(LINE_FEED);
		}
		return stringRep.toString();
	}

	@Override
	public void scale(double factor) {
		for (P[] row : inhalt) {
			for (P column : row) {
				column.scale(factor);
			}
		}
	}

}
