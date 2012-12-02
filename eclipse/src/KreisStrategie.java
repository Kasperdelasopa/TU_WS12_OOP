
public class KreisStrategie implements Strategie {

	
	public Feld getNextField(BeweglichesAuto auto){
		return auto.getCurrentField();
	}
	public Feld getNextField(SchnellesAuto auto){
		return auto.getCurrentField();
	}
}
