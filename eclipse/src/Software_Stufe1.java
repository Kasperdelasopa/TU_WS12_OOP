
public class Software_Stufe1 extends Software {

	@Override
	public Software setSoftwareForAndroid(Gesellschafter gesellschafter) {
		return this;
	}
	//a Gesellschafter is allowed to use a Software Level 1
	//so this object will be returned;

	@Override
	public Software setSoftwareForAndroid(Bediener bediener) {
		return this;
	}
	//a Bediener is allowed to use a Software Level 1
	//so this object will be returned;

	@Override
	public Software setSoftwareForAndroid(Schwerarbeiter schwerarbeiter) {
		return null;
	}
	//a Schwerarbeiter is not allowed to use a Software Level 1
	//null will be returned instead of an error message 

	@Override
	public Software setSoftwareForAndroid(Kaempfer kaempfer) {
		return null;
	}
	//a Kaempfer is not allowed to use a Software Level 1
	//null will be returned instead of an error message 

	@Override
	public Software setSoftwareForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	//a Beschuetzer is not allowed to use a Software Level 1
	//null will be returned instead of an error message 
	
	@Override
	public String toString(){
		return "Software d. Stufe 1";
	}
	//returns the description for this class

}
