import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		long starttime, elapsedTime ;
		
		//###############################################################################
		//#####   Rennen 1
		starttime = System.currentTimeMillis();
		//TODO create Rennen and start it
		List<Auto> autos = new ArrayList<Auto>();
		Auto auto = new SchnellesAuto(new Feld(),Fahrtrichtung.West,new RandomStrategie());
		autos.add(auto);
		Rennen rennen1= new Rennen(20,20, autos);
		
		elapsedTime = System.currentTimeMillis() - starttime;
		//TODO print informations
		System.out.println("Elapsed time for race #1: "+ getDuration(elapsedTime));
		//###############################################################################

		
		
	}
	
	public static String getDuration(long milliSecs)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));		
		return dateFormat.format(new Date(milliSecs));
	}
}