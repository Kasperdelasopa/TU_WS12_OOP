
public class Skin_Beruehrungsintensiv extends Skin {

	@Override
	public Skin setSkinForAndroid(Bediener bediener) {
		return this;
	}

	@Override
	public Skin setSkinForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	
	@Override
	public String toString(){
		return "beruerungsempfindlicher Skin";
	}
	//returns the description for this class

}
