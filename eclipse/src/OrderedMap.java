import java.util.Iterator;

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
		// TODO return a MapIterator
		return null;
	}
	// @param element != null; 
	// returns the predecessor of the given element
	
}
