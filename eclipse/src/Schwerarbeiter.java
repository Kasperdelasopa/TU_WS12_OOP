
public abstract class Schwerarbeiter extends Android {

	public Schwerarbeiter(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}

	@Override
	protected Skin setSkin(Skin skin) {
		return skin.setSkinForAndroid(this);
	}
}
