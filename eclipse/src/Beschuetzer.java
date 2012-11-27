
public abstract class Beschuetzer extends Android {

	public Beschuetzer(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}
	
	@Override
	public void setSkin(Skin skin) {
		this.skin = skin.setSkinForAndroid(this);
	}
	// @param skin != null; skin.getSerienNummer() == this.getSerienNummer()
	// sets the skin if it does not violate the android rules
	
	@Override
	public String toString(){
		return "Beschuetzer";
	}
	//returns the description for this class
}
