package UE1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Musikstueck {
	
	private String name;
	// name != null UND name.length() > 0
	
	private double dauer;
	// dauer > 0
	
	private Date gespieltAb;
	private Date gespieltBis;
	// gespieltAb < gespieltBis
	
	// initialisiert das Musikstueck
	public Musikstueck(String name, double dauer ){
		
		this.setName(name);
		this.setDauer(dauer);
		this.setGespieltAb(new Date());
		this.setGespieltBis(new Date(Long.MAX_VALUE));
		
	}
	
	// liefert den Namen des Musikstuecks zurueck
	public String getName() {
		return name;
	}

	// setzt den Namen des Musikstuecks
	// @param name != null && name.length() > 0
	// Fehler: die Vorbedingung wird nicht geprueft
	public void setName(String name) {
		this.name = name;
	}

	// liefert die Dauer des Musikstuecks zurueck
	public double getDauer() {
		return dauer;
	}

	// setzt die Dauer des Musikstuecks
	// @param laenge > 0
	public void setDauer(double laenge) {
		this.dauer = laenge;
	}


	// liefert den Zeitpunkt zurueck, ab dem das Musikstueck gespielt wird
	public Date getGespieltAb() {
		return gespieltAb;
	}

	// setzt den Zeitpunkt, ab dem das Musikstueck gespielt wird
	public void setGespieltAb(Date gespieltAb) {
		this.gespieltAb = gespieltAb;
	}


	// liefert den Zeitpunk, bis zu dem das Musikstueck gespielt wurde/wird
	public Date getGespieltBis() {
		Date latest;
		try {
			latest = new SimpleDateFormat( "yyyyMMdd" ).parse( "99991231" );
			if(gespieltBis.after(latest))
				gespieltBis = latest;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gespieltBis;
	}


	// setzt den Zeitpunkt, bis zu dem das Musikstueck gespielt wird/wurde
	public void setGespieltBis(Date gespielBis) {
		this.gespieltBis = gespielBis;
	}


	// liefert eine String-Repraesentation der Musikstueckinformationen
	@Override
	public String toString(){
		
		return "Musikstueck: Name: " + getName() +
				" / Dauer: " + Double.toString(Math.round(getDauer())) + " min"+
				" / Ab: " + new SimpleDateFormat("dd.MM.yyyy").format(getGespieltAb()) +
				" / Bis: "+  new SimpleDateFormat("dd.MM.yyyy").format(getGespieltBis());
	}


}
