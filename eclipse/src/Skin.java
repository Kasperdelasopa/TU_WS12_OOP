
public abstract class Skin {
	public abstract Skin setSkinForAndroid(Bediener bediener);
	public abstract Skin setSkinForAndroid(Beschuetzer beschuetzer);
	
	public Skin setSkinForAndroid(Android android) {
		return this;
	}
}
