package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mitglieder{

	private ArrayList<Mitglied> mitglieder;
	
	public Mitglieder(){
		mitglieder = new ArrayList<Mitglied>();
	}
	
	public List<Mitglied> getMitglieder() {
		return mitglieder;
	}
	
	public List<Mitglied> getMitglieder(Date am){
		
		List<Mitglied> tmp = new ArrayList<Mitglied>();
		
		for(Mitglied e : getMitglieder()){
			
			Date dvon = e.getEintritt();
			Date dbis = e.getAustritt();
			if(dvon.before(am) && dbis.after(am)){
				tmp.add(e);
			}
		}
		
		return tmp;	
	}
	
	public void addMitglied(String name, String tele, String instro){
		mitglieder.add(new Mitglied(name, tele, instro,  findBiggestNumber()+1));
	}
	
	//false wenn Mitglied nicht gefunden wurde
	public Boolean deleteMitglied(String Name, int num){
		Boolean ret = false;
		
		List<Mitglied> tmp = getMitglieder();
		
		for(Mitglied m : getMitglieder()){
			if(m.getNummer() == num){
				m.setAustritt(new Date());
				ret = true;
			}
			
			tmp.add(m);			
		}
		this.mitglieder = (ArrayList<Mitglied>)tmp;
		
		return ret;
		
	}
	
	private int findBiggestNumber(){
		
		int biggest =0;
		
		for(Mitglied m : getMitglieder()){
			
			if(m.getNummer() > biggest)
				biggest = m.getNummer();
		}
		
		return biggest;
	}
}
