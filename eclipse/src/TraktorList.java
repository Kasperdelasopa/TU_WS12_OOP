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
	// @param traktor: the concrete type must be either GasTraktor or DieselTraktor.
	//                 other possible subtypes of Traktor are not allowed!
	
	@Guarantor(person="Peter Nirschl")
	public TraktorList getDrillmaschinen() {
		TraktorList newList = new TraktorList();
		
		for(Traktor traktor : this) {
			if(traktor.getFunktion() != null) {
				if(traktor.getFunktion() instanceof Drillmaschine) {
					newList.add(traktor);
				}
			}
		}
		return newList;
	}
	// returns a new list containing only Traktor elements that are used as Drillmaschinen
	
	@Guarantor(person="Peter Nirschl")
	public TraktorList getDuengerstreuer() {
		TraktorList newList = new TraktorList();
		
		for(Traktor traktor : this) {
			if(traktor.getFunktion() != null) {
				if(traktor.getFunktion() instanceof Duengestreuer) {
					newList.add(traktor);
				}
			}
		}		
		return newList;
	}
	// returns a new list containing only Traktor elements that are used as Duengerstreuer
	
	@Guarantor(person="Peter Nirschl")
	public DieselTraktorList getDieselTraktoren() {
		DieselTraktorList dieselTraktorList = new DieselTraktorList();
		
		for(Traktor traktor : this) {
			if(traktor instanceof DieselTraktor) {
				dieselTraktorList.add((DieselTraktor)traktor);
			}
		}
		return dieselTraktorList;
	}
	// returns a new list containing only the DieselTraktor elements of the current instance
	
	@Guarantor(person="Peter Nirschl")
	public GasTraktorList getGasTraktoren() {
		GasTraktorList gasTraktorList = new GasTraktorList();
		
		for(Traktor traktor : this) {
			if(traktor instanceof GasTraktor) {
				gasTraktorList.add((GasTraktor)traktor);
			}
		}
		return gasTraktorList;
	}
	// returns a new list containing only the GasTraktor elements of the current instance
	
	@Guarantor(person="Peter Nirschl")
	public Iterator<Traktor> iterator() {
		return new Iterator<Traktor> () {
			
			private ListElement current = start;
			
			@Override
			public boolean hasNext() {
				return (current != null);
			}
			// returns true if there is an element to return, otherwise false.

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
			// returns the next element within the list or throws a NoSuchElementException if there is no such element (thank you, Mr. Obvious!)

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
			// removes the element from the list, that would be returned by calling next()
			// if next() would not return an element a NoSuchElementException is thrown
		};
	}
	// returns an iterator allowing iteration over all list elements
	
}
