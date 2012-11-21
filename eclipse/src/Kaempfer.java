
public class Kaempfer extends Beschuetzer {

	public Kaempfer(int serienNummer, Skin skin, Software software,
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
		return sensorAktorenKit.setSensorAktorenKitForAndroid(this);
	}
	
	@Override
	public String toString(){
		return "Kämpfer";
	}
	//returns the description for this class
}
