
public class Skin_Hochfest extends Skin {

	@Override
	public Skin setSkinForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a high-strength skin
	//null will be returned instead on a error message

	@Override
	public Skin setSkinForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	//a Beschuetzer is not allowed to use a high-strength skin
	//null will be returned instead on a error message

	@Override
	public Skin setSkinForAndroid(Schwerarbeiter schwerarbeiter) {
		return this;
	}
	//a Bediener is allowed to use a high-strength skin
	//null will be returned instead on a error message
	
	@Override
	public String toString(){
		return "hochfester Skin";
	}
	//returns the description for this class
}
