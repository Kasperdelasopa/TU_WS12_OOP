package UE1;

import java.util.Date;

public class Probe extends Ereignis{
	
    
        // raummiete >= 0
	private double raummiete;
	private Besetzung zusammensetzung;
	
        // Initialisiert Probe
        // @param miete >= 0
        // @param zusammensetzung darf nicht leer sein
	public Probe(double miete, Ort ort, Date datum_zeit, double dauer, Besetzung zusammensetzung ){
		
		super(ort, datum_zeit, dauer);
		this.setRaummiete(miete);
		this.zusammensetzung  = zusammensetzung;
		
	}
	
        // Gibt raummiete zurueck
	public double getRaummiete() {
		return raummiete;
	}

        // Setzt raummiete
        // @param raummiete >=0
	public void setRaummiete(double raummiete) {
		this.raummiete = raummiete;
	}
	
        // Gibt toString() der Oberklasse und raummiete im Stringformat zurueck
	@Override
	public String toString(){
		
		return "Probe: " + super.toString() + "/ Raummiete: " + String.format("%.2f", getRaummiete()); 
				
	}
	
        //Gibt zusammensetzung zurueck
	public Besetzung getZusammensetzung() {
		return zusammensetzung;
	}
}
