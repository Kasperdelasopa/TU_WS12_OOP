
public class MeanElapsedTime extends ElapsedTime {
// instances represent the average time of measurements
// measured times are saved into Set
	
	private Set<Double> measurements = new Set<Double>(); // measurements != null
	private double highest=0.0; // highest >= 0.0
	
	public MeanElapsedTime(double duration) {
		super(0.0);
		add(duration);
	}
	// @param duration >= 0.0 && duration != null
	// initializes and creates a new instance of MeanElapsedTime

	public void add(Double value){
		numberOfMeasurements++;
		measurements.insert(value);
		duration= (duration+=value)/count();
		if(value>highest) highest=value;
	}
	// @param value >= 0.0 && duration != null
	// adds a new measurement to Set and sets highest if value is the highest measurement
	
	public int count(){
		return numberOfMeasurements;
	}
	// returns number of measurements
	
	public double getHighestMeasurement(){
		return highest;
	}
	// returns highest measurement
}
