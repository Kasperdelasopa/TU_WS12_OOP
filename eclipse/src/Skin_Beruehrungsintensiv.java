
public class Skin_Beruehrungsintensiv extends Skin {

	@Override
	public Skin setSkinForAndroid(Bediener bediener) {
		return this;
	}
	//a Bediener is allowed to use a touch-sensitive skin
	//this object will be returned instead 

	@Override
	public Skin setSkinForAndroid(Beschuetzer beschuetzer) {
		return null;
	}
	//a Beschuetzer is not allowed to use a touch-sensitive skin
	//null will be returned instead on a error message
	
	@Override
	public Skin setSkinForAndroid(Schwerarbeiter schwerarbeiter) {
		return this;
	}
	//a Schwerarbeiter is allowed to use a touch-sensitive skin
	//null will be returned instead on a error message
	
	@Override
	public String toString(){
		return "beruehrungsempfindlicher Skin";
	}
	//returns the description for this class

}
