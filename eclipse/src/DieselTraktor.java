
@Guarantor(person="Manuel Schmitt")
public class DieselTraktor extends Traktor {
	//This class represents a Dieseltraktor
	//it contains the amount of used fuel
		
	private int verbrauchteMenge = 0;
	
	@Guarantor(person="Manuel Schmitt")
	public DieselTraktor(){}
	
	@Guarantor(person="Manuel Schmitt")
	public String toString(){
		return "DieselTraktor";
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
