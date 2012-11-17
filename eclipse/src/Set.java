import java.util.Iterator;

public class Set<P> implements Iterable<P> {
	// instances represent a sequence of elements of type P.

	protected class SetElement {
		// instances represent single set elements, holding exactly one instance
		// of P and the following element within the map.
		
		protected P value;
		// value != null;
		
		protected SetElement next;
		
		public SetElement(P value, SetElement next) {
			this.value = value;
			this.next = next;
		}
		// @param value != null; 
		// sets up an internal set element
	}
	
	protected SetElement startElement = null;
	
	public void insert(P element) {
		SetElement insertPosition = getInsertPosition();
		
		if(insertPosition == null) {
			startElement = new SetElement(element, null);
		} else {
			SetElement successor = insertPosition.next;
			insertPosition.next = new SetElement(element, successor);
		}
	}
	// @param element != null;
	// inserts the given element at the end of the sequence.
	
	protected SetElement getInsertPosition() {
		SetElement current = startElement;

		if (current != null) {
			while (current.next != null) {
				current = current.next;
			}
		}
		return current;
	}
	// @param element != null; 
	// returns the predecessor of the given element
		
	@Override
	public Iterator<P> iterator() {
				
		SetIterator<P> sit = new SetIterator<P>(startElement);

		return sit;
	}
	// TODO Constraints and description
}
