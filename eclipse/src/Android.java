
public abstract class Android {
	// instances repersent android robots
	
	private int serienNummer; 
	private Skin skin;
	private Software software;
	private SensorAktorenKit sensorenAktorenKit;
	
	protected abstract Software setSoftware(Software software);
	protected abstract SensorAktorenKit setSensorAktorenKit(SensorAktorenKit sensorAktorenKit, Software software);
	protected abstract Skin setSkin(Skin skin);
	
	public Android(int serienNummer, Skin skin, Software software, SensorAktorenKit kit) {
		
		this.serienNummer = serienNummer;
		this.skin = setSkin(skin);
		this.software = setSoftware(software);
		this.sensorenAktorenKit = setSensorAktorenKit(kit, this.software);
		
	}
	
	public int getSerienNummer() {
		return serienNummer;
	}
	
	public Skin getSkin() {
		return skin;
	}
	
	public Software getSoftware() {
		return software;
	}
	
	public SensorAktorenKit getSensorenAktorenKit() {
		return sensorenAktorenKit;
	}
}
