@Guarantor(person="Manuel Schmitt")
public class Duengestreuer implements IFunktion {

	private double fassungskapazitaet;
	
	public Duengestreuer(double fassungskapazitaet){
		this.fassungskapazitaet = fassungskapazitaet;
	}
	//@param fassungskapazitaet  > 0.0
		
	@Guarantor(person="Manuel Schmitt")
	public String toString(){
		return "Duengestreuer";
	}
	//returns a description

	@Guarantor(person="Manuel Schmitt")
	@Override
	public Integer getMengeSaeschare() {
		return 0;
	}
	//returns always 0 because a Duengestreuer has no Saeschare

	@Guarantor(person="Manuel Schmitt")
	@Override
	public Double getFassungskapazitaet() {
		return fassungskapazitaet;
	}
	//returns the capacity
	
}
