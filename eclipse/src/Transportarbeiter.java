
public class Transportarbeiter extends Schwerarbeiter {

	public Transportarbeiter(int serienNummer, Skin skin, Software software,
			SensorAktorenKit kit) {
		super(serienNummer, skin, software, kit);
	}

	@Override
	public void setSoftware(Software software) {
		this.software = software.setSoftwareForAndroid(this);
	}
	// @param software != null; software.getSerienNummer() == this.getSerienNummer()
	// sets the software if it does not violate the android rules

	@Override
	public void setSensorAktorenKit(
			SensorAktorenKit sensorAktorenKit) {
		this.sensorenAktorenKit = sensorAktorenKit.setSensorAktorenKitForAndroid(this);
	}
	// @param sensorAktorenKit != null; sensorAktorenKit.getSerienNummer() == this.getSerienNummer()
	// sets the SensorAktorKit if it does not violate the android rules
	
	@Override
	public String toString(){
		return "Transportarbeiter";
	}
	//returns the description for this class

}
