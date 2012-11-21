public class Tracker {

	private java.util.HashMap<Integer, java.util.ArrayList<Android>> map;

	public Tracker() {
		map = new java.util.HashMap<Integer, java.util.ArrayList<Android>>();
	}

	public boolean insert(Android android) {

		if ( android.getSensorenAktorenKit() != null && android.getSkin() != null && android.getSoftware() != null ) {
			
			java.util.ArrayList<Android> ausfertigungen = map.get(android.getSerienNummer());
			
			if (ausfertigungen == null) {

				ausfertigungen = new java.util.ArrayList<Android>();
				ausfertigungen.add(android);
				map.put(android.getSerienNummer(), ausfertigungen);

			} else {
				ausfertigungen.add(android);
			}
			return true;
		}
		return false;
	}
	//parameter Android is a concrete android
	//method returns true if the android was created valid so
	//all requirements of the android-regulation
	//if the android is not valid the method returns false
	//a new version is added when a android with the same serial number is already in the list
	
	public java.util.Iterator<Android> iterator(Android android) {
		java.util.ArrayList<Android> list = map.get(android.getSerienNummer());
		if(list == null) {
			return null;
		} else {
			return list.iterator();
		}
	}
	//parameter android is a concrete Android
	//returns the iterator which contains the versions of the android
	//in the order they was inserted
	
	public String find(Integer seriennummer){
		String ret=null;
		
		Android android = null;
		
		java.util.Iterator<Android> list = map.get(seriennummer).iterator();
		
		while(list.hasNext())
			android = list.next();
		
		if(android != null)
		{
			ret = "";
			ret += android.toString();
			ret += ";" + android.getSkin().toString();
			ret += ";" + android.getSoftware().toString();
			ret += ";" + android.getSensorenAktorenKit().toString();			
		}
		
		return ret;
	}
	//returns the component details of the most resent android (last android inserted in List)
	//if no android is found null will be returned
	
}
