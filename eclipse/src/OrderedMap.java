import java.util.Iterator;
import java.util.NoSuchElementException;


public class OrderedMap<P extends Shorter<? super P>, Q> extends OrderedSet<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements. An instance of P can point
	// to several instances of Q. These elements are accessible through
	// the iterator.

	protected class MapElement extends SetElement {
		// instances represent single map elements, holding exactly one instance
		// of P, P's references of type Q and the following element within the
		// map.

		protected Set<Q> set;
		// set != null;

		protected MapElement next;
		protected MapElement previous;

		public MapElement(P value, SetElement previous, SetElement next) {
			super(value, previous, next);
			set = new Set<Q>();
		}
		// value != null;
		// sets up an internal map element

		public Iterator<Q> getSetIterator() {
			return set.iterator();
		}
		// returns an iterator to access the Q references of value P
	}

	@Override
	public void insert(P element) {
		MapElement sequenceElement = new MapElement(element, getPredecessor(element), getSuccessor(element));
		reconnectSequenceElement(sequenceElement);		
	}
	// @param element != null;
	// inserts the given element at its correct position

	@Override
	public MapIterator<P, Q> iterator() {
		return new MapIterator<P, Q>() {
			
			SetElement current = startElement;
						
			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public P next() {
				if (hasNext()) {
					P value = current.value;
					current = current.next;
					return value;
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				if (current == startElement) {
					startElement = startElement.next;
					current = startElement;
				} else {
					current.previous.next = current.next;
				}
			}

			@Override
			public void add(P element) {
				insert(element);
			}
			// Inserts the specified element into the list. The element is
			// inserted immediately before the next element that would be
			// returned by next, if any.

			@SuppressWarnings("unchecked")
			@Override
			public Iterator<Q> iterator() {
				if(current != null) {
					if(current instanceof OrderedMap.MapElement) {
						return ((MapElement)current).set.iterator();
					}
				} 
				return null;
			}
			// returns an iterator for the sequence of Q-type elements, that are
			// referenced by the current P-type element or null if there are no
			// such elements.
		};
	}
	// returns an iterator for the sequence
}
