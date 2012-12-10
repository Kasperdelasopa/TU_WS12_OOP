
@Guarantor(person="Peter Nirschl")
public abstract interface IBaseIterator {
	// An abstract iterator over a collection. IBaseIterator takes the place of Enumeration in
	// lists.
	
	@Guarantor(person="Peter Nirschl")
	public boolean hasNext();
	// Returns true if the iteration has more elements.
	
	@Guarantor(person="Peter Nirschl")
	public void remove();
	// Removes from the underlying collection the last element returned by the iterator
}
