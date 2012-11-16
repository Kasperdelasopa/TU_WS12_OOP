
public class OrderedSet<P extends Shorter<P>> extends Set<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements.
	
	@Override
	public void insert(P element) {
		SetElement current = startElement;
		
		if(current == null) {
			startElement = new SetElement(element, null);
		} else {
			while(current.value.shorter(element) && current.next != null) {
				current = current.next;
			}
			SetElement successor = current.next;
			current.next = new SetElement(element, successor);
		}
	}
	
}
