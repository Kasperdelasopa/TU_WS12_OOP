
@Guarantor(person="Peter Nirschl")
public interface IBauernhofIterator extends IBaseIterator {
	// An iterator over a collection holding Bauernhof items.
	
	@Guarantor(person="Peter Nirschl")
	public Bauernhof next();
	// Returns the next element in the iteration.
}
