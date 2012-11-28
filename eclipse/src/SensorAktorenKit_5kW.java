
public class SensorAktorenKit_5kW extends SensorAktorenKit {

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Bediener bediener) {
		return null;
	}
	//a Bediener is not allowed to use a 5KW SensorAktorKit
	//null will be returned instead of an error message

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Kaempfer kaempfer) {
		return this;
	}
	//a Kaempfer is allowed to use a 5KW SensorAktorKit
	//so this object will be returned;

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android) {
		return android.getSoftware().setSensorAktorenKitForSoftware(this);
	}
	//all other Androids with any Software arend allowed
	//null will be returned instead of an error message

	@Override
	public String toString(){
		return "5kW Sensor-Aktor-Kit";
	}
	//returns the description for this class
}
