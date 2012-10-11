package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repertoire {
	
	private ArrayList<Musikstueck> repertoire;
	
	
	public Repertoire(){
		
		repertoire = new ArrayList<Musikstueck>();
	}	
	
	public List<Musikstueck> getRepertoire() {
		return repertoire;
	}
	
	public List<Musikstueck> getRepertoire(Date am) {
		
		List<Musikstueck> tmp = new ArrayList<Musikstueck>();
		
		for(Musikstueck e : getRepertoire()){
			
			Date dvon = e.getGespieltAb();
			Date dbis = e.getGespieltBis();
			if(dvon.before(am) && dbis.after(am)){
				tmp.add(e);
			}
		}
		
		return tmp;
	}

	public void addMusikstueck(String name, double dauer){
		repertoire.add(new Musikstueck(name, dauer));
	}
	
	//Wird nicht gelöscht, sondern das gespieltBis Attribut gesetzt auf heute
	public Boolean deleteMitglied(String name){
		Boolean ret = false;
		
		List<Musikstueck> tmp = getRepertoire();
		
		for(Musikstueck m : getRepertoire()){
			if(m.getName() == name){
				m.setGespieltBis(new Date());
				ret = true;
			}
			
			tmp.add(m);
				
		}
		
		this.repertoire = (ArrayList<Musikstueck>)tmp;
		
		return ret;
		
	}
}
