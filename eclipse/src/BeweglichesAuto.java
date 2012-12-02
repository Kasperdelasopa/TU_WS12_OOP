
public class BeweglichesAuto extends Auto {

	public BeweglichesAuto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		super(startFeld, initialRichtung, strategie);
	}

	@Override
	protected void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getGeschwindigkeit() {
		return 10;
	}

}
