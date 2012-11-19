
public class ElapsedTime implements Shorter<ElapsedTime> {

	protected int numberOfMeasurements=0;
	protected double duration;
	
	public ElapsedTime(double duration){
		this.duration = duration;
		
	}
	
	public int count(){
		return numberOfMeasurements;
	}
	
	public boolean shorter(ElapsedTime element){
		System.out.println("duration:"+ duration + " # elementduration: " + element.duration);
		return this.duration<element.duration;
	}
}
