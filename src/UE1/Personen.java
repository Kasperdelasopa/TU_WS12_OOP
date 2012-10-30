package UE1;

public class Personen {

	private static Integer biggestIndex = 0;

	public Personen() {
	}

	protected static Integer getNextIndex() {
		//Methode gibt die naechste freie ID zurueck 
		return biggestIndex++;
	}

}
