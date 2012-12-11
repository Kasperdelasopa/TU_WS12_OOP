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
	public IDieselTraktorIterator iterator() {
		return new IDieselTraktorIterator() {

			private ListElement current = start;
			private ListElement previous = null;

			@Override
			public boolean hasNext() {
				return (current != null);
			}
			// Returns true if the iteration has more elements.

			@Override
			public DieselTraktor next() {
				if (current != null) {
					DieselTraktor traktor = current.value;
					previous = current;
					current = current.next;
					return traktor;
				} else {
					throw new NoSuchElementException();
				}
			}
			// Returns the next element in the iteration.

			@Override
			public void remove() {	
				if(previous == null) {
					throw new NoSuchElementException();
				}
				
				if(previous.prev != null) {
					previous.prev.next = previous.next;
				} else {
					DieselTraktorList.this.start = previous.next;
				}
				
				if(previous.next != null) {
					previous.next.prev = previous.prev;
				} else {
					DieselTraktorList.this.end = previous.prev;
				}
				
				previous = null;
				DieselTraktorList.this.count--;
			}
			// Removes from the underlying collection the last element returned by the iterator
			// if next() would not return an element a NoSuchElementException is thrown
		};
	}
	// returns an iterator allowing iteration over all list elements
	
}
