package UE1;

import java.util.Date;

public class Auftritt extends Ereignis {

	private double gage;
	private Besetzung zusammensetzung;
	


	public Auftritt(double gage, String ort, Date datum_zeit, double dauer, Besetzung zusammensetzung){
		
		super(ort, datum_zeit, dauer);
		this.setGage(gage);
		this.zusammensetzung = zusammensetzung;
		
	}
	
	public double getGage() {
		return gage;
	}

	public void setGage(double gage) {
		this.gage = gage;
	}
	
	@Override
	public String toString(){
		
		return "Auftritt " + super.toString() + "/ Gage: " + String.format("%.2f", getGage() ); 
				
	}
	
	public Besetzung getZusammensetzung() {
		return zusammensetzung;
	}
	
}
