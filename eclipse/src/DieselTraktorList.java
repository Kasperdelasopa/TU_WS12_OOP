import java.util.Iterator;
import java.util.NoSuchElementException;

@Guarantor(person = "Peter Nirschl")
public class DieselTraktorList {
	// instances represent a double-linked list which holds elements of type
	// DieselTraktor.

	@Guarantor(person = "Peter Nirschl")
	protected class ListElement {
		// instances are used as element containers, that can be connected to a
		// predecessor and to a successor.
		
		public DieselTraktor value;
		// value != null
		
		public ListElement next;
		public ListElement prev;

		public ListElement(DieselTraktor value, ListElement prev, ListElement next) {
			this.next = next;
			this.value = value;
		}
		// initializes a new list element
		// @param value != null
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
	public void add(DieselTraktor traktor) {
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
	public Iterator<DieselTraktor> iterator() {
		return new Iterator<DieselTraktor>() {

			private ListElement current = start;

			@Override
			public boolean hasNext() {
				return (current != null);
			}
			// returns true if there is an element to return, otherwise false.

			@Override
			public DieselTraktor next() {
				if (current != null) {
					DieselTraktor traktor = current.value;
					current = current.next;
					return traktor;
				} else {
					throw new NoSuchElementException();
				}
			}
			// returns the next element within the list or throws a NoSuchElementException if there is no such element

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
				DieselTraktorList.this.count--;
			}
			// removes the element from the list, that would be returned by calling next()
			// if next() would not return an element a NoSuchElementException is thrown
		};
	}
	// returns an iterator allowing iteration over all list elements
	
}
