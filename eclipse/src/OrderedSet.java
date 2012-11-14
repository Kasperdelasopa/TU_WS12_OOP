
public class OrderedSet<P extends Shorter<P>> extends Set<P> {
	// instances are sorted containers, which use the Shorter.shorter()
	// method for comparison of elements.
	
	@Override
	public void insert(P element) {
		SetElement current = startElement;
		
		if(current == null) {
			startElement = new SetElement(element, null);
		} else {
			while(current.getValue().shorter(element) && current.getNext() != null) {
				current = current.getNext();
			}
			SetElement successor = current.getNext();
			current.setNext(new SetElement(element, successor));
		}
	}
	
}
