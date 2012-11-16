public class OrderedSet<P extends Shorter<P>> extends Set<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements.

	@Override
	public void insert(P element) {
		SetElement insertPosition = getInsertPosition(element);
		if (insertPosition == null) {
			startElement = new SetElement(element, null);
		} else {
			SetElement successor = insertPosition.next;
			insertPosition.next = new SetElement(element, successor);
		}
	}

	@Override
	protected SetElement getInsertPosition(P element) {
		SetElement current = startElement;

		if (current != null) {
			startElement = new SetElement(element, null);
		} else {
			while (current.value.shorter(element) && current.next != null) {
				current = current.next;
			}
		}
		return current;
	}

}
