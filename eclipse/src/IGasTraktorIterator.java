
@Guarantor(person="Peter Nirschl")
public interface IGasTraktorIterator extends IBaseIterator {
	// An iterator over a collection holding GasTraktor items.
	
	@Guarantor(person="Peter Nirschl")
	public GasTraktor next();
	// Returns the next element in the iteration.
}
