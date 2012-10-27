package UE1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Ersatzmitglieder extends Personen {
	
	List<Mitglied> mitglieder = new ArrayList<Mitglied>();
	
	private int minProben = 2;
	private int days  = (5 * 7);
	
	public Ersatzmitglieder(){
		super();
	}
	
	
	public void updateGesperrt(Ereignisse proben){
		//Methode aktuallisiert das gesperrt-Attribute aller Mitglieder, 
		//wenn diese nicht an genügend Proben Teilgenommen haben
		Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.DATE, -days);
        Date ago = cal.getTime();
		
		for(Mitglied m : this.getMitglieder()){
			
			m.updateGesperrt(ago, new Date(), proben , minProben);

		}
	}
	
	
	public List<Mitglied> getMitgliederGesperrt(){
		//Methode liefert die gesperrten Mitglieder
		List<Mitglied> ret = new ArrayList<Mitglied>();
		
		for(Mitglied m : getMitglieder()){
			if(m.getGesperrt())
				ret.add(m);
		}
		
		return ret;
		
	}
	
	public List<Mitglied> getMitglieder() {
		//Methode liefert alle Mitglieder
		return mitglieder;
	}

	public Boolean deleteMitglied(int num){
		//Methode löscht ein Mitglied, anhand der ID wenn diese vorhanden ist
		Boolean ret = false;
		
		List<Mitglied> tmp = new ArrayList<Mitglied>();
		for(Mitglied m : getMitglieder()) {
			
			if(m.getNummer() != num)
				tmp.add(m);
			else 
				ret = true;
		}
		
		this.mitglieder = tmp;
		return ret;
		
	}
	
	public Mitglied getMitglied(Integer id){
		//Methode gint ein Mitglied zurück, anhand der ID wenn diese vorhanden ist
		for(Mitglied m : mitglieder){
			if(id.equals(m.getNummer())){
				return m;
			}
		}
		
		return null;
	}
	
	public Mitglied getMitgliedByName(String name){
		//Methode gibt ein Mitglied anhand des Namens zurück, wenn vorhanden
		for(Mitglied m : this.getMitglieder()){
			if(m.getName().equals(name))
				return m;
		}
		return null;
	}
	
	public boolean addMitglied(Mitglied m){
		//Methode fügt ein in Liste ein, wenn dieses noch nicht ausgetreten ist
		//FEHLER: keine Überprüfung ob Mitglied bereits vorhanden
		if(m.getAustritt().before(new Date())){
			return false;
		}
		else{
			this.getMitglieder().add(m);
			return true;
		}
	}
	
	public String toString(){
		//Methode gibt Informationen über das Objekt zurück
		String ret = "Mitlieder:";
		for(Mitglied m : this.getMitglieder()){
			ret += "\n"+m.toString();
		}
		return ret;
	}
}
