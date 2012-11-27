
public abstract class Software extends AbstractAndroidPart {
	public abstract Software setSoftwareForAndroid(Hilfskraft android);
	public abstract Software setSoftwareForAndroid(Gesellschafter android);
	public abstract Software setSoftwareForAndroid(Bauarbeiter android);
	public abstract Software setSoftwareForAndroid(Servicetechniker android);
	public abstract Software setSoftwareForAndroid(Transportarbeiter android);
	public abstract Software setSoftwareForAndroid(Objektbewacher android);
	public abstract Software setSoftwareForAndroid(Leibwaechter android);
	public abstract Software setSoftwareForAndroid(Kaempfer android);
	
	public abstract SensorAktorenKit setSensorAktorenKitForSoftware(SensorAktorenKit_1kW sensorAktorenKit);
	public abstract SensorAktorenKit setSensorAktorenKitForSoftware(SensorAktorenKit_5kW sensorAktorenKit);
	public abstract SensorAktorenKit setSensorAktorenKitForSoftware(SensorAktorenKit_10kW sensorAktorenKit);
}
