import java.util.Iterator;


public class Set<P> implements Iterable<P> {

	protected class SetElement {
		P value;
		SetElement next;
		
		public SetElement(P value, SetElement next) {
			this.value = value;
			this.next = next;
		}
		
		// TODO Bitte Zusicherungen hinzufuegen!
		
		public P getValue() { return value; }
		public void setValue(P value) { this.value = value; }
		public SetElement getNext() { return next; }
		public void setNext(SetElement element) { next = element; }
	}
	
	protected SetElement startElement;
	
	public void insert(P element) {
		// TODO implement
	}
	
	@Override
	public Iterator<P> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
