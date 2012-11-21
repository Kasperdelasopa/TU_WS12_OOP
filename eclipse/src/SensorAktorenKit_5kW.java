
public class SensorAktorenKit_5kW extends SensorAktorenKit {

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Bediener bediener) {
		return null;
	}

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Kaempfer kaempfer) {
		return this;
	}

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software_Stufe3 software) {
		return this;
	}

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software_Stufe4 software) {
		return this;
	}

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(Android android,
			Software software) {
		return null;
	}

	@Override
	public String toString(){
		return "5KW Sensor-Aktor-Kit";
	}
	//returns the description for this class
}
