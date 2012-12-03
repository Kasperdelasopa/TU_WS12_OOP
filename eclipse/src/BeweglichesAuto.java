
public class BeweglichesAuto extends Auto {

	public BeweglichesAuto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		super(startFeld, initialRichtung, strategie);
	}

	@Override
	public long getVerzoegerung() {
		return 100;
	}

	@Override
	protected Feld getNextFeldFromStrategie() {
		return getStrategie().getNextField(this);
	}

}
