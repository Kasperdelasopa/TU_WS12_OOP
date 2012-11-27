
public class Software_Transportarbeiter_Stufe4 extends
		Software_Transportarbeiter_Stufe3 {

	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_10kW sensorAktorenKit) {
		return sensorAktorenKit;
	}
	
	@Override
	public String toString(){
		return "Transportarbeiter-Software d. Stufe 4";
	}
	//returns the description for this class
}
