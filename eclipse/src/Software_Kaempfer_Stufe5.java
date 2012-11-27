
public class Software_Kaempfer_Stufe5 extends Software {

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
	public Software setSoftwareForAndroid(Bauarbeiter android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
	@Override
	public Software setSoftwareForAndroid(Servicetechniker android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
	@Override
	public Software setSoftwareForAndroid(Transportarbeiter android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
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
		return this;
	}
	//Visitor is allowed to use this object
	//the object itself will be returned
	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_1kW sensorAktorenKit) {
		return sensorAktorenKit;
	}
	//SensorAktorenKit_1kW is not allowed in this object
	//null will be returned instead of a error message
	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_5kW sensorAktorenKit) {
		return sensorAktorenKit;
	}
	//SensorAktorenKit_5kW is not allowed in this object
	//null will be returned instead of a error message
	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_10kW sensorAktorenKit) {
		return sensorAktorenKit;
	}
	//SensorAktorenKit_10kW is not allowed in this object
	//null will be returned instead of a error message
	@Override
	public String toString(){
		return "Kaempfer-Software d. Stufe 5";
	}
	//returns the description for this class

}
