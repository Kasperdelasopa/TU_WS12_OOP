import java.util.Iterator;
import java.util.NoSuchElementException;


@Guarantor(person="Peter Nirschl")
public class TraktorList implements Iterable<Traktor> {
	// instances represent a double-linked list which holds elements of type
	// Traktor. The list allows filtering for Traktor type and function type.

	@Guarantor(person="Peter Nirschl")
	protected class ListElement  {
		// instances are used as element containers, that can be connected to a
		// predecessor and to a successor.
		
		public Traktor value;
		// value != null
		
		public ListElement next;
		public ListElement prev;
				
		public ListElement(Traktor value, ListElement prev, ListElement next) {
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
	
	@Guarantor(person="Peter Nirschl")
	public void add(Traktor traktor) {
		ListElement insertElement = new ListElement(traktor, null, null);
		
		if(end == null) {
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
	
	@Guarantor(person="Peter Nirschl")
	public TraktorList getDrillmaschinen() {
		return null;
	}
	
	@Guarantor(person="Peter Nirschl")
	public TraktorList getDuengerstreuer() {
		return null;
	}
	
	@Guarantor(person="Peter Nirschl")
	public DieselTraktorList getDieselTraktoren() {
		return null;
	}
	
	@Guarantor(person="Peter Nirschl")
	public GasTraktorList getGasTraktoren() {
		return null;
	}
	
	@Guarantor(person="Peter Nirschl")
	public Iterator<Traktor> iterator() {
		return new Iterator<Traktor> () {
			
			private ListElement current = start;
			
			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public Traktor next() {
				if(current != null) {
					Traktor traktor = current.value;
					current = current.next;
					return traktor;
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				if(current == null) {
					throw new NoSuchElementException();
				}
				
				ListElement nextElement = current.next;
				
				if(current.prev != null) {
					current.prev.next = current.next;
				}
				if(current.next != null) {
					current.next.prev = current.prev;
				}
				current = nextElement;
				TraktorList.this.count--;
			}
		};
	}
	// returns an iterator allowing iteration over all list elements
	
}
