
public class SensorAktorenKit_10kW extends SensorAktorenKit {

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
		return null;
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

}
