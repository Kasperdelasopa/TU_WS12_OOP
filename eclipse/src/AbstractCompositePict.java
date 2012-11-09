
public abstract class AbstractCompositePict<P> implements Pict {
	// instances represent compositions of 2-dimensional pictures
	// consists of objects of type P that have a string representation
	
	protected P[][] inhalt;
	// inhalt != null; objects that form the picture composition
	
	@Override
	public abstract String toString();
	// returns the picture as String
	
	public abstract void scale(double factor);
	// 0.1 <= factor <= 10.0; resize the picture composition
}
