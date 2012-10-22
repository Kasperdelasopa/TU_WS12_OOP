package UE1;

import java.util.ArrayList;
import java.util.List;

public class Personen {


	private static Integer  biggestIndex = 0;
	
	public Personen(){}
	
	protected static Integer getNextIndex(){
		return biggestIndex++;
	}
	


}
