public class OrderedSet<P extends Shorter<P>> extends Set<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements.

	@Override
	public void insert(P element) {
		SetElement insertPosition = getInsertPosition(element);
		if (insertPosition == null) {
			startElement = new SetElement(element, null, null);
		} else {
			if(insertPosition == startElement) {
				startElement.previous = new SetElement(element, null, insertPosition); 
				startElement = startElement.previous; 
			} else {
				SetElement insertElement =  new SetElement(element, insertPosition.previous, insertPosition);
				insertPosition.previous.next = insertElement;
				insertPosition.previous = insertElement;
			}
		}
	}
	// @param element != null;
	// inserts the given element at its correct position

	protected SetElement getInsertPosition(P element) {
		SetElement current = startElement;

		if (current != null) {
			while (current.value.shorter(element) && current.next != null) {
				current = current.next;
			}
		}
		return current;
	}
	// @param element != null;
	// returns the successor of the given element
}
