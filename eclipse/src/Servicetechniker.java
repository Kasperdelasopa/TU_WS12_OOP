
public class Servicetechniker extends Schwerarbeiter {

	public Servicetechniker(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}

	@Override
	protected Software setSoftware(Software software) {
		return software.setSoftwareForAndroid(this);
	}

	@Override
	protected SensorAktorenKit setSensorAktorenKit(
			SensorAktorenKit sensorAktorenKit, Software software) {
		return sensorAktorenKit.setSensorAktorenKitForAndroid(this, software);
	}

	@Override
	public String toString(){
		return "Servicetechniker";
	}
	//returns the description for this class
}
