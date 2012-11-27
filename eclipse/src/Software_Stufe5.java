
public class Software_Stufe5 extends Software {

	@Override
	public Software setSoftwareForAndroid(Gesellschafter gesellschafter) {
		return null;
	}
	//a Gesellschafter is not allowed to use a Software Level 5
	//null will be returned instead of an error message 

	@Override
	public Software setSoftwareForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a Software Level 5
	//null will be returned instead of an error message 

	@Override
	public Software setSoftwareForAndroid(Schwerarbeiter schwerarbeiter) {
		return null;
	}
	//a Schwerarbeiter is not allowed to use a Software Level 5
	//null will be returned instead of an error message 
	
	@Override
	public Software setSoftwareForAndroid(Kaempfer kaempfer) {
		return this;
	}
	//a Kaempfer is allowed to use a Software Level 5
	//so this object will be returned;

	@Override
	public Software setSoftwareForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	//a Beschuetzer is not allowed to use a Software Level 5
	//null will be returned instead of an error message 
	
	@Override
	public String toString(){
		return "Software d. Stufe 5";
	}
	//returns the description for this class

}
