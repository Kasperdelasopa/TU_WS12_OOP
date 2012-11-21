
public abstract class Bediener extends Android {

	public Bediener(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}
	
	@Override
	protected Skin setSkin(Skin skin) {
		return skin.setSkinForAndroid(this);
	}
	
}
