import java.lang.reflect.Method;

@Guarantor(person="Alle Gruppenmitglieder")
public class Test {

	public static void main(String[] args) {
		/**
		 * Testfaelle
		 */
		
		Traktor t1 = new DieselTraktor(); 
		Traktor t2 = new DieselTraktor();
		Traktor t3 = new DieselTraktor();
		Traktor t4 = new DieselTraktor();
		Traktor t5 = new DieselTraktor();
		Traktor t6 = new GasTraktor();
		Traktor t7 = new DieselTraktor();
		Traktor t8 = new DieselTraktor();
		Traktor t9 = new DieselTraktor();
		Traktor t10 = new GasTraktor();
		Traktor t11 = new DieselTraktor();
		Traktor t12 = new GasTraktor();
		Traktor t13 = new DieselTraktor();
		Traktor t14 = new DieselTraktor();
		Traktor t15 = new GasTraktor();
		Traktor t16 = new GasTraktor();
		Traktor t17 = new DieselTraktor();
		Traktor t18 = new GasTraktor();
		Traktor t19 = new GasTraktor();
		Traktor t20 = new DieselTraktor();
	
		Bauernhof bauernhof1 = new Bauernhof("Diesel-BH");
		Bauernhof bauernhof2 = new Bauernhof("Bio-Bauernhof-Steiermark");	
		Bauernhof bauernhof3 = new Bauernhof("Almdorf-Bauernhof");
		
		BauernhofList bauernhofliste = new BauernhofList();
		bauernhofliste.add(bauernhof1);
		bauernhofliste.add(bauernhof2);
		bauernhofliste.add(bauernhof3);
		
		/************************************************************************************************/
		//Adding Traktoren
		/************************************************************************************************/
		
		bauernhofliste.getBauernhofByName("Diesel-BH").addTraktor(t1);
		bauernhofliste.getBauernhofByName("Diesel-BH").addTraktor(t2);
		bauernhofliste.getBauernhofByName("Diesel-BH").addTraktor(t3);
		bauernhofliste.getBauernhofByName("Diesel-BH").addTraktor(t4);
		bauernhofliste.getBauernhofByName("Diesel-BH").addTraktor(t5);
		
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addTraktor(t6);
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addTraktor(t7);
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addTraktor(t8);
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addTraktor(t9);
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addTraktor(t10);
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addTraktor(t11);
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addTraktor(t12);
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addTraktor(t13);
		
		
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addTraktor(t14);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addTraktor(t15);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addTraktor(t16);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addTraktor(t17);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addTraktor(t18);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addTraktor(t19);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addTraktor(t20); 

		
		/************************************************************************************************/
		//Changing informations
		/************************************************************************************************/
		
		bauernhofliste.getBauernhofByName("Diesel-BH").addBetriebsstunden(1,10); 
		bauernhofliste.getBauernhofByName("Diesel-BH").addBetriebsstunden(2,5); 
		bauernhofliste.getBauernhofByName("Diesel-BH").addBetriebsstunden(3,2); 
		bauernhofliste.getBauernhofByName("Diesel-BH").addBetriebsstunden(4,34); 
		bauernhofliste.getBauernhofByName("Diesel-BH").addBetriebsstunden(5,8); 

		
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addBetriebsstunden(6,5); 
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addBetriebsstunden(7,5); 
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addBetriebsstunden(8,5); 
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addBetriebsstunden(9,5); 
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addBetriebsstunden(10,5);
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addBetriebsstunden(11,5); 
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addBetriebsstunden(12,5); 
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").addBetriebsstunden(13,5); 
		
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addBetriebsstunden(14,1); 
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addBetriebsstunden(15,43); 
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addBetriebsstunden(16,3); 
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addBetriebsstunden(17,10000); 
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addBetriebsstunden(18,1);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addBetriebsstunden(19,100); 
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").addBetriebsstunden(20,200); 
		
	
		for(int i=0; i<10; i++){
			bauernhofliste.getBauernhofByName("Diesel-BH").erhoeheDieselVerbrauch(1);
			bauernhofliste.getBauernhofByName("Diesel-BH").erhoeheDieselVerbrauch(2);
			bauernhofliste.getBauernhofByName("Diesel-BH").erhoeheDieselVerbrauch(5);
			bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").erhoeheDieselVerbrauch(11);
			bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").erhoeheDieselVerbrauch(13);
			bauernhofliste.getBauernhofByName("Diesel-BH").erhoeheDieselVerbrauch(4);
		}
		bauernhofliste.getBauernhofByName("Diesel-BH").erhoeheDieselVerbrauch(1);
		for(int i=0; i<4; i++){
			bauernhofliste.getBauernhofByName("Diesel-BH").erhoeheDieselVerbrauch(3);
			bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").erhoeheDieselVerbrauch(7);
			bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").erhoeheDieselVerbrauch(8);
			bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").erhoeheDieselVerbrauch(9);
			
		}
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").erhoeheDieselVerbrauch(20);
		
		
		for(int i=0; i<7; i++){
			bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").erhoeheGasVerbrauch(6);
			bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").erhoeheGasVerbrauch(12);
			bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").erhoeheGasVerbrauch(15);
		}
		for(int i=0; i<4; i++){
			bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").erhoeheGasVerbrauch(10);
			bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").erhoeheGasVerbrauch(16);
			bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").erhoeheGasVerbrauch(18);
			bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").erhoeheGasVerbrauch(19);
			
		}
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").erhoeheGasVerbrauch(19);

		
		
		
		bauernhofliste.getBauernhofByName("Diesel-BH").aendereFunktion(1, new Drillmaschine(40));;
		bauernhofliste.getBauernhofByName("Diesel-BH").aendereFunktion(2, new Drillmaschine(100));;
		bauernhofliste.getBauernhofByName("Diesel-BH").aendereFunktion(3, new Drillmaschine(10));;
		bauernhofliste.getBauernhofByName("Diesel-BH").aendereFunktion(4, new Drillmaschine(100));;
		bauernhofliste.getBauernhofByName("Diesel-BH").aendereFunktion(5, new Drillmaschine(10));;
		
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").aendereFunktion(6, new Drillmaschine(30));;
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").aendereFunktion(7, new Duengestreuer(100.0));;
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").aendereFunktion(8, new Duengestreuer(10.5));;
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").aendereFunktion(9, new Drillmaschine(100));;
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").aendereFunktion(10, new Duengestreuer(70.8));;
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").aendereFunktion(11, new Drillmaschine(5));
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").aendereFunktion(12, new Duengestreuer(100.0));;
		bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").aendereFunktion(13, new Duengestreuer(75.5));;

		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").aendereFunktion(19, new Duengestreuer(50.0));;
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").aendereFunktion(20, new Duengestreuer(50.0));;
		
		/************************************************************************************************/
		//Removing some Traktoren
		/************************************************************************************************/
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").removeTraktor(14);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").removeTraktor(15);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").removeTraktor(16);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").removeTraktor(17);
		bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").removeTraktor(18);
		
		/************************************************************************************************/
		//Output: statistical values 
		/************************************************************************************************/
		
		System.out.println(bauernhofliste.getBauernhofByName("Diesel-BH") + "\n-----------------");
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageBetriebsstunden());
		System.out.println("Durchschnittliche Betriebsstunden Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageBetriebsstundenDieselTraktor());
		System.out.println("Durchschnittliche Betriebsstunden Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageBetriebsstundenGasTraktor());
		
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren mit Drillmaschine: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageBetriebsstundenDrillmaschine());
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren mit Duengerstreuer: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageBetriebsstundenDuengerstreuer());
		
		System.out.println("Durchschnittlicher Dieselverbrauch: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageDieselVerbrauch());
		System.out.println("Durchschnittlicher Dieselverbrauch - Drillmaschine: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageDieselVerbrauchDrillmaschine());
		System.out.println("Durchschnittlicher Dieselverbrauch - Duengerstreuer: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageDieselVerbrauchDuengerstreuer());
		
		System.out.println("Durchschnittlicher Gasverbrauch: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageGasVerbrauch());
		System.out.println("Durchschnittlicher Gasverbrauch - Drillmaschine: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageGasVerbrauchDrillmaschine());
		System.out.println("Durchschnittlicher Gasverbrauch - Duengerstreuer: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageGasVerbrauchDuengerstreuer());
		
		System.out.println("Minimale Anzahl an SŠscharen - aller Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getMinSaeschare());
		System.out.println("Minimale Anzahl an SŠscharen - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getMinSaeschareDieselTraktor());
		System.out.println("Minimale Anzahl an SŠscharen - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getMinSaeschareGasTraktor());
		
		System.out.println("Maximale Anzahl an SŠscharen - aller Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getMaxSaeschare());
		System.out.println("Maximale Anzahl an SŠscharen - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getMaxSaeschareDieselTraktor());
		System.out.println("Maximale Anzahl an SŠscharen - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getMaxSaeschareGasTraktor());
		
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageFassungskapazitaet());
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageFassungskapazitaetDieselTraktor());
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Diesel-BH").getAverageFassungskapazitaetGasTraktor());
			
		
		System.out.println("#####################################################################################################");
		System.out.println("#####################################################################################################");
		
		
		System.out.println("\n" + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark") + "\n-------------------------");
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageBetriebsstunden());
		System.out.println("Durchschnittliche Betriebsstunden Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageBetriebsstundenDieselTraktor());
		System.out.println("Durchschnittliche Betriebsstunden Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageBetriebsstundenGasTraktor());
		
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren mit Drillmaschine: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageBetriebsstundenDrillmaschine());
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren mit Duengerstreuer: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageBetriebsstundenDuengerstreuer());
		
		System.out.println("Durchschnittlicher Dieselverbrauch: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageDieselVerbrauch());
		System.out.println("Durchschnittlicher Dieselverbrauch - Drillmaschine: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageDieselVerbrauchDrillmaschine());
		System.out.println("Durchschnittlicher Dieselverbrauch - Duengerstreuer: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageDieselVerbrauchDuengerstreuer());
		
		System.out.println("Durchschnittlicher Gasverbrauch: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageGasVerbrauch());
		System.out.println("Durchschnittlicher Gasverbrauch - Drillmaschine: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageGasVerbrauchDrillmaschine());
		System.out.println("Durchschnittlicher Gasverbrauch - Duengerstreuer: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageGasVerbrauchDuengerstreuer());
		
		System.out.println("Minimale Anzahl an SŠscharen - aller Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getMinSaeschare());
		System.out.println("Minimale Anzahl an SŠscharen - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getMinSaeschareDieselTraktor());
		System.out.println("Minimale Anzahl an SŠscharen - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getMinSaeschareGasTraktor());
		
		System.out.println("Maximale Anzahl an SŠscharen - aller Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getMaxSaeschare());
		System.out.println("Maximale Anzahl an SŠscharen - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getMaxSaeschareDieselTraktor());
		System.out.println("Maximale Anzahl an SŠscharen - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getMaxSaeschareGasTraktor());
		
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageFassungskapazitaet());
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageFassungskapazitaetDieselTraktor());
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Bio-Bauernhof-Steiermark").getAverageFassungskapazitaetGasTraktor());
		
		
		System.out.println("#####################################################################################################");
		System.out.println("#####################################################################################################");
		
		
		System.out.println("\n"+ bauernhofliste.getBauernhofByName("Almdorf-Bauernhof") + "\n-----------------");
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageBetriebsstunden());
		System.out.println("Durchschnittliche Betriebsstunden Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageBetriebsstundenDieselTraktor());
		System.out.println("Durchschnittliche Betriebsstunden Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageBetriebsstundenGasTraktor());
		
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren mit Drillmaschine: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageBetriebsstundenDrillmaschine());
		System.out.println("Durchschnittliche Betriebsstunden aller Traktoren mit Duengerstreuer: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageBetriebsstundenDuengerstreuer());
		
		System.out.println("Durchschnittlicher Dieselverbrauch: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageDieselVerbrauch());
		System.out.println("Durchschnittlicher Dieselverbrauch - Drillmaschine: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageDieselVerbrauchDrillmaschine());
		System.out.println("Durchschnittlicher Dieselverbrauch - Duengerstreuer: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageDieselVerbrauchDuengerstreuer());
		
		System.out.println("Durchschnittlicher Gasverbrauch: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageGasVerbrauch());
		System.out.println("Durchschnittlicher Gasverbrauch - Drillmaschine: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageGasVerbrauchDrillmaschine());
		System.out.println("Durchschnittlicher Gasverbrauch - Duengerstreuer: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageGasVerbrauchDuengerstreuer());
		
		System.out.println("Minimale Anzahl an SŠscharen - aller Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getMinSaeschare());
		System.out.println("Minimale Anzahl an SŠscharen - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getMinSaeschareDieselTraktor());
		System.out.println("Minimale Anzahl an SŠscharen - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getMinSaeschareGasTraktor());
		
		System.out.println("Maximale Anzahl an SŠscharen - aller Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getMaxSaeschare());
		System.out.println("Maximale Anzahl an SŠscharen - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getMaxSaeschareDieselTraktor());
		System.out.println("Maximale Anzahl an SŠscharen - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getMaxSaeschareGasTraktor());
		
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageFassungskapazitaet());
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters - Diesel-Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageFassungskapazitaetDieselTraktor());
		System.out.println("Durchschnittliche Fassungskapazitaet des Duengebehaelters - Gas-Traktoren: " + bauernhofliste.getBauernhofByName("Almdorf-Bauernhof").getAverageFassungskapazitaetGasTraktor());
		
		
		System.out.println("#####################################################################################################");
		System.out.println("################################# - Anotations -#####################################################");
		System.out.println("#####################################################################################################");
		/**
		 * Ausgabe der Anotations
		 */
		printInfoForClass(Bauernhof.class);
		printInfoForClass(DieselTraktor.class);
		printInfoForClass(Drillmaschine.class);
		printInfoForClass(Duengestreuer.class);
		printInfoForClass(GasTraktor.class);
		printInfoForClass(Guarantor.class);
		printInfoForClass(IFunktion.class);
		printInfoForClass(Test.class);
		printInfoForClass(Traktor.class);
		
		printInfoForClass(TraktorList.class);
		printInfoForClass(DieselTraktorList.class);
		printInfoForClass(GasTraktorList.class);
		printInfoForClass(BauernhofList.class);
		printInfoForClass(IBaseIterator.class);
		printInfoForClass(IBauernhofIterator.class);
		printInfoForClass(ITraktorIterator.class);
		printInfoForClass(IDieselTraktorIterator.class);
		printInfoForClass(IGasTraktorIterator.class);
	}
	
	@Guarantor(person="Alle Gruppenmitglieder")
	public static void printInfoForClass(@SuppressWarnings("rawtypes") Class c){
		
		@SuppressWarnings("unchecked")
		Guarantor g1 = ((Guarantor)c.getAnnotation(Guarantor.class));
		if(g1 != null)
			System.out.println("The Class <<"+c.getName()+">> was written by "+g1.person());
		
		for(Method m : c.getMethods()){
			Guarantor g2 = ((Guarantor)m.getAnnotation(Guarantor.class));
			if(g2 != null)
				System.out.println("  The Method <"+m.getName()+"> in Class <<"+c.getName()+">> was written by "+g2.person());
		}
	}
	//prints out the Annotations for classes and methods
	//@param c must not be null
}