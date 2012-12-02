
public class SchnellesAuto extends Auto {

	public SchnellesAuto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		super(startFeld, initialRichtung, strategie);
	}

	@Override
	public long getGeschwindigkeit() {
		return 50;
	}

	@Override
	protected Feld getNextFeldFromStrategie() {
		return getStrategie().getNextField(this);
	}

}
