import java.util.Iterator;


public class OrderedMap<P extends Shorter<P>, Q> extends OrderedSet<P> {

	protected class MapElement extends SetElement {
		private Set<Q> set;
		
		public MapElement(P value, SetElement next) {
			super(value, next);
		}
		
		public Iterator<Q> getSetIterator() {
			return set.iterator();
		}
	}

	protected MapElement startElement;
	
	@Override
	public void insert(P element) {
		// TODO implement
	}
	
	@Override
	public Iterator<P> iterator() {
		// TODO return a MapIterator
		return null;
	}
	
}
