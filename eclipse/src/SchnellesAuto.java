
public class SchnellesAuto extends Auto {
	// instances represent cars that move fast but have a lower range of movement.

	public SchnellesAuto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		super(startFeld, initialRichtung, strategie);
	}
	// initializes a new fast car instance
	// @param startFeld != null
	// @param initialRichtung != null
	// @param strategie != null

	@Override
	protected Feld getNextFeldFromStrategie() {
		return getStrategie().getNextField(this);
	}
	// triggers the given strategy and returns the next field, that will be visited next

	@Override
	protected long getRandomVerzoegerung() {
		return (Math.abs(randomNumberGenerator.nextLong()) % 30) + 50;
	}
	// generates a random number representing the time between two movements in milliseconds
	// thus emulating the speed of the car.
	// return value > 10
	
}
