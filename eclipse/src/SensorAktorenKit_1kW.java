
public class SensorAktorenKit_1kW extends SensorAktorenKit {

	@Override
	public SensorAktorenKit setSensorAktorenKitForAndroid(
			Bediener bediener) {
		return this;
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
		return this;
	}
	
	@Override
	public String toString(){
		return "1KW Sensor-Aktor-Kit";
	}
	//returns the description for this class
}
