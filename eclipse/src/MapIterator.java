import java.util.Iterator;


public interface MapIterator<P ,Q> extends Iterator<P> {
	// implementing types enable access to a sequence of P-type elements,
	// adding elements to this sequence and getting an iterator for accessing
	// the Q-type sequence, that is referenced by a single P-type entry.
	
	public void add(P element);
	// Inserts the specified element into the list. The element is inserted 
	// immediately before the next element that would be returned by next, 
	// if any.
	
	public Iterator<Q> iterator();
	// returns an iterator for the sequence of Q-type elements, that are 
	// referenced by the current P-type element
}
