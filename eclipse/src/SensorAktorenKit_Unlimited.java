
public class SensorAktorenKit_Unlimited extends SensorAktorenKit {

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a unlimited SensorAktorKit
	//null will be returned instead of an error message 

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Kaempfer kaempfer) {
		return this;
	}
	//a Kaempfer is allowed to use a unlimited SensorAktorKit
	//so this object will be returned;

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android) {		
		return null;
	}
	//any Android else with any Software is not allowed to use a unlimited SensorAktorKit
	//so null will be returned;

	@Override
	public String toString(){
		return "unlimitiertes Sensor-Aktor-Kit";
	}
	//returns the description for this class
}
