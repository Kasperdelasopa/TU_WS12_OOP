
public class Software_Stufe5 extends Software {

	@Override
	public Software setSoftwareForAndroid(Gesellschafter gesellschafter) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Bediener bediener) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Schwerarbeiter schwerarbeiter) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Kaempfer kaempfer) {
		return this;
	}

	@Override
	public Software setSoftwareForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	
	@Override
	public String toString(){
		return "Software d. Stufe 5";
	}
	//returns the description for this class

}
