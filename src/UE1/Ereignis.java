package UE1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ereignis {
	
	private Ort ort;
	private Date datum_zeit;
        
        // dauer > 0
	private double dauer; 
        private boolean bestaetigt;
        
        // index darf nur einmal um 1 erhoeht werden
	private static int index=0;
        
        // id darf nach erster Wertzuweisung nicht mehr geändert werden
        private int id;
        
        
        // Initialisiert Ereignis
        // @param dauer > 0
	public Ereignis(Ort ort, Date datum_zeit, double dauer){		
            this.setOrt(ort);
            this.setDauer(dauer);
            this.setDatum_zeit(datum_zeit);
            // FEHLER: false kann für einige Ereignisse in der Zukunft nicht gesetzt werden, wenn das Ereignis noch in der Zukunft liegt. Da aber der default-wert false ist hat es keine Auswirkungen
            this.setBestaetigt(false);
            this.id = getNextId();
	}
        
        
        // Gibt die ID vom Ereignis zurueck
        public int getId() {
            return id;
        }
        
        // Erhoeht index um 1 und gibt ihn zurueck
        private static int getNextId() {
            return index++;
        }
        
        // Gibt den Ort zurueck
	public Ort getOrt() {
            return ort;
	}

        // Setzt den Ort
	public void setOrt(Ort ort) {
            this.ort = ort;
	}
        
	// Gibt die Dauer zurueck
	public double getDauer() {
            return dauer;
	}

	// Setzt die Dauer
        // @param dauer > 0
	public void setDauer(double dauer) {
            this.dauer = dauer;
	}

        // Gibt das Datum+Zeit zurueck
	public Date getDatum_zeit() {
            return datum_zeit;
	}

        // Setzt das Datum und die Zeit
	public void setDatum_zeit(Date datum_zeit) {
            this.datum_zeit = datum_zeit;
	}
	
        // Gibt das Datum im Format "dd.MM.yyyy" zurueck
	public String getDateString(){
            return new SimpleDateFormat("dd.MM.yyyy").format(getDatum_zeit());
	}
	
        // Gibt die Zeit im Format "HH:mm:ss" zurueck
	public String getTimeString(){
            return new SimpleDateFormat("HH:mm:ss").format(getDatum_zeit());
	}
    
        // Gibt bestaetigt zurueck
        public boolean getBestaetigt() {
            return bestaetigt;
        }
    
        // Setzt bestaetigt, nur wenn das Ereignis(Datum+Zeit) vorbei ist
        public void setBestaetigt(boolean bestaetigt) { 

            if(getDatum_zeit().before(new Date() ))
               this.bestaetigt=bestaetigt;
        }
        
        // Gibt id, ort, datum, zeit und dauer im Stringformat zurueck
        @Override
        public String toString(){

            return "ID: " + getId() + " / Ort: " + ort + " / Datum: " + getDateString() + " / Zeit: " + getTimeString() + "/ Dauer[min]: " + String.format("%.2f", getDauer()); 
        }
	
}
