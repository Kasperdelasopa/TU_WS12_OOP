
public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}

	@Override
	protected Software setSoftware(Software software) {
		return software.setSoftwareForAndroid(this);
	}
	//null will be allowed if this Android to use the given software
	//else the object itself will be returned

	@Override
	protected SensorAktorenKit setSensorAktorenKit(
			SensorAktorenKit sensorAktorenKit) {
		return sensorAktorenKit.setSensorAktorenKitForAndroid(this);
	}
	//null will be allowed if this Android to use the given software and sensor actor kit
	//else the object itself will be returned
	
	@Override
	public String toString(){
		return "Bauarbeiter";
	}
	//returns the description for this class

}
