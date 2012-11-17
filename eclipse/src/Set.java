import java.util.Iterator;
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
		SetElement insertPosition = getInsertPosition();

		if (insertPosition == null) {
			startElement = new SetElement(element, null, null);
		} else {
			SetElement successor = insertPosition.next;
			insertPosition.next = new SetElement(element, insertPosition, successor);
		}
	}

	// @param element != null;
	// inserts the given element at the end of the sequence.

	protected SetElement getInsertPosition() {
		SetElement current = startElement;

		if (current != null) {
			while (current.next != null) {
				current = current.next;
			}
		}
		return current;
	}

	// @param element != null;
	// returns the predecessor of the given element

	@Override
	public Iterator<P> iterator() {
		return new Iterator<P>() {
			
			SetElement current = startElement;

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
		};
	}
	// returns an iterator for the sequence
}
