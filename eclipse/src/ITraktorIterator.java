
@Guarantor(person="Peter Nirschl")
public interface ITraktorIterator extends IBaseIterator {
	// An iterator over a collection holding Traktor items.
	
	@Guarantor(person="Peter Nirschl")
	public Traktor next();
	// Returns the next element in the iteration.
}
