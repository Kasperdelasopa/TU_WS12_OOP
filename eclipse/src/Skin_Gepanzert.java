
public class Skin_Gepanzert extends Skin {

	@Override
	public Skin setSkinForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a armored skin
	//null will be returned instead on a error message
	
	@Override
	public Skin setSkinForAndroid(Beschuetzer beschuetzer) {
		return this;
	}
	//a Beschuetzer is allowed to use a armored skin
	//this object will be returned instead
	
	@Override
	public Skin setSkinForAndroid(Schwerarbeiter schwerarbeiter) {
		return null;
	}
	//a Schwerarbeiter is not allowed to use a armored skin
	//null will be returned instead on a error message
	
	
	@Override
	public String toString(){
		return "gepanzerter Skin";
	}
	//returns the description for this class

}
