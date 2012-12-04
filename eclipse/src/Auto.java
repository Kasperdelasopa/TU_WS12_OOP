
public abstract class Auto extends Thread {
	// subtypes represent cars which will drive until they are interrupted
	// by another thread or they reach either the maximum number of points
	// or the maximum number of fields.

	public final int MAX_SCHRITTE = 30;
	public final int MAX_PUNKTE = 10;

	private Fahrtrichtung richtung;
	private Strategie strategie;
	// strategie != null
	
	private Feld currentField;
	// currentField != null
	
	private int punkte = 0;
	private AutoEventListener autoEventListener;
	private int anzahlSchritte = 0;
	// anzahlSchritte > 0
	
	protected long verzoegerung;
	// verzoegerung > 10
	
	protected static java.util.Random randomNumberGenerator = new java.util.Random();

	protected abstract Feld getNextFeldFromStrategie();
	// triggers the given strategy and returns the next field, that will be visited next
	
	protected abstract long getRandomVerzoegerung();
	// generates a random number representing the time between two movements in milliseconds
	// thus emulating the speed of the car.
	// return value > 10

	public Auto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		this.currentField = startFeld;
		this.richtung = initialRichtung;
		this.strategie = strategie;
		this.verzoegerung = getRandomVerzoegerung();
	}
	// initializes a new car instance
	// @param startFeld != null
	// @param initialRichtung != null
	// @param strategie != null

	protected void move() {
		Feld nextFeld;
		
		do {
			nextFeld = getNextFeldFromStrategie();
		} while(nextFeld == null);

		synchronized (this) {
			currentField.moveOut(this);
			java.util.List<Collision> collisions = nextFeld.moveIn(this);
			for (Collision collision : collisions) {
				switch(collision.getCollisionType()) {
				case Frontalaufprall:
					this.punkte++;
					break;
				case SeitenOderHeckaufprall:
					collision.getAuto().decrementPunkte();
					break;
				case KeinAufprall:
					// do nothing
					break;
				}
			}
			this.anzahlSchritte++;
			this.currentField = nextFeld;
			if(this.anzahlSchritte == MAX_SCHRITTE) {
				AutoEventListener listener = getAutoEventListener();
				if(listener != null) {
					listener.notifyEndOfRace();
				}
				try {
					this.interrupt();
				} catch(SecurityException e) {
					// ignore
				}
			}
			if(this.punkte == MAX_PUNKTE) {
				AutoEventListener listener = getAutoEventListener();
				if(listener != null) {
					listener.notifyEndOfRace();
				}
				try {
					this.interrupt();
				} catch(SecurityException e) {
					// ignore
				}
			}
		}
	}
	// calling this method will make the car leave the current field, determine the next field
	// and move to the next field.
	// if either the maximum number of points or steps is reached, the AutoEventListener will be notified.
	
	public synchronized void decrementPunkte() {
		this.punkte--;
	}
	// decrements the points of the car by one.

	@Override
	public void run() {
		super.run();
		
		boolean run = true;

		while (run) {
			move();
			try {
				Thread.sleep(getVerzoegerung());
			} catch (InterruptedException e) {
				run = false;
			}
		}
	}
	// The general contract of the method run is that it may take any action whatsoever.
	// see http://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html#run%28%29

	public long getVerzoegerung() {
		return verzoegerung;
	}
	// returns the number of milliseconds to wait until the next move is performed.
	// this property emulates the speed of the car.
	
	public Fahrtrichtung getRichtung() {
		return richtung;
	}
	// returns the current driving direction

	public Strategie getStrategie() {
		return strategie;
	}
	// returns the movement strategy

	public Feld getCurrentField() {
		return currentField;
	}
	// returns the current position within the race course

	public int getPunkte() {
		return punkte;
	}
	// returns the current number of points

	public AutoEventListener getAutoEventListener() {
		return autoEventListener;
	}
	// returns the current AutoEventListener

	public void setAutoEventListener(AutoEventListener autoEventListener) {
		this.autoEventListener = autoEventListener;
	}
	// will set the AutoEventListener of the current car.
	// @param autoEventListener != null

	public int getAnzahlSchritte() {
		return anzahlSchritte;
	}
	// returns the number of performed moves;
	// return value > 0
	
	public void setRichtung(Fahrtrichtung richtung){
		this.richtung=richtung;
	}
	// sets the driving direction of the car

	@Override
	public String toString() {
		return "Auto [richtung=" + richtung + ", punkte=" + punkte
				+ ", anzahlSchritte=" + anzahlSchritte + ", verzoegerung="
				+ verzoegerung + "]";
	}
	// returns a string representation of the car, containing direction, points and number of steps
}
