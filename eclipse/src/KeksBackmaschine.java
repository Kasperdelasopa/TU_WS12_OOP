import java.util.List;
import java.util.ArrayList;
public class KeksBackmaschine {
	// instances represent a machine that bakes cookies 
	// a machine can only bake one form
	
	private final Form form;
	// form != null
	
	public KeksBackmaschine(Form form){
		this.form=form;
	}
	//@param form != null
	// creates and initializes a new instance of KeksBackmaschine
	
	public List<Crunchable> createKekse(BestellPosition bestellung){
		List<Crunchable> list = new ArrayList<Crunchable>(); 
		
		if(bestellung.getFuellung()==null){
			for(int x=0; x<bestellung.getAnzahl(); x++){
				list.add(new Keks(bestellung.getTeigart(), this.form));
			}
		}
		else{
			Keks prototyp = new Keks(bestellung.getTeigart(), this.form);
			for(int x=0; x<bestellung.getAnzahl(); x++){
				list.add(DoppelkeksBackmaschine.getInstance().createDoppelkeks(prototyp, bestellung.getFuellung()));
			}
		} 
		
		return list;
	}
	// bestellung != null
	// returns a collection of cookies
}
