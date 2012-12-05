
@Guarantor(person="Manuel Schmitt")
public class Dieseltrakor extends Traktor {

	private int verbrauchteMenge = 0;
	
	public Dieseltrakor(){}
	
	@Guarantor(person="Manuel Schmitt")
	public String toString(){
		return "Dieseltraktor";
	}
	//returns a description 

	@Guarantor(person="Manuel Schmitt")
	public int getVerbrauch() {
		return verbrauchteMenge;
	}
	//returns the used Fuel

	@Guarantor(person="Manuel Schmitt")
	public void incrementVerbrauch() {
		this.verbrauchteMenge += 1;
	}
	//sets the used Fuel
	//@verbrauchteMenge must be > 0
}
