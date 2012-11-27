
public class Software_Stufe2 extends Software {

	@Override
	public Software setSoftwareForAndroid(Gesellschafter gesellschafter) {
		return null;
	}
	//a Gesellschafter is not allowed to use a Software Level 2
	//null will be returned instead of an error message 

	@Override
	public Software setSoftwareForAndroid(Bediener bediener) {
		return this;
	}
	//a Bediener is allowed to use a Software Level 2
	//this object will be returned

	@Override
	public Software setSoftwareForAndroid(Schwerarbeiter schwerarbeiter) {
		return null;
	}
	//a Schwerarbeiter is not allowed to use a Software Level 2
	//null will be returned instead of an error message 

	@Override
	public Software setSoftwareForAndroid(Kaempfer kaempfer) {
		return null;
	}
	//a Kaempfer is not allowed to use a Software Level 2
	//null will be returned instead of an error message 

	@Override
	public Software setSoftwareForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	//a Beschuetzer is not allowed to use a Software Level 2
	//null will be returned instead of an error message 
	
	@Override
	public String toString(){
		return "Software d. Stufe 2";
	}
	//returns the description for this class

}
