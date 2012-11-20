import java.util.Iterator;


public interface SetIterator<P> extends Iterator<P> {
	// implementing types enable access to a sequence of P-type elements by default
	// iterator behavior and allows adding elements to this sequence.
	
	public void add(P element);
	// Inserts the specified element into the list. The element is inserted 
	// immediately before the next element that would be returned by next, 
	// if any.
}
