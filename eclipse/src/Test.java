import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		long starttime1, elapsedTime1 ;
		long starttime2, elapsedTime2 ;
		long starttime3, elapsedTime3 ;
		
		//###############################################################################
		//#####   Rennen 1
		starttime1 = System.currentTimeMillis();

		Rennstrecke strecke1 = new Rennstrecke(10,10);		
		List<Auto> autos1 = new ArrayList<Auto>();
		
		KreisStrategie kreis1 = new KreisStrategie();
		Auto auto1 = new SchnellesAuto(strecke1.getRandomFeld(),Fahrtrichtung.Nord,kreis1);
		kreis1.setKreisStrategie(strecke1 ,auto1);
		
		KreisStrategie kreis2 = new KreisStrategie();
		Auto auto2 = new BeweglichesAuto(strecke1.getRandomFeld(),Fahrtrichtung.Ost,kreis2);
		kreis2.setKreisStrategie(strecke1 ,auto2);
		
		KreisStrategie kreis3 = new KreisStrategie();
		Auto auto3 = new SchnellesAuto(strecke1.getRandomFeld(),Fahrtrichtung.Sued,kreis3);
		kreis3.setKreisStrategie(strecke1, auto3);
		
		Auto auto4 = new SchnellesAuto(strecke1.getRandomFeld(),Fahrtrichtung.West,new RandomStrategie());
		Auto auto5 = new BeweglichesAuto(strecke1.getRandomFeld(),Fahrtrichtung.Sued,new RandomStrategie());
		Auto auto6 = new BeweglichesAuto(strecke1.getRandomFeld(),Fahrtrichtung.Ost,new RandomStrategie());
		Auto auto19 = new BeweglichesAuto(strecke1.getRandomFeld(),Fahrtrichtung.West,new RandomStrategie());
		Auto auto20 = new BeweglichesAuto(strecke1.getRandomFeld(),Fahrtrichtung.Nord,new RandomStrategie());
		
		autos1.add(auto1);
		autos1.add(auto2);
		autos1.add(auto3);
		autos1.add(auto4);
		autos1.add(auto5);
		autos1.add(auto6);
		autos1.add(auto19);
		autos1.add(auto20);
		Rennen rennen1= new Rennen(strecke1, autos1);
		
		rennen1.start();
		try {
			rennen1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elapsedTime1 = System.currentTimeMillis() - starttime1;
		System.out.println("Elapsed time for race #1: "+ getDuration(elapsedTime1));
		//###############################################################################

		System.out.println(auto1);
		System.out.println(auto2);
		System.out.println(auto3);
		System.out.println(auto4);
		System.out.println(auto5);
		System.out.println(auto6);
		System.out.println(auto19);
		System.out.println(auto20);
		
		//###############################################################################
		//#####   Rennen 2
		starttime2 = System.currentTimeMillis();

		Rennstrecke strecke2 = new Rennstrecke(6,6);		
		List<Auto> autos2 = new ArrayList<Auto>();
				
		Auto auto7 = new SchnellesAuto(strecke2.getRandomFeld(),Fahrtrichtung.Sued,new RandomStrategie());
				
		KreisStrategie kreis4 = new KreisStrategie();
		Auto auto8 = new BeweglichesAuto(strecke2.getRandomFeld(),Fahrtrichtung.Sued,kreis4);
		kreis4.setKreisStrategie(strecke2 ,auto8);
	
		Auto auto9 = new SchnellesAuto(strecke2.getRandomFeld(),Fahrtrichtung.West,new RandomStrategie());
		Auto auto10 = new SchnellesAuto(strecke2.getRandomFeld(),Fahrtrichtung.West,new RandomStrategie());
		Auto auto11 = new BeweglichesAuto(strecke2.getRandomFeld(),Fahrtrichtung.Nord,new RandomStrategie());
		Auto auto12 = new BeweglichesAuto(strecke2.getRandomFeld(),Fahrtrichtung.Ost,new RandomStrategie());
						
		autos2.add(auto7);
		autos2.add(auto8);
		autos2.add(auto9);
		autos2.add(auto10);
		autos2.add(auto11);
		autos2.add(auto12);
		Rennen rennen2= new Rennen(strecke2, autos2);
				
		rennen2.start();
		try {
				rennen2.join();
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
				
		elapsedTime2 = System.currentTimeMillis() - starttime2;
		System.out.println("Elapsed time for race #2: "+ getDuration(elapsedTime2));
		//###############################################################################

		System.out.println(auto7);
		System.out.println(auto8);
		System.out.println(auto9);
		System.out.println(auto10);
		System.out.println(auto11);
		System.out.println(auto12);
		
		//###############################################################################
		//#####   Rennen 3
		starttime3 = System.currentTimeMillis();

		Rennstrecke strecke3 = new Rennstrecke(5,5);		
		List<Auto> autos3 = new ArrayList<Auto>();
						
		Auto auto13 = new SchnellesAuto(strecke3.getRandomFeld(),Fahrtrichtung.Sued,new RandomStrategie());
		Auto auto14 = new BeweglichesAuto(strecke3.getRandomFeld(),Fahrtrichtung.Nord,new RandomStrategie());
		Auto auto15 = new SchnellesAuto(strecke3.getRandomFeld(),Fahrtrichtung.Nord,new RandomStrategie());
		Auto auto16 = new SchnellesAuto(strecke3.getRandomFeld(),Fahrtrichtung.Ost,new RandomStrategie());
		Auto auto17 = new BeweglichesAuto(strecke3.getRandomFeld(),Fahrtrichtung.Ost,new RandomStrategie());
								
		autos3.add(auto13);
		autos3.add(auto14);
		autos3.add(auto15);
		autos3.add(auto16);
		autos3.add(auto17);
		
		Rennen rennen3= new Rennen(strecke3, autos3);
						
		rennen3.start();
		try {
				rennen3.join();
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
						
		elapsedTime3 = System.currentTimeMillis() - starttime3;
		System.out.println("Elapsed time for race #2: "+ getDuration(elapsedTime3));
		//###############################################################################

		System.out.println(auto13);
		System.out.println(auto14);
		System.out.println(auto15);
		System.out.println(auto16);
		System.out.println(auto17);
			
	}
	
	public static String getDuration(long milliSecs)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));		
		return dateFormat.format(new Date(milliSecs));
	}
}