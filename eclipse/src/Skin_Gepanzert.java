
public class Skin_Gepanzert extends Skin {

	@Override
	public Skin setSkinForAndroid(Bediener bediener) {
		return null;
	}

	@Override
	public Skin setSkinForAndroid(Beschuetzer beschuetzer) {
		return this;
	}
	
	@Override
	public String toString(){
		return "gepanzerter Skin";
	}
	//returns the description for this class

}
