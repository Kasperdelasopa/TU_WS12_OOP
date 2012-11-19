
public class MeanElapsedTime extends ElapsedTime {

	private Set<Double> measurements = new Set<Double>();
	private double highest=0.0;
	
	public MeanElapsedTime(double duration) {
		super(0.0);
		add(duration);
	}

	public void add(Double value){
		numberOfMeasurements++;
		measurements.insert(value);
		duration= (duration+=value)/count();
		if(value>highest) highest=value;
	}
	
	public double getmean(){
		return duration;
	}
	public double getHighestMeasurement(){
		return highest;
	}
	
}
