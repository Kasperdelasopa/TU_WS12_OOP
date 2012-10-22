package UE1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Ersatzmitglieder extends Mitglieder {
	
	
	private int minProben = 2;
	private int days  = (5 * 7);
	
	public Ersatzmitglieder(){
		super();
	}
	
	
	public void updateGesperrt(Proben proben){
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.DATE, days);
        Date ago = cal.getTime();
		
		for(Mitglied m : this.getMitglieder(new Date())){
			m.updateGesperrt(ago, new Date(), proben, minProben);
		}
	}
	
	
	public List<Mitglied> getMitgliederGesperrt(){
		List<Mitglied> ret = new ArrayList<Mitglied>();
		
		for(Mitglied m : getMitglieder(new Date())){
			if(m.getGesperrt())
				ret.add(m);
		}
		
		return ret;
		
	}

}
