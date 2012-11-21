
public class Software_Stufe2 extends Software {

	@Override
	public Software setSoftwareForAndroid(Gesellschafter gesellschafter) {
		return null;
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

}
