public class OrderedSet<P extends Shorter<P>> extends Set<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements.

	@Override
	public void insert(P element) {
		SetElement insertPosition = getInsertPosition(element);
		if (insertPosition == null) {
			startElement = new SetElement(element, null, null);
		} else {
			SetElement successor = insertPosition.next;
			insertPosition.next = new SetElement(element, insertPosition, successor);
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
	// returns the predecessor of the given element
}
