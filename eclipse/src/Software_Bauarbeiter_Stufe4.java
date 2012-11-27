
public class Software_Bauarbeiter_Stufe4 extends Software_Bauarbeiter_Stufe3 {

	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_10kW sensorAktorenKit) {
		return sensorAktorenKit;
	}
	
	@Override
	public String toString(){
		return "Bauarbeiter-Software d. Stufe 4";
	}
	//returns the description for this class
}
