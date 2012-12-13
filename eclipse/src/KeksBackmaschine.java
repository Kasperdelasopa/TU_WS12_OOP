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
	
	public List<Crunchable> createKekse(Bestellung bestellung){
		List<Crunchable> list = new ArrayList<Crunchable>(); 
		
		//TODO..
		
		return list;
	}
	// bestellung != null
	// returns a collection of cookies
}
