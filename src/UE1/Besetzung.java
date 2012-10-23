package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Besetzung extends Personen {
	
	
	List<Mitglied> mitglieder = new ArrayList<Mitglied>();
	
	public Besetzung(){
		super();
	}

	public List<Mitglied> getMitglieder() {
		return mitglieder;
	}

	public Boolean deleteMitglied(int num)
	{
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
		
		for(Mitglied m : mitglieder){
			if(id.equals(m.getNummer())){
				return m;
			}
		}
		
		return null;
	}
	
	public Mitglied getMitgliedByName(String name){
		for(Mitglied m : this.getMitglieder()){
			if(m.getName().equals(name))
				return m;
		}
		return null;
	}
	
	public boolean addMitglied(Mitglied m){
		if(m.getAustritt().before(new Date())){
			return false;
		}
		else{
			this.getMitglieder().add(m);
			return true;
		}
	}
	
	public String toString(){
		String ret = "Mitlieder:";
		for(Mitglied m : this.getMitglieder()){
			ret += "\n"+m.toString();
		}
		return ret;
	}
}
