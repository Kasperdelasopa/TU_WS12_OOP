package UE1;

import java.util.Date;

public class Probe extends Ereignis{
	
	private double raummiete;
	private Besetzung zusammensetzung;
	
	public Probe(double miete, String ort, Date datum_zeit, double dauer, Besetzung zusammensetzung ){
		
		super(ort, datum_zeit, dauer);
		this.setRaummiete(miete);
		this.zusammensetzung  = zusammensetzung;
		
	}
	
	public double getRaummiete() {
		return raummiete;
	}

	public void setRaummiete(double raummiete) {
		this.raummiete = raummiete;
	}
	
	@Override
	public String toString(){
		
		return "Probe: " + super.toString() + "/ Raummiete: " + String.format("%.2f", getRaummiete()); 
				
	}
	
	public Besetzung getZusammensetzung() {
		return zusammensetzung;
	}
}
