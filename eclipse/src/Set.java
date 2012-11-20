import java.util.NoSuchElementException;

public class Set<P> implements Iterable<P> {
	// instances represent a sequence of elements of type P.

	protected class SetElement {
		// instances represent single set elements, holding exactly one instance
		// of P and the following element within the map.

		protected P value;
		// value != null;

		protected SetElement next;
		protected SetElement previous;

		public SetElement(P value, SetElement previous, SetElement next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
		// @param value != null;
		// sets up an internal set element
	}

	protected SetElement startElement = null;

	public void insert(P element) {
		SetElement current = startElement;

		if (current == null) {
			startElement = new SetElement(element, null, null);
		} else {
			while(current.next != null) {
				current = current.next;
			}
			current.next = new SetElement(element, current, null);
		}
	}
	// @param element != null;
	// inserts the given element at the end of the sequence.

	@Override
	public SetIterator<P> iterator() {
		return new SetIterator<P>() {
			
			SetElement current = startElement;
			SetElement oldStart = startElement;

			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public P next() {
				if (hasNext()) {
					SetElement element = current;
					current = current.next;
					return element.value;
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				if(current == startElement) {
					startElement = startElement.next;
					current = startElement;
				} else {
					current.previous.next = current.next;
				}
			}

			@Override
			public void add(P element) {
				insert(element);
				if(current == oldStart) {
					current = startElement;
				}
			}
		};
	}
	// returns an iterator for the sequence
}
