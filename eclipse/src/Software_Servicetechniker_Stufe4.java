
public class Software_Servicetechniker_Stufe4 extends
		Software_Servicetechniker_Stufe3 {

	@Override
	public SensorAktorenKit setSensorAktorenKitForSoftware(
			SensorAktorenKit_10kW sensorAktorenKit) {
		return sensorAktorenKit;
	}
	//SensorAktorenKit_10kW is allowed in this object
	//so it will be returned
	@Override
	public String toString(){
		return "Servicetechniker-Software d. Stufe 4";
	}
	//returns the description for this class
	
}
