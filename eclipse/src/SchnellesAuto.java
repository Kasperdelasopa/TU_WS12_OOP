
public class SchnellesAuto extends Auto {

	public SchnellesAuto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		super(startFeld, initialRichtung, strategie);
	}

	@Override
	protected void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getGeschwindigkeit() {
		return 50;
	}

}
