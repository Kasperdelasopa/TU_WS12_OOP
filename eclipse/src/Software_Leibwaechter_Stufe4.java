
public class Software_Leibwaechter_Stufe4 extends Software {

	@Override
	public Software setSoftwareForAndroid(Hilfskraft android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Gesellschafter android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Bauarbeiter android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Servicetechniker android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Transportarbeiter android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Objektbewacher android) {
		return null;
	}

	@Override
	public Software setSoftwareForAndroid(Leibwaechter android) {
		return this;
	}

	@Override
	public Software setSoftwareForAndroid(Kaempfer android) {
		return null;
	}

	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_1kW sensorAktorenKit) {
		return sensorAktorenKit;
	}

	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_5kW sensorAktorenKit) {
		return sensorAktorenKit;
	}

	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_10kW sensorAktorenKit) {
		return sensorAktorenKit;
	}

	@Override
	public String toString(){
		return "Leibwaechter-Software d. Stufe 4";
	}
	//returns the description for this class
}
