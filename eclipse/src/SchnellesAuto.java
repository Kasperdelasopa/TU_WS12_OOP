
public class SchnellesAuto extends Auto {
	// instances represent cars that move fast but have a lower range of movement.

	public SchnellesAuto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		super(startFeld, initialRichtung, strategie);
	}

	@Override
	public long getVerzoegerung() {
		return 70;
	}
	// returns the number of milliseconds to wait until the next move is performed;
	// return value > 20

	@Override
	protected Feld getNextFeldFromStrategie() {
		return getStrategie().getNextField(this);
	}
	// triggers the given strategy and returns the next field, that will be visited next
	
}
