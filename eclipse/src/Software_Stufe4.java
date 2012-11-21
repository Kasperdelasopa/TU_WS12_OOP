
public class Software_Stufe4 extends Software {

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
		return this;
	}

	@Override
	public Software setSoftwareForAndroid(Kaempfer kaempfer) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Beschuetzer beschuetzer) {
		return this;
	}

}
