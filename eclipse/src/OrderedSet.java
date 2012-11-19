public class OrderedSet<P extends Shorter<P>> extends Set<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements.

	@Override
	public void insert(P element) {
		SetElement sequenceElement = new SetElement(element, getPredecessor(element), getSuccessor(element));
		reconnectSequenceElement(sequenceElement);		
	}
	// @param element != null;
	// inserts the given element at its correct position

	protected SetElement getPredecessor(P element) {
		SetElement current = startElement;
		SetElement prev = null;
		
		while(current != null) {
			if(current.value.shorter(element)) {
				prev = current;
				current = current.next;
			} else {
				break;
			}
		}
		return prev;
	}
	// @param element != null;
	// returns the preceding element inside the sequence.
	
	protected SetElement getSuccessor(P element) {
		SetElement current = startElement;
		
		while(current != null) {
			if(current.value.shorter(element)) {
				current = current.next;
			} else {
				break;
			}
		}
		return current;
	}
	// @param element != null;
	// returns the succeeding element inside the sequence.
	
	protected void reconnectSequenceElement(SetElement element) {
		if(element.previous == null) {
			startElement = element;
		} else {
			element.previous.next = element;
		}
		
		if(element.next != null) {
			element.next.previous = element;
		}
	}
	// @param element != null;
	// integrates the element into the sequence by updating the successor and
	// predecessor, if any.
}
