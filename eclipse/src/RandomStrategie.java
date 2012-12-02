
public class RandomStrategie implements Strategie {
	
	
	public RandomStrategie(Auto auto, Rennstrecke strecke){
		
	}
	
	public Feld getNextField(BeweglichesAuto auto){
		return auto.getCurrentField();
	}
	public Feld getNextField(SchnellesAuto auto){
		return auto.getCurrentField();
	}
}
