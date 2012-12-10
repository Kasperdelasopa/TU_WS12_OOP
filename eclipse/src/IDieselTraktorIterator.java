
@Guarantor(person="Peter Nirschl")
public interface IDieselTraktorIterator extends IBaseIterator {
	// An iterator over a collection holding DieselTraktor items.
	
	@Guarantor(person="Peter Nirschl")
	public DieselTraktor next();
	// Returns the next element in the iteration.
}
