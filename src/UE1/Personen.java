package UE1;

public class Personen {

	private static Integer biggestIndex = 0;

	public Personen() {
	}

	protected static Integer getNextIndex() {
		//Methode gibt die n�chste freie ID zur�ck 
		return biggestIndex++;
	}

}
