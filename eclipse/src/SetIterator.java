import java.util.Iterator;
import java.util.NoSuchElementException;

public class SetIterator<P> implements Iterator<P> {

	protected Set<P>.SetElement element;
	protected Set<P>.SetElement old;
	
	public SetIterator(Set<P>.SetElement e){
		element = e;
	}
	
	@Override
	public boolean hasNext() {				 
		return (element.next != null);
	}
	//return false when there is no next element, else true

	@Override
	public P next() {
		if(hasNext()){
			old = element;
			element = element.next;
			return element.value;
		}
		else
			throw new NoSuchElementException();
	}
	//returns the next element

	@Override
	public void remove() {
		if(old != null){
			old.next = element.next;
			element = null;
		}
	}
	//deletes current element
	
}
