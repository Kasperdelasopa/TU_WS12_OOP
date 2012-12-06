@Guarantor(person="Manuel Schmitt")
public class GasTraktor extends Traktor {
 
	private double verbrauchteMenge = 0.0;
	
	public GasTraktor(){}
	
	@Guarantor(person="Manuel Schmitt")
	public String toString(){
		return "GasTraktor";
	}
	//returns a description

	@Guarantor(person="Manuel Schmitt")
	public double getVerbrauchteMenge() {
		return verbrauchteMenge;
	}
	// returns the used gas

	@Guarantor(person="Manuel Schmitt")
	public void incrementVerbrauch() {
		this.verbrauchteMenge += 1;
	}
	// sets the used gas
	// QverbrauchteMenge must be > 0
}
