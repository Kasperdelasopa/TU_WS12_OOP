
public interface Shorter<P> {
	// implementing subtypes are somehow comparable by their length/shortness.
	// P must be the type of the implementing subtype.
	
	public boolean shorter(P element);
	// @param element != null;
	// returns true if element is shorter than the current instance.
}
