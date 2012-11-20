
public interface MapIterator<P ,Q> extends SetIterator<P> {
	// implementing types enable access to a sequence of P-type elements,
	// adding elements to this sequence and getting an iterator for accessing
	// the Q-type sequence, that is referenced by a single P-type entry.
	
	public SetIterator<Q> iterator();
	// returns an iterator for the sequence of Q-type elements, that are 
	// referenced by the current P-type element
}
