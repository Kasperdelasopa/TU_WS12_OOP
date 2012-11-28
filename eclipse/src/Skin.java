
public abstract class Skin extends AbstractAndroidPart {
	public abstract Skin setSkinForAndroid(Bediener bediener);
	public abstract Skin setSkinForAndroid(Beschuetzer beschuetzer);
	public abstract Skin setSkinForAndroid(Schwerarbeiter schwerarbeiter);
	
	public Skin setSkinForAndroid(Android android) {
		return this;
	}
	//every Android is allowed to use a skin
	//this object will be returned
}
