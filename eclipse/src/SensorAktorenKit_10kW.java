
public class SensorAktorenKit_10kW extends SensorAktorenKit {

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a 10KW SensorAktorKit
	//null will be returned instead of an error message 

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Kaempfer kaempfer) {
		return this;
	}
	//a Kaempfer is allowed to use a 10KW SensorAktorKit
	//so this object will be returned; 

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software_Stufe3 software) {
		return null;
	}
	//a android with Software-Level 3 is not allowed to use a 10KW SensorAktorKit
	//null will be returned instead of an error message 

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software_Stufe4 software) {
		return this;
	}
	//a android with a Software-Level 4 is allowed to use a 10KW SensorAktorKit
	//so this object will be returned; 

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software software) {
		return null;
	}
	//for any other android null will be returned; 

	@Override
	public String toString(){
		return "10KW Sensor-Aktor-Kit";
	}
	//returns the description for this class
}
