package UE1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Musikgruppe {

	private String ausrichtung;
	private String name;
	
	private Mitglieder mitglieder;
	private Repertoire repertoire;
	private List<Probe> proben;
	private List<Auftritt> auftritte;
	
	public Musikgruppe(){
		init();
	}

	public Musikgruppe(String ausrichtung, String name){
		init();
		this.setAusrichtung(ausrichtung);
		this.setName(name);
	}
	
	private void init()
	{
		this.setAusrichtung("NotChoosenYet");
		this.setName("NotChoosenYet");
		
		mitglieder = new Mitglieder();
		proben = new ArrayList<Probe>();
		auftritte = new ArrayList<Auftritt>();
		
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

	public void addAuftritt(double gage, String ort, Date datum_zeit, double dauer)
	{
		auftritte.add(new Auftritt(gage, ort, datum_zeit, dauer));
	}
	
	public void addProbe(double miete, String ort, Date datum_zeit, double dauer){
		
		proben.add(new Probe(miete, ort, datum_zeit, dauer));
		
	}

	private List<Probe> getProben() {
		return proben;
	}

	private List<Auftritt> getAuftritte() {
		return auftritte;
	}
	

//	private List<Ereignis> getProben_Auftritte()
//	{
//		List<Ereignis> tmp = new ArrayList<Ereignis>();
//		
//		tmp.addAll(getAuftritte());
//		tmp.addAll(getProben());
//		
//		return tmp;
//	}
	
	public List<Probe> getProben(Date von, Date bis){
		
		
		List<Probe> tmp = new ArrayList<Probe>();
		
		for(Probe e : getProben()){
			
			Date date = e.getDatum_zeit();
			if(von.before(date) && bis.after(date)){
				tmp.add(e);
			}
		}
		
		return tmp;		
	}
	
	public List<Auftritt> getAuftritte(Date von, Date bis){
		
		
		List<Auftritt> tmp = new ArrayList<Auftritt>();
		
		for(Auftritt e : getAuftritte()){
			
			Date date = e.getDatum_zeit();
			if(von.before(date) && bis.after(date)){
				tmp.add(e);
			}
		}
		
		return tmp;		
	}

	public List<Ereignis> getProben_Auftritte(Date von, Date bis){
		
		List<Ereignis> tmp = new ArrayList<Ereignis>();
		
		tmp.addAll(getProben(von, bis));
		tmp.addAll(getAuftritte(von, bis));
		
		return tmp;
		
	}
	
	public double getKosten_Proben(Date von, Date bis){
		
		double tmp = 0;
		
		for(Probe p: getProben()){
			
			Date datum = p.getDatum_zeit();
			if(von.before(datum) && bis.after(datum)){
				tmp += p.getRaummiete();
			}			
		}
		
		return tmp;
		
	}
	
	public double getGewinn_Auftritte(Date von, Date bis){
		
		double tmp = 0;
		
		for(Auftritt p: getAuftritte()){
			
			Date datum = p.getDatum_zeit();
			if(von.before(datum) && bis.after(datum)){
				tmp += p.getGage();
			}			
		}
		
		return tmp;
	}
	
	public double getGewinn_minus_Kosten(Date von, Date bis){

		
		
		return getGewinn_Auftritte(von, bis) - getKosten_Proben(von, bis);
	}
	
	public Mitglieder getMitglieder() {
		return mitglieder;
	}

	public Repertoire getRepertoire() {
		return repertoire;
	}
}
