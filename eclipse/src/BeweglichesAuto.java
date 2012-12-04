
public class BeweglichesAuto extends Auto {
	// instances represent cars, that move slow but have a higher range of movement.

	public BeweglichesAuto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		super(startFeld, initialRichtung, strategie);
	}

	@Override
	protected Feld getNextFeldFromStrategie() {
		return getStrategie().getNextField(this);
	}
	// triggers the given strategy and returns the next field, that will be visited next

	@Override
	protected long getRandomVerzoegerung() {
		return (Math.abs(randomNumberGenerator.nextLong()) % 20) + 80;
	}
	// generates a random number representing the time between two movements in milliseconds
	// thus emulating the speed of the car.
	// return value > 10

}
