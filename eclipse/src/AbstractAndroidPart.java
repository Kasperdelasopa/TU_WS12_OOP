
public abstract class AbstractAndroidPart {
	// instances are components that can be assembled into an Android.
	
	private int serienNummer;
	// serienNummer > 0;
	// serienNummer may be set only once before the Android containing
	// the component is added to the Tracker.

	public int getSerienNummer() {
		return serienNummer;
	}
	// returns the serial number of the belonging Android.

	public void setSerienNummer(int serienNummer) {
		this.serienNummer = serienNummer;
	}
	// @param serienNummer > 0;
	// the method may be called only once per instance.
	// after the serial number is set, it must not be changed.
}
