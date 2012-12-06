@Guarantor(person="Manuel Schmitt")
public abstract class Traktor {

	private static int id_counter = 0 ;
	
	protected final int id;
	protected int betriebsstunden;
	protected IFunktion funktion;
	
	public Traktor(){
		this.id = getNextId();
	}
	//sets the id, id can't be changed then
		
	@Guarantor(person="Manuel Schmitt")
	public void incrementBetriebsstunden(){
		betriebsstunden += 1;
	}
	//increments the Betriebsstunden
	
	@Guarantor(person="Manuel Schmitt")
	public void addBetriebsstunden(int stunden){
		betriebsstunden += stunden;
	}
	//increments the Betriebsstunden
	//@stunden must be > 0
	
	@Guarantor(person="Manuel Schmitt")
	public int getBetriebsstunden(){
		return betriebsstunden;
	}
	//returns the current Betriebsstunden
	
	@Guarantor(person="Manuel Schmitt")
	public IFunktion getFunktion() {
		return funktion;
	}
	//returns the current Funktion of the Traktor 
	
	@Guarantor(person="Manuel Schmitt")
	public void setFunktion(IFunktion funktion) {
		this.funktion = funktion;
	} 
	//Sets the funktion for a Traktor
	//@funktion must not be null
	
	@Guarantor(person="Manuel Schmitt")
	private static int getNextId() {
		return id_counter++;
	}
	//returns the next free ID
	
	@Guarantor(person="Manuel Schmitt")
	public int getID(){
		return id;
	}
	//returns ID
}
