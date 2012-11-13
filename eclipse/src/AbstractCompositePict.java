
public abstract class AbstractCompositePict<P> implements Pict {
	// instances represent compositions of 2-dimensional pictures
	// consists of objects of type P that have a string representation
	
	protected final static String LINE_FEED = System.getProperty("line.separator");
	// constant holding the line feed for performance reasons
	
	protected P[][] inhalt;
	// inhalt != null; objects that form the picture composition
	
	public AbstractCompositePict(P[][] inhalt) {
		this.inhalt = inhalt;
	}
	// inhalt != null; 
	// initializes the content array
	
	@Override
	public String toString() {
		
		return null;
	}
	// returns the picture as String
	
	public abstract void scale(double factor);
	// 0.1 <= factor <= 10.0; resize the picture composition
}
