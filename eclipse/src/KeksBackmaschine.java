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
	
	public List<Crunchable> createKekse(BestellPosition bestellPosition){
		List<Crunchable> list = new ArrayList<Crunchable>(); 
		
		if(bestellPosition.getFuellung()==null){
			for(int x=0; x<bestellPosition.getAnzahl(); x++){
				list.add(new Keks(bestellPosition.getTeigart(), this.form));
			}
		}
		else{
			Keks prototyp = new Keks(bestellPosition.getTeigart(), this.form);
			for(int x=0; x<bestellPosition.getAnzahl(); x++){
				list.add(DoppelkeksBackmaschine.getInstance().createDoppelkeks(prototyp, bestellPosition.getFuellung()));
			}
		} 
		
		return list;
	}
	// @param bestellPosition != null AND bestellPosition.getForm() == this.form
	// returns a collection of cookies
}
