public abstract class Auto implements Runnable {

	public final int MAX_SCHRITTE = 200;
	public final int MAX_PUNKTE = 50;

	private Fahrtrichtung richtung;
	private Strategie strategie;
	private Feld currentField;
	private int punkte = 0;
	private AutoEventListener autoEventListener;
	private int anzahlSchritte = 0;

	public abstract long getGeschwindigkeit();

	protected abstract Feld getNextFeldFromStrategie();

	public Auto(Feld startFeld, Fahrtrichtung initialRichtung,
			Strategie strategie) {
		this.currentField = startFeld;
		this.richtung = initialRichtung;
		this.strategie = strategie;
	}

	protected void move() {
		Feld nextFeld = getNextFeldFromStrategie();

		synchronized (this) {
			currentField.moveOut(this);
			java.util.List<Collision> collisions = nextFeld.moveIn(this);
			for (Collision collision : collisions) {
				switch(collision.getCollisionType()) {
				case Frontalaufprall:
					this.punkte++;
				case SeitenOderHeckaufprall:
					collision.getAuto().decrementPunkte();
				case KeinAufprall:
					// do nothing
				}
			}
			this.anzahlSchritte++;
			if(this.anzahlSchritte == MAX_SCHRITTE) {
				AutoEventListener listener = getAutoEventListener();
				if(listener != null) {
					listener.notifyMaxSchritteReached();
				}
			}
			if(this.punkte == MAX_PUNKTE) {
				AutoEventListener listener = getAutoEventListener();
				if(listener != null) {
					listener.notifyMaxPukteReached();
				}
			}
		}
	}
	
	public void decrementPunkte() {
		this.punkte--;
	}

	@Override
	public void run() {
		boolean run = true;

		while (run) {
			move();
			try {
				this.wait(1 / getGeschwindigkeit());
			} catch (InterruptedException e) {
				run = false;
			}
		}
	}

	public Fahrtrichtung getRichtung() {
		return richtung;
	}

	public Strategie getStrategie() {
		return strategie;
	}

	public Feld getCurrentField() {
		return currentField;
	}

	public int getPunkte() {
		return punkte;
	}

	public AutoEventListener getAutoEventListener() {
		return autoEventListener;
	}

	public void setAutoEventListener(AutoEventListener autoEventListener) {
		this.autoEventListener = autoEventListener;
	}

	public int getAnzahlSchritte() {
		return anzahlSchritte;
	}
}
