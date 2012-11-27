
public class Software_Stufe4 extends Software {

	@Override
	public Software setSoftwareForAndroid(Gesellschafter gesellschafter) {
		return null;
	}
	//a Geselschafter is not allowed to use a Software Level 4
	//null will be returned instead of an error message

	@Override
	public Software setSoftwareForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a Software Level 4
	//null will be returned instead of an error message

	@Override
	public Software setSoftwareForAndroid(Schwerarbeiter schwerarbeiter) {
		return this;
	}
	//a Schwerarbeiter is allowed to use a Software Level 4
	//this object will be returned

	@Override
	public Software setSoftwareForAndroid(Kaempfer kaempfer) {
		return null;
	}
	//a Kaempfer is not allowed to use a Software Level 4
	//null will be returned instead of an error message

	@Override
	public Software setSoftwareForAndroid(Beschuetzer beschuetzer) {
		return this;
	}
	//a Beschuetzer is allowed to use a Software Level 4
	//this object will be returned
	
	@Override
	public String toString(){
		return "Software d. Stufe 4";
	}
	//returns the description for this class

}
