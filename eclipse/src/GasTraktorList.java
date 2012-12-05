import java.util.Iterator;
import java.util.NoSuchElementException;

@Guarantor(person = "Peter Nirschl")
public class GasTraktorList {
	// instances represent a double-linked list which holds elements of type
	// Traktor. The list allows filtering for Traktor type and function type.

	@Guarantor(person = "Peter Nirschl")
	protected class ListElement {
		public GasTraktor value;
		public ListElement next;
		public ListElement prev;

		public ListElement(GasTraktor value, ListElement prev, ListElement next) {
			this.next = next;
			this.value = value;
		}
	}

	private ListElement start = null;
	private ListElement end = null;
	private int count = 0;
	// count >= 0

	public int size() {
		return count;
	}
	// returns the number of elements within the list.
	// returned value >= 0

	@Guarantor(person = "Peter Nirschl")
	public void add(GasTraktor traktor) {
		ListElement insertElement = new ListElement(traktor, null, null);

		if (end == null) {
			start = insertElement;
			end = insertElement;
		} else {
			insertElement.prev = end;
			end.next = insertElement;
			end = end.next;
		}
		count++;
	}
	// adds an element to the end of the list
	// @param traktor != null

	@Guarantor(person = "Peter Nirschl")
	public Iterator<GasTraktor> iterator() {
		return new Iterator<GasTraktor>() {

			private ListElement current = start;

			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public GasTraktor next() {
				if (current != null) {
					GasTraktor traktor = current.value;
					current = current.next;
					return traktor;
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				if (current == null) {
					throw new NoSuchElementException();
				}

				ListElement nextElement = current.next;

				if (current.prev != null) {
					current.prev.next = current.next;
				}
				if (current.next != null) {
					current.next.prev = current.prev;
				}
				current = nextElement;
				GasTraktorList.this.count--;
			}
		};
	}
	// returns an iterator allowing iteration over all list elements
}
