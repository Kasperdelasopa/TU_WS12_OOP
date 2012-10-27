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

	public Mitglied(String name, String tele, String instro, int num) {
		
		super(num, name, tele);
		setInstrument(instro);
		setEintritt(new Date());
		try {
			setAustritt(new SimpleDateFormat("yyyyMMdd").parse("99991231"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.gesperrt = false;
		this.repertoire = new Repertoire();
	}

	public Mitglied(String name, String tele, String instro, int num,
			Date eintritt, Date austritt) {
		
		this(name, tele, instro, num);

		setEintritt(eintritt);
		setAustritt(austritt);
	}

	public String getInstrument() {
		//Methode gibt das gespielte Instrument zurück
		return instrument;
	}

	public void setInstrument(String instrument) {
		//Methode setzt das gespielte Instrument
		this.instrument = instrument;
	}

	public Date getEintritt() {
		//Methode gibt das Eintrittsdatum zurück
		return eintritt;
	}

	public void setEintritt(Date eintritt) {
		//Methode setzt das Eintrittsdatum
		//FEHLER: keine Überprüfung ob eintritt < austritt
		this.eintritt = eintritt;
	}

	public Date getAustritt() {
		//Methode gibt Austrittsdatum zurück
		//das Austrittsdatum ist immer kleiner als der 31.12.9999 
		Date latest;
		try {
			latest = new SimpleDateFormat("yyyyMMdd").parse("99991231");
			if (austritt.after(latest))
				austritt = latest;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return austritt;
	}

	public void setAustritt(Date austritt) {
		//setzt das Austrittsdatum zurück
		//FEHLER: keine Prüfung ob austritt > eintritt
		this.austritt = austritt;
	}

	@Override
	public String toString() {
		//Methode gibt Informationen über das Objekt zurück
		//Das Datum ist im dt. Format
		return "Mitglied: Nummer: " + Integer.toString(getNummer())
				+ " / Name:" + getName() + " / Telefon: " + getTele()
				+ " / Instrument: " + getInstrument() + " / Gesperrt: "
				+ getGesperrt().toString() + " / von: "
				+ new SimpleDateFormat("dd.MM.yyyy").format(getEintritt())
				+ " / bis: "
				+ new SimpleDateFormat("dd.MM.yyyy").format(getAustritt());
	}

	public Repertoire getRepertoire() {
		//Methode gibt das Repertoire des Mitglieds zurück
		return repertoire;
	}

	public Boolean getGesperrt() {
		//Methode gibt das gesperrt Attribute zurück
		return gesperrt;
	}

	public void setGesperrt(Boolean gesperrt) {
		//Methode setzt das gesperrt Attribute
		this.gesperrt = gesperrt;
	}

	//Gesperrt Attribute wird nur gesetzt, wenn die Anzhal der Proben > anzahl
	public void updateGesperrt(Date von, Date bis, Ereignisse proben, int anzahl) {
		//Methode sperrt ein Mitglied wenn dieses an zu weng Proben teilgenommen hat
		//Nur Proben im Zeittraum von, bis werden berücksichtigt
		int count = 0;
		for (Probe p : proben.getProben(von, bis)) {
			if (p.getZusammensetzung().getMitglied(this.getNummer()) != null) {
				count++;
			}

		}
		if (count < anzahl) {
			this.setGesperrt(true);

		} else {
			this.setGesperrt(false);
		}
	}
}
