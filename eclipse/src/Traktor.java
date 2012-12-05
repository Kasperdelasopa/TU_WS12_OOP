@Guarantor(person="Manuel Schmitt")
public abstract class Traktor {

	protected IFunktion funktion;
	@Guarantor(person="Manuel Schmitt")
	public IFunktion getFunktion() {
		return funktion;
	}
	@Guarantor(person="Manuel Schmitt")
	public void setFunktion(IFunktion funktion) {
		this.funktion = funktion;
	} 
}
