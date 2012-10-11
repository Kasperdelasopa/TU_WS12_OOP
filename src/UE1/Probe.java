package UE1;

import java.util.Date;

public class Probe extends Ereignis{
	
	private double raummiete;
	
	public Probe(double miete, String ort, Date datum_zeit, double dauer ){
		
		super(ort, datum_zeit, dauer);
		this.setRaummiete(miete);
		
	}
	
	public double getRaummiete() {
		return raummiete;
	}

	public void setRaummiete(double raummiete) {
		this.raummiete = raummiete;
	}
	
	public String toString(){
		
		return "Probe: " + super.toString() + "/ Raummiete: " + String.format("%.2f", getRaummiete()); 
				
	}
}
