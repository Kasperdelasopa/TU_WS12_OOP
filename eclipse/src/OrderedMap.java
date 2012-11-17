import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedMap<P extends Shorter<P>, Q> extends OrderedSet<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements. An instance of P can point
	// to several instances of Q. These elements are accessible through 
	// the iterator.
	
	protected class MapElement extends SetElement {
		// instances represent single map elements, holding exactly one instance
		// of P, P's references of type Q and the following element within the map.
		
		protected Set<Q> set;
		// set != null; 
		
		protected MapElement next;
		
		public MapElement(P value, SetElement next) {
			super(value, next);
			set = new Set<Q> ();
		}
		// value != null; 
		// sets up an internal map element
		
		public Iterator<Q> getSetIterator() {
			return set.iterator();
		}
		// returns an iterator to access the Q references of value P
	}

	protected MapElement startElement = null;
	
	@Override
	public void insert(P element) {
		SetElement insertPosition = getInsertPosition(element);
		if (insertPosition == null) {
			startElement = new MapElement(element, null);
		} else {
			SetElement successor = insertPosition.next;
			insertPosition.next = new MapElement(element, successor);
		}
	}
	// @param element != null; 
	// inserts the given element at its correct position
	
	@Override
	public Iterator<P> iterator() {
		
		MapIterator<P,Q> mit = new MapIterator<P,Q>(startElement){
			
			MapElement element = startElement;
			MapElement old;
			
			@Override
			public boolean hasNext() {				 
				return (element.next != null);
			}
			//return false when there is no next element, else true

			@Override
			public P next() {
				if(hasNext()){
					old = element;
					element = element.next;
					return element.value;
				}
				else
					throw new NoSuchElementException();
			}
			//returns the next element

			@Override
			public void remove() {
				if(old != null){
					old.next = element.next;
					element = null;
				}
			}
			//deletes current element			
			public Iterator<Q> iterator(){
				return element.set.iterator();
			}
		};
		return mit;
	}
	//returns an Iterator for
}
