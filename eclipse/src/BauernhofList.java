import java.util.Iterator;
import java.util.NoSuchElementException;

@Guarantor(person="Peter Nirschl")
public class BauernhofList implements Iterable<Bauernhof> {
	// instances represent a double-linked list which holds elements of type
	// Bauernhof.
	
	@Guarantor(person="Peter Nirschl")
	protected class ListElement  {
		public Bauernhof value;
		public ListElement next;
		public ListElement prev;
				
		public ListElement(Bauernhof value, ListElement prev, ListElement next) {
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
	
	@Guarantor(person="Peter Nirschl")
	public void add(Bauernhof traktor) {
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
		
	@Guarantor(person="Peter Nirschl")
	public Iterator<Bauernhof> iterator() {
		return new Iterator<Bauernhof> () {
			
			private ListElement current = start;
			
			@Override
			public boolean hasNext() {
				return (current != null);
			}

			@Override
			public Bauernhof next() {
				if(current != null) {
					Bauernhof bauernhof = current.value;
					current = current.next;
					return bauernhof;
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
				BauernhofList.this.count--;
			}
		};
	}
	
}
