
public class CompositeTime extends ElapsedTime {

	private Double times[];
	private double minimum;
	
	public CompositeTime(Double[] array) {
		super(array[0]);
		minimum=duration;
		times = array;
		for(int i=1; i<count();i++){
				duration+=times[i];
				if(times[i]<minimum) minimum=times[i];
			}
		
	}
	
	public void add(Double value){
		Double totemp[] = new Double[count()+1];
		System.arraycopy(times, 0, totemp, 0, count());
		times = totemp;
		times[count()-1]=value;
		if(value<minimum) minimum=value;
	}

	public double getMinimumTime(){
		return minimum;
	}
	
	public int count(){
		return times.length;
	}


}
