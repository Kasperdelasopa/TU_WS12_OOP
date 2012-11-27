
public class SensorAktorenKit_Unlimited extends SensorAktorenKit {

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a unlimitd SensorAktorKit
	//null will be returned instead of an error message 

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Kaempfer kaempfer) {
		return this;
	}
	//a Kaempfer is allowed to use a unlimitd SensorAktorKit
	//so this object will be returned;

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software_Stufe3 software) {
		return null;
	}
	//any Android with Software Level 3 is not allowed to use a unlimitd SensorAktorKit
	//null will be returned instead of an error message 

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software_Stufe4 software) {
		return null;
	}
	//any Android with Software Level 4 is not allowed to use a unlimitd SensorAktorKit
	//null will be returned instead of an error message
	
	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software software) {		
		return null;
	}
	//any Android else with eany Softwarw is not allowed to use a unlimitd SensorAktorKit
	//so null will be returned;

	@Override
	public String toString(){
		return "unlimitiertes Sensor-Aktor-Kit";
	}
	//returns the description for this class
}
