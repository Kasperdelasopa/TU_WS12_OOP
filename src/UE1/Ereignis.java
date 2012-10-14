package UE1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ereignis {
	
	private String ort;
	private Date datum_zeit;
	//Dauer in Minuten
	private double dauer;
	
	public Ereignis(String ort, Date datum_zeit, double dauer ){		
		this.setOrt(ort);
		this.setDauer(dauer);
		this.setDatum_zeit(datum_zeit);				
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	//Dauer in Minuten
	public double getDauer() {
		return dauer;
	}

	//Dauer in Minuten
	public void setDauer(double dauer) {
		this.dauer = dauer;
	}

	public Date getDatum_zeit() {
		return datum_zeit;
	}

	public void setDatum_zeit(Date datum_zeit) {
		this.datum_zeit = datum_zeit;
	}
	
	public String getDateString(){
		return new SimpleDateFormat("dd.MM.yyyy").format(getDatum_zeit());
	}
	
	public String getTimeString(){
		return new SimpleDateFormat("HH:mm:ss").format(getDatum_zeit());
	}
	
	@Override
	public String toString(){
		
		return "Ort: " + ort + " / Datum: " + getDateString() + " / Zeit: " + getTimeString() + "/ Dauer[min]: " + String.format("%.2f", getDauer()); 
	}
	
}
