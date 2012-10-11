package UE1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mitglied {
	
	private String name;
	private String tele;
	private String instrument;
	private Date eintritt;
	private Date austritt;
	private int nummer;
	

	public Mitglied(String name, String tele, String instro, int num){
		
		setName(name);
		setTele(tele);
		setInstrument(instro);
		setEintritt(new Date());
		setAustritt(new Date(Long.MAX_VALUE));
		setNummer(num);
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTele() {
		return tele;
	}


	public void setTele(String tele) {
		this.tele = tele;
	}


	public String getInstrument() {
		return instrument;
	}


	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public Date getEintritt() {
		return eintritt;
	}


	public void setEintritt(Date eintritt) {
		this.eintritt = eintritt;
	}


	public Date getAustritt() {
		return austritt;
	}


	public void setAustritt(Date austritt) {
		this.austritt = austritt;
	}
	
	public int getNummer() {
		return nummer;
	}


	public void setNummer(int nummer) {

		this.nummer = nummer;
	}
	
	public String toString(){
		
		return "Mitglied: Nummer: "+ Integer.toString(getNummer()) + 
				" / Name:" +getName()+ 
				" / Telefon: " +getTele()+ 
				" / Instrument: " + getInstrument() + 
				" / von: " + new SimpleDateFormat("dd.MM.yyyy").format(getEintritt()) + 
				" / bis: " + new SimpleDateFormat("dd.MM.yyyy").format(getAustritt());
	}
}
