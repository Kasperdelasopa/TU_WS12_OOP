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
		
		Rennstrecke strecke = new Rennstrecke(30,30);
		
		List<Auto> autos = new ArrayList<Auto>();
		
		Auto auto1 = new SchnellesAuto(strecke.getRandomFeld(),Fahrtrichtung.Nord,new RandomStrategie());
		
		KreisStrategie kreis2 = new KreisStrategie();
		Auto auto2 = new BeweglichesAuto(strecke.getRandomFeld(),Fahrtrichtung.Ost,kreis2);
		kreis2.setKreisStrategie(strecke ,auto2);
		
		KreisStrategie kreis3 = new KreisStrategie();
		Auto auto3 = new SchnellesAuto(strecke.getRandomFeld(),Fahrtrichtung.Sued,kreis3);
		kreis3.setKreisStrategie(strecke, auto3);
		
		Auto auto4 = new SchnellesAuto(strecke.getRandomFeld(),Fahrtrichtung.West,new RandomStrategie());
		Auto auto5 = new BeweglichesAuto(strecke.getRandomFeld(),Fahrtrichtung.Sued,new RandomStrategie());
		Auto auto6 = new BeweglichesAuto(strecke.getRandomFeld(),Fahrtrichtung.Ost,new RandomStrategie());
		
		autos.add(auto1);
		autos.add(auto2);
		autos.add(auto3);
		autos.add(auto4);
		autos.add(auto5);
		autos.add(auto6);
		Rennen rennen1= new Rennen(strecke, autos);
		
		rennen1.start();
		try {
			rennen1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elapsedTime = System.currentTimeMillis() - starttime;
		//TODO print informations
		System.out.println("Elapsed time for race #1: "+ getDuration(elapsedTime));
		//###############################################################################

		System.out.println(auto1);
		System.out.println(auto2);
		System.out.println(auto3);
		System.out.println(auto4);
		System.out.println(auto5);
		System.out.println(auto6);
	}
	
	public static String getDuration(long milliSecs)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));		
		return dateFormat.format(new Date(milliSecs));
	}
}