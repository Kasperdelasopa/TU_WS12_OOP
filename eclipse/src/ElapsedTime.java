
public abstract class ElapsedTime implements Shorter<ElapsedTime> {
// instances represent a measured time of a process
	
	protected int numberOfMeasurements=0; // numberOfMeasurements >= 0;
	protected double duration; // duration >= 0.0;
	
	public ElapsedTime(double duration){
		this.duration = duration;
		
	}
	// @param duration >= 0 && duration != null;
	// initializes and creates a new instance of ElapsedTime
	
	public abstract int count();
	// returns number of measurements
	
	public boolean shorter(ElapsedTime element){
		return this.duration<element.duration;
	}
	// @param element != null;
	// returns true if duration of the current instance is less than from element.
	
}
