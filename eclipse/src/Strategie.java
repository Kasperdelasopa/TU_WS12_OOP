
public interface Strategie {

	public Feld getNextField(BeweglichesAuto auto);
	//returns the next field for the car of type BeweglichesAuto
	public Feld getNextField(SchnellesAuto auto);
	//returns the next field for the car of type SchnellesAuto
}
