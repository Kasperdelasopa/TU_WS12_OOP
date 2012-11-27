
public class Gesellschafter extends Bediener {

	public Gesellschafter(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}

	@Override
	public void setSoftware(Software software) {
		this.software = software.setSoftwareForAndroid(this);
	}
	//null will be allowed if this Android to use the given Software
	//else the object itself will be returned

	@Override
	public void setSensorAktorenKit(SensorAktorenKit sensorAktorenKit) {
		this.sensorenAktorenKit = sensorAktorenKit.setSensorAktorenKitForAndroid(this);
	}
	//null will be allowed if this Android to use the given SensorActor Kit and Software
	//else the object itself will be returned
	
	@Override
	public String toString(){
		return "Gesellschafter";
	}
	//returns the description for this class
}
