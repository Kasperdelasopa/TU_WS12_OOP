
public abstract class Bediener extends Android {

	public Bediener(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}
	
	@Override
	public void setSkin(Skin skin) {
		this.skin = skin.setSkinForAndroid(this);
	}
	// @param skin != null; skin.getSerienNummer() == this.getSerienNummer()
	// sets the skin if it does not violate the android rules
	
}
