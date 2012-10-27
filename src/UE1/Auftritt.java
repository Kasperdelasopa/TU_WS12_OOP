package UE1;

import java.util.Date;

public class Auftritt extends Ereignis {

        // gage >= 0
	private double gage;
	private Besetzung zusammensetzung;
	

        // Initialisiert Auftritt
        // @param gage > 0
        // @zusammensetzung darf nicht leer sein
	public Auftritt(double gage, Ort ort, Date datum_zeit, double dauer, Besetzung zusammensetzung){
		
		super(ort, datum_zeit, dauer);
		this.setGage(gage);
		this.zusammensetzung = zusammensetzung;
		
	}
	
        // Gibt die Gage zurueck
	public double getGage() {
		return gage;
	}
        
        // Setzt die Gage
        // @param gage >= 0
	public void setGage(double gage) {
		this.gage = gage;
	}
	
        // Gibt toString() der Oberklasse und gage im Stringformat zurueck
	@Override
	public String toString(){
		
		return "Auftritt " + super.toString() + "/ Gage: " + String.format("%.2f", getGage() ); 
				
	}
	
        // Gibt zusammensetzung zurueck
	public Besetzung getZusammensetzung() {
		return zusammensetzung;
	}
	
}
