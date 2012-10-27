package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Besetzung extends Personen {
	//Klasse representiert 
	
	List<Mitglied> mitglieder = new ArrayList<Mitglied>();
	
	public Besetzung(){
		super();
	}

	
	public List<Mitglied> getMitglieder() {
		//Methode gibt die Liste aller Mitglieder zurück
		return mitglieder;
	}
	
	
	public Boolean deleteMitglied(int num)
	{
		//Methode löscht ein Element aus der Liste anhand einer ID wenn diese vorhanden ist
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
		//Methode gibt ein Mitglied anhand seiner ID zurück wenn ID vorhanden ist
		for(Mitglied m : mitglieder){
			if(id.equals(m.getNummer())){
				return m;
			}
		}
		
		return null;
	}
	
	public Mitglied getMitgliedByName(String name){
		//Methode gibt ein Mitglied anhand seines Namens zurück wenn Name vorhanden ist
		for(Mitglied m : this.getMitglieder()){
			if(m.getName().equals(name))
				return m;
		}
		return null;
	}
	
	
	
	public boolean addMitglied(Mitglied m){
		//Methode fügt ein Mitglied in die Liste ein wenn es noch nicht ausgetreten ist
		if(m.getAustritt().before(new Date())){
			return false;
		}
		else{
			this.getMitglieder().add(m);
			return true;
		}
		//FEHLER: Eine Überprüfung ob Mitglied bereits vorhanden
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
