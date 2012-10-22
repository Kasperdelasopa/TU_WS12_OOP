package UE1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mitglied extends Person {
	
	
	private String instrument;
	private Repertoire repertoire;
    private Boolean gesperrt;

    private Date eintritt;
	private Date austritt;
	private int nummer;
	

	public Mitglied(String name, String tele, String instro, int num){
		
		super(num, name, tele);
		setInstrument(instro);
		setEintritt(new Date());
		try {
			setAustritt(new SimpleDateFormat( "yyyyMMdd" ).parse( "99991231" ));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.gesperrt = false;
		this.repertoire = new Repertoire();
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
	

	
	@Override
	public String toString(){
		
		return "Mitglied: Nummer: "+ Integer.toString(getNummer()) + 
				" / Name:" +getName()+ 
				" / Telefon: " +getTele()+ 
				" / Instrument: " + getInstrument() + 
				" / von: " + new SimpleDateFormat("dd.MM.yyyy").format(getEintritt()) + 
				" / bis: " + new SimpleDateFormat("dd.MM.yyyy").format(getAustritt());
	}
	
	public Repertoire getRepertoire() {
		return repertoire;
	}
	
	public Boolean getGesperrt() {
		return gesperrt;
	}

	public void setGesperrt(Boolean gesperrt) {
		this.gesperrt = gesperrt;
	}
	
	public void updateGesperrt(Date von, Date bis, Ereignisse proben, int anzahl){
		
		int count =0;
		for(Probe p : proben.getProben(von, bis)){
			
			if(p.getZusammensetzung().getMitglied(this.nummer) != null)
				count++;
			
		}
		if(count < anzahl)
			this.setGesperrt(true);
		else
			this.setGesperrt(false);
	}
}
