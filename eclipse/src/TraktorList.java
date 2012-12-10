import java.util.NoSuchElementException;

@Guarantor(person="Peter Nirschl")
public class TraktorList {
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
		
		ITraktorIterator iterator = iterator();
		while(iterator.hasNext()) {
			Traktor traktor = iterator.next();
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
		
		ITraktorIterator iterator = iterator();
		while(iterator.hasNext()) {
			Traktor traktor = iterator.next();
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
		
		ITraktorIterator iterator = iterator();
		while(iterator.hasNext()) {
			Traktor traktor = iterator.next();
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
		
		ITraktorIterator iterator = iterator();
		while(iterator.hasNext()) {
			Traktor traktor = iterator.next();
			if(traktor instanceof GasTraktor) {
				gasTraktorList.add((GasTraktor)traktor);
			}
		}
		return gasTraktorList;
	}
	// returns a new list containing only the GasTraktor elements of the current instance
	
	@Guarantor(person="Peter Nirschl")
	public ITraktorIterator iterator() {
		return new ITraktorIterator () {
			
			private ListElement current = start;
			private ListElement previous = null;
			
			@Override
			public boolean hasNext() {
				return (current != null);
			}
			// Returns true if the iteration has more elements.
			
			@Override
			public Traktor next() {
				if(current != null) {
					Traktor traktor = current.value;
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
				}
				if(previous.next != null) {
					previous.next.prev = previous.prev;
				}
				previous = null;
				TraktorList.this.count--;
			}
			// Removes from the underlying collection the last element returned by the iterator
			// if next() would not return an element a NoSuchElementException is thrown
		};
	}
	// returns an iterator allowing iteration over all list elements
	
}
