import java.util.Iterator;
import java.util.NoSuchElementException;

@Guarantor(person="Peter Nirschl")
public class BauernhofList implements Iterable<Bauernhof> {
	// instances represent a double-linked list which holds elements of type
	// Bauernhof.
	
	@Guarantor(person="Peter Nirschl")
	protected class ListElement  {
		// instances are used as element containers, that can be connected to a
		// predecessor and to a successor.
		
		public Bauernhof value;
		// value != null
		
		public ListElement next;
		public ListElement prev;
				
		public ListElement(Bauernhof value, ListElement prev, ListElement next) {
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
	public void add(Bauernhof bauernhof) {
		ListElement insertElement = new ListElement(bauernhof, null, null);
		
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
	// @param bauernhof != null
		
	@Guarantor(person="Peter Nirschl")
	public Iterator<Bauernhof> iterator() {
		return new Iterator<Bauernhof> () {
			
			private ListElement current = start;
			private ListElement previous = null;
			
			@Override
			public boolean hasNext() {
				return (current != null);
			}
			// returns true if there is an element to return, otherwise false.

			@Override
			public Bauernhof next() {
				if(current != null) {
					Bauernhof bauernhof = current.value;
					previous = current;
					current = current.next;
					return bauernhof;
				} else {
					throw new NoSuchElementException();
				}
			}
			// returns the next element within the list or throws a NoSuchElementException if there is no such element

			@Override
			public void remove() {
				if(previous == null) {
					throw new NoSuchElementException();
				}
				
				if(previous.prev != null) {
					previous.prev.next = previous.next;
				}
				if(previous.next != null) {
					previous.next.prev = previous.prev;
				}
				previous = null;
				BauernhofList.this.count--;
			}
			// removes the element from the list, that would be returned by calling next()
			// if next() would not return an element a NoSuchElementException is thrown
		};
	}
	// returns an iterator allowing iteration over all list elements

}
