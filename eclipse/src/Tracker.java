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
	
	public java.util.Iterator<Android> iterator(Android android) {
		java.util.ArrayList<Android> list = map.get(android.getSerienNummer());
		if(list == null) {
			return null;
		} else {
			return list.iterator();
		}
	}
}
