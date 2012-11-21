
public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(int serienNummer, Skin skin, Software software,
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
		return "Bauarbeiter";
	}
	//returns the description for this class

}
