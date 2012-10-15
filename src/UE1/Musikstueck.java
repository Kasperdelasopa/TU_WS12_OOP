package UE1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Musikstueck {
	
	private String name;
	//Dauer in Sekunden
	private double dauer;
	private Date gespieltAb;
	private Date gespieltBis;
	
	public Musikstueck(String name, double dauer ){
		
		this.setName(name);
		this.setDauer(dauer);
		this.setGespieltAb(new Date());
		this.setGespieltBis(new Date(Long.MAX_VALUE));
		
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getDauer() {
		return dauer;
	}


	public void setDauer(double laenge) {
		this.dauer = laenge;
	}


	public Date getGespieltAb() {
		return gespieltAb;
	}


	public void setGespieltAb(Date gespieltAb) {
		this.gespieltAb = gespieltAb;
	}


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


	public void setGespieltBis(Date gespielBis) {
		this.gespieltBis = gespielBis;
	}


	@Override
	public String toString(){
		
		return "Musikstueck: Name: " + getName() +
				" / Dauer: " + Double.toString(Math.round(getDauer())) + " min"+
				" / Ab: " + new SimpleDateFormat("dd.MM.yyyy").format(getGespieltAb()) +
				" / Bis: "+  new SimpleDateFormat("dd.MM.yyyy").format(getGespieltBis());
	}


}
