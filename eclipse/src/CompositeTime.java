
public class CompositeTime extends ElapsedTime {
// instances represent the total time of measurements
// measured times are saved into an array
	
	private Double times[]; // array != null && for every x in 0 <= x  < array.length : array[x] >= 0 && array != {};
	private double minimum; // minimum >= 0.0;
	
	public CompositeTime(Double[] array) {
		super(array[0]);
		minimum=duration;
		times = array;
		for(int i=1; i<count();i++){
			duration+=times[i];
			if(times[i]<minimum) minimum=times[i];
		}
	}	
	// @param array != null && for every x in 0 <= x  < array.length : array[x] >= 0 && array != {};
	// initializes and creates a new instance of CompositeTime	

	public double getMinimumTime(){
		return minimum;
	}
	// returns lowest measurement;
	
	public int count(){
		return times.length;
	}
	// returns number of measurements

}
