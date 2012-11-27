
public class SensorAktorenKit_1kW extends SensorAktorenKit {

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(
			Bediener bediener) {
		return this;
	}
	//a Bediener is allowed to use a 1KW SensorAktorKit
	//so this object will be returned;

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Kaempfer kaempfer) {
		return this;
	}
	//a Kaempfer is allowed to use a 1KW SensorAktorKit
	//so this object will be returned;

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software software) {
		return this;
	}
	//a Android with any Software is allowed to use a 1KW SensorAktorKit
	//so this object will be returned;
	
	@Override
	public String toString(){
		return "1KW Sensor-Aktor-Kit";
	}
	//returns the description for this class
}
