package UE1;

import java.text.ParseException;
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
	
	/**
	 * Initialisiert eine Instanz von Mitglied.
	 * @param name Name des Mitglieds
	 * @param tele Telefonnummer
	 * @param instro Instrument
	 * @param num Eindeutige ID des Mitglieds
	 * @param eintritt Datum des Eintritts
	 * @param austritt Datum des Austritts
	 */
	public Mitglied(String name, String tele, String instro, int num, Date eintritt, Date austritt) {
		this(name, tele, instro, num);
		
		setEintritt(eintritt);
		setAustritt(austritt);
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
		
		Date latest;
		try {
			latest = new SimpleDateFormat( "yyyyMMdd" ).parse( "99991231" );
			if(austritt.after(latest))
				austritt = latest;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	
	@Override
	public String toString(){
		
		return "Mitglied: Nummer: "+ Integer.toString(getNummer()) + 
				" / Name:" +getName()+ 
				" / Telefon: " +getTele()+ 
				" / Instrument: " + getInstrument() + 
				" / von: " + new SimpleDateFormat("dd.MM.yyyy").format(getEintritt()) + 
				" / bis: " + new SimpleDateFormat("dd.MM.yyyy").format(getAustritt());
	}
}
