import java.util.Iterator;


public class Set<P> implements Iterable<P> {

	protected class SetElement {
		protected P value;
		protected SetElement next;
		
		public SetElement() {
			value = null; 
			next = null;
		}

		public SetElement(P value, SetElement next) {
			this.value = value;
			this.next = next;
		}
		
		// TODO Bitte Zusicherungen hinzufuegen!
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
