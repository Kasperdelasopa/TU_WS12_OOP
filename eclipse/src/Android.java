
public abstract class Android {
	// instances repersent android robots
	
	private int serienNummer; 
	private Skin skin;
	private Software software;
	private SensorAktorenKit sensorenAktorenKit;
	
	protected abstract Software setSoftware(Software software);
	protected abstract SensorAktorenKit setSensorAktorenKit(SensorAktorenKit sensorAktorenKit);
	protected abstract Skin setSkin(Skin skin);
	
	public Android(int serienNummer, Skin skin, Software software, SensorAktorenKit kit) {
		
		this.serienNummer = serienNummer;
		
		skin.setSerienNummer(serienNummer);
		software.setSerienNummer(serienNummer);
		kit.setSerienNummer(serienNummer);
		
		this.skin = setSkin(skin);
		this.software = setSoftware(software);
		if(this.software != null) {
			this.sensorenAktorenKit = setSensorAktorenKit(kit);
		}
	}
	
	public int getSerienNummer() {
		return serienNummer;
	}
	//returnes the serialnumber according to this Andoid if set else null
	
	public Skin getSkin() {
		return skin;
	}
	//returnes the actual skin if set else null
	
	public Software getSoftware() {
		return software;
	}
	//returnes the software of the Android if set else null
	
	public SensorAktorenKit getSensorenAktorenKit() {
		return sensorenAktorenKit;
	}
	//returnes the actual set sensor actor kit else null
}
