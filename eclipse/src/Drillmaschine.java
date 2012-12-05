@Guarantor(person="Manuel Schmitt")
public class Drillmaschine implements IFunktion {

	private int mengeSaeschare;
	
	public Drillmaschine(int mengeSaeschare){
		this.mengeSaeschare = mengeSaeschare;
	}
	//@mengeSeschare must be > 0 and not null
	
	@Guarantor(person="Manuel Schmitt")
	public String toString(){
		return "Drillmaschine";
	}
	//returns a description

	@Override
	public Integer getMengeSaeschare() {
		return mengeSaeschare;
	}
	//returns the amount of Seschare

	@Override
	public Double getFassungskapazitaet() {
		return 0.0;
	}
	//returns always 0.0 because a Drillmaschine has no capacity
}
