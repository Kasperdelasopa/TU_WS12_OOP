
public class Software_Transportarbeiter_Stufe3 extends Software_Schwerarbeiter {

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
		return this;
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
		return null;
	}

}
