package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Musikgruppe {

	private String ausrichtung;
	private String name;
	private Mitglieder mitglieder;
	private Besetzung besetzung;

	private Ersatzmitglieder ersatzmitglieder;
	private Repertoire repertoire;
	private Ereignisse ereignisse;

	public Musikgruppe() {
		init();
	}

	public Musikgruppe(String ausrichtung, String name) {
		init();
		this.setAusrichtung(ausrichtung);
		this.setName(name);
	}

	private void init() {
		this.setAusrichtung("NotChoosenYet");
		this.setName("NotChoosenYet");

		ersatzmitglieder = new Ersatzmitglieder();
		besetzung = new Besetzung();
		mitglieder = new Mitglieder(ersatzmitglieder, besetzung);
		
		ereignisse = new Ereignisse();
		repertoire = new Repertoire();
	}

	public String getAusrichtung() {
		return ausrichtung;
	}

	public void setAusrichtung(String ausrichtung) {
		this.ausrichtung = ausrichtung;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ereignis> getProben_Auftritte(Date von, Date bis) {

		List<Ereignis> tmp = new ArrayList<Ereignis>();

		tmp.addAll(ereignisse.getProben(von, bis));
		tmp.addAll(ereignisse.getAuftritte(von, bis));

		return tmp;
	}

	public double getKosten_Proben(Date von, Date bis) {

		double tmp = 0;

		for (Probe p : ereignisse.getProben()) {

			Date datum = p.getDatum_zeit();
			if ((von.before(datum) && bis.after(datum)) || von.equals(datum)
					|| bis.equals(datum)) {
				tmp += p.getRaummiete();
			}
		}

		return tmp;

	}

	public double getGewinn_Auftritte(Date von, Date bis) {

		double tmp = 0;

		for (Auftritt p : ereignisse.getAuftritte()) {

			Date datum = p.getDatum_zeit();
			if ((von.before(datum) && bis.after(datum)) || von.equals(datum)
					|| bis.equals(datum)) {
				tmp += p.getGage();
			}
		}

		return tmp;
	}

	public double getGage_minus_Miete(Date von, Date bis) {

		return getGewinn_Auftritte(von, bis) - getKosten_Proben(von, bis);
	}

	public Mitglieder getMitglieder() {
		return mitglieder;
	}
	
	public Besetzung getBesetzung() {
		return besetzung;
	}
	
	public Ersatzmitglieder getErsatzmitglieder() {
		return ersatzmitglieder;
	}

	public Repertoire getRepertoire() {
		return repertoire;
	}

	public List<Auftritt> getAuftritte() {
        
		return ereignisse.getAuftritte();
	}

        
        public List<Probe> getProben() {
        
		return ereignisse.getProben();
	}
	
	/**
	 * 
	 * @param rein ID des Mitglieds das in die st�ndigen Mitgliedern rein soll  
	 * @param raus ID des Mitglieds das aus dem st�ndigen Mitgliedern raus soll 
	 * @throws GesperrtException 
	 */
	public Boolean verschiebe (int rein, int raus) throws GesperrtException{
		
		if(besetzung.getMitglied(raus) != null && ersatzmitglieder.getMitglied(rein) != null){
			
			ersatzmitglieder.updateGesperrt(ereignisse);
			if(ersatzmitglieder.getMitglied(rein).getGesperrt())
				throw new GesperrtException("Mitglied mit ID " + ersatzmitglieder.getMitglied(rein).getNummer()+ " ist gesperrt");
			
			besetzung.addMitglied(mitglieder.getMitglied(rein));
			ersatzmitglieder.addMitglied(mitglieder.getMitglied(raus));
			besetzung.deleteMitglied(raus);
			ersatzmitglieder.deleteMitglied(rein);
			return true;
		}
		
		return false;
	}

}
