import java.util.NoSuchElementException;

public class OrderedMap<P extends Shorter<? super P>, Q> extends OrderedSet<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements. An instance of P can point
	// to several instances of Q. These elements are accessible through
	// the iterator.

	protected class MapElement {
		// instances represent single map elements, holding exactly one instance
		// of P, P's references of type Q and the following element within the
		// map.

		protected P value;
		// value != null;
		
		protected Set<Q> set;
		// set != null;

		protected MapElement next;
		protected MapElement previous;

		public MapElement(P value, MapElement previous, MapElement next) {
			this.next = next;
			this.previous = previous;
			this.value = value;
			set = new Set<Q>();
		}
		// value != null;
		// sets up an internal map element
	}
	
	protected MapElement mapStartElement;

	@Override
	public void insert(P element) {
		MapElement sequenceElement = new MapElement(element, getPredecessor(element), getSuccessor(element));
		reconnectSequenceElement(sequenceElement);
	}
	// @param element != null;
	// inserts the given element at its correct position
	
	private MapElement getPredecessor(P element) {
		MapElement current = mapStartElement;
		MapElement prev = null;
		
		while(current != null) {
			if(current.value.shorter(element)) {
				prev = current;
				current = current.next;
			} else {
				break;
			}
		}
		return prev;
	}
	// @param element != null;
	// returns the preceding element inside the sequence.
	
	private MapElement getSuccessor(P element) {
		MapElement current = mapStartElement;
		
		while(current != null) {
			if(current.value.shorter(element)) {
				current = current.next;
			} else {
				break;
			}
		}
		return current;
	}
	// @param element != null;
	// returns the succeeding element inside the sequence.
	
	private void reconnectSequenceElement(MapElement element) {
		if(element.previous == null) {
			mapStartElement = element;
		} else {
			element.previous.next = element;
		}
		
		if(element.next != null) {
			element.next.previous = element;
		}
	}
	// @param element != null;
	// integrates the element into the sequence by updating the successor and
	// predecessor, if any.

	@Override
	public MapIterator<P, Q> iterator() {
		return new MapIterator<P, Q>() {
			
			private MapElement current = mapStartElement;
			private boolean started = false;		
			
			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public P next() {
				if (hasNext()) {
					started = true;
					P value = current.value;
					current = current.next;
					return value;
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				if (current == mapStartElement) {
					mapStartElement = mapStartElement.next;
					current = mapStartElement;
				} else {
					current.previous.next = current.next;
				}
			}

			@Override
			public void add(P element) {
				insert(element);
				if(!started && current == null) {
					current = mapStartElement;
				}
			}
			// Inserts the specified element into the list. The element is
			// inserted immediately before the next element that would be
			// returned by next, if any.

			@Override
			public SetIterator<Q> iterator() {
				if(current != null) {
					return current.set.iterator();
				} else {
					return null;
				}
			}
			// returns an iterator for the sequence of Q-type elements, that are
			// referenced by the current P-type element or null if there are no
			// such elements.
		};
	}
	// returns an iterator for the sequence
}
