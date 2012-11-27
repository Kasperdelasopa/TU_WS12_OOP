
public abstract class Beschuetzer extends Android {

	public Beschuetzer(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}
	
	@Override
	protected Skin setSkin(Skin skin) {
		return skin.setSkinForAndroid(this);
	}
	//null will be allowed if this Android to use the given skin
	//else the object itself will be returned

	@Override
	public String toString(){
		return "Beschuetzer";
	}
	//returns the description for this class
}
