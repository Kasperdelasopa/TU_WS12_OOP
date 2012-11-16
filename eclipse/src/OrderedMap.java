import java.util.Iterator;

public class OrderedMap<P extends Shorter<P>, Q> extends OrderedSet<P> {

	protected class MapElement extends SetElement {
		protected Set<Q> set;
		protected MapElement next;
		
		public MapElement(P value, SetElement next) {
			super(value, next);
		}
		
		public Iterator<Q> getSetIterator() {
			return set.iterator();
		}
		
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
	
	@Override
	public Iterator<P> iterator() {
		// TODO return a MapIterator
		return null;
	}
	
}
