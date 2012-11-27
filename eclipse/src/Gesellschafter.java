
public class Gesellschafter extends Bediener {

	public Gesellschafter(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}

	@Override
	protected Software setSoftware(Software software) {
		return software.setSoftwareForAndroid(this);
	}
	//null will be allowed if this Android to use the given Software
	//else the object itself will be returned

	@Override
	protected SensorAktorenKit setSensorAktorenKit(
			SensorAktorenKit sensorAktorenKit, Software software) {
		return sensorAktorenKit.setSensorAktorenKitForAndroid(this);
	}
	//null will be allowed if this Android to use the given SensorActor Kit and Software
	//else the object itself will be returned
	
	@Override
	public String toString(){
		return "Gesellschafter";
	}
	//returns the description for this class
}
