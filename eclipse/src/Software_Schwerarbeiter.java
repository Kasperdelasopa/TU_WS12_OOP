
public abstract class Software_Schwerarbeiter extends Software {

	@Override
	public Software setSoftwareForAndroid(Hilfskraft android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
	@Override
	public Software setSoftwareForAndroid(Gesellschafter android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
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
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
	@Override
	public Software setSoftwareForAndroid(Leibwaechter android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
	@Override
	public Software setSoftwareForAndroid(Kaempfer android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message

}
