
public class BeweglichesAuto extends Auto {

	public BeweglichesAuto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		super(startFeld, initialRichtung, strategie);
	}

	@Override
	public long getGeschwindigkeit() {
		return 10;
	}

	@Override
	protected Feld getNextFeldFromStrategie() {
		return getStrategie().getNextField(this);
	}

}
