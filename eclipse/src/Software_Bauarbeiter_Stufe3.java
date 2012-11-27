
public class Software_Bauarbeiter_Stufe3 extends Software_Schwerarbeiter {

	@Override
	public Software setSoftwareForAndroid(Bauarbeiter android) {
		return this;
	}

	@Override
	public Software setSoftwareForAndroid(Servicetechniker android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Transportarbeiter android) {
		return null;
	}

}
