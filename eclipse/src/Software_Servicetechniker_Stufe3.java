
public class Software_Servicetechniker_Stufe3 extends Software_Schwerarbeiter {

	@Override
	public Software setSoftwareForAndroid(Bauarbeiter android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
	@Override
	public Software setSoftwareForAndroid(Servicetechniker android) {
		return this;
	}
	//Visitor is allowed to use this object
	//the object itself will be returned
	@Override
	public Software setSoftwareForAndroid(Transportarbeiter android) {
		return null;
	}
	//Visitor is not allowed to use this object
	//null will be returned instead of a error message
	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_1kW sensorAktorenKit) {
		return sensorAktorenKit;
	}
	//SensorAktorenKit_1kW is allowed in this object
	//so it will be returned
	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_5kW sensorAktorenKit) {
		return sensorAktorenKit;
	}
	//SensorAktorenKit_5kW is allowed in this object
	//so it will be returned

	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_10kW sensorAktorenKit) {
		return null;
	}
	//SensorAktorenKit_10kW is not allowed in this object
	//null will be returned instead of a error message
	@Override
	public String toString(){
		return "Servicetechniker-Software d. Stufe 3";
	}
	//returns the description for this class

}
