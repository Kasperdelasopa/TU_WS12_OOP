
public class Skin_Hochfest extends Skin {

	@Override
	public Skin setSkinForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a touch-senitiv skin
	//null will be returned instead on a error message

	@Override
	public Skin setSkinForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	//a Beschuetzer is not allowed to use a armored skin
	//null will be returned instead on a error message

	@Override
	public String toString(){
		return "hochfester Skin";
	}
	//returns the description for this class
}
