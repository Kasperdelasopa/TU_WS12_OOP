
public abstract class Android {
	// instances represent android robots
	
	private int serienNummer; 
	// serienNummer > 0
	protected Skin skin;
	protected Software software;
	protected SensorAktorenKit sensorenAktorenKit;
	
	public abstract void setSoftware(Software software);
	// @param software != null; software.getSerienNummer() == this.getSerienNummer()
	// sets the software if it does not violate the android rules
	
	public abstract void setSensorAktorenKit(SensorAktorenKit sensorAktorenKit);
	// @param sensorAktorenKit != null; sensorAktorenKit.getSerienNummer() == this.getSerienNummer()
	// sets the SensorAktorKit if it does not violate the android rules
	
	public abstract void setSkin(Skin skin);
	// @param skin != null; skin.getSerienNummer() == this.getSerienNummer()
	// sets the skin if it does not violate the android rules
	
	public Android(int serienNummer, Skin skin, Software software, SensorAktorenKit kit) {
		
		this.serienNummer = serienNummer;
		
		skin.setSerienNummer(serienNummer);
		software.setSerienNummer(serienNummer);
		kit.setSerienNummer(serienNummer);
		
		setSkin(skin);
		setSoftware(software);
		if(this.software != null) {
			setSensorAktorenKit(kit);
		}
	}
	// @param serienNummer > 0;
	// @param skin != null; skin.getSerienNummer() == this.serienNummer;
	// @param software != null; software.getSerienNummer() == this.serienNummer; 
	// @param kit != null; kit.getSerienNummer() == this.serienNummer;
	
	public int getSerienNummer() {
		return serienNummer;
	}
	//returns the serialnumber according to this Android if set else null
	
	public Skin getSkin() {
		return skin;
	}
	//returns the actual skin if set else null
	
	public Software getSoftware() {
		return software;
	}
	//returns the software of the Android if set else null
	
	public SensorAktorenKit getSensorenAktorenKit() {
		return sensorenAktorenKit;
	}
	//returns the actual set sensor actor kit else null
}
