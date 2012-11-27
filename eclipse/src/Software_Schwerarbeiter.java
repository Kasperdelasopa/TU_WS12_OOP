
public abstract class Software_Schwerarbeiter extends Software {

	@Override
	public Software setSoftwareForAndroid(Hilfskraft android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Gesellschafter android) {
		return null;
	}

	@Override
	public abstract Software setSoftwareForAndroid(Bauarbeiter android);

	@Override
	public abstract Software setSoftwareForAndroid(Servicetechniker android);

	@Override
	public abstract Software setSoftwareForAndroid(Transportarbeiter android);

	@Override
	public Software setSoftwareForAndroid(Objektbewacher android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Leibwaechter android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Kaempfer android) {
		return null;
	}

}
