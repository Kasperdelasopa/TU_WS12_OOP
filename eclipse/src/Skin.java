
public abstract class Skin extends AbstractAndroidPart {
	public abstract Skin setSkinForAndroid(Bediener bediener);
	public abstract Skin setSkinForAndroid(Beschuetzer beschuetzer);
	
	public Skin setSkinForAndroid(Android android) {
		return this;
	}
	//ervery Android is alowed to use a skin
	//this object will be returned
}
