
public class Software_Stufe1 extends Software {

	@Override
	public Software setSoftwareForAndroid(Gesellschafter gesellschafter) {
		return this;
	}

	@Override
	public Software setSoftwareForAndroid(Bediener bediener) {
		return this;
	}

	@Override
	public Software setSoftwareForAndroid(Schwerarbeiter schwerarbeiter) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Kaempfer kaempfer) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	
	@Override
	public String toString(){
		return "Software d. Stufe 1";
	}
	//returns the description for this class

}
