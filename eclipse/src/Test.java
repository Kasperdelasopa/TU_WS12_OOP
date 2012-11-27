

public class Test {

	public static void main(String[] args) {
		
		Tracker androidliste = new Tracker();
		
		//######## - BEDIENER - Hilfskraft #################################################################################//
		Skin andro1skin = new Skin_Beruehrungsintensiv();
		Software andro1sw = new Software_Stufe2();
		SensorAktorenKit andro1kit = new SensorAktorenKit_1kW();
		Android andro1 = new Hilfskraft(1, andro1skin, andro1sw, andro1kit);
		//######## - BEDIENER - Gesellschafter #############################################################################//
		Skin andro2skin = new Skin_Beruehrungsintensiv();
		Software andro2sw = new Software_Stufe1();
		SensorAktorenKit andro2kit = new SensorAktorenKit_1kW();
		Android andro2 = new Gesellschafter(2, andro2skin, andro2sw, andro2kit);
		//######## - SCHWERARBEITER - Bauarbeiter ##########################################################################//
		Skin andro3skin = new Skin_Hochfest();
		Software andro3sw = new Software_Stufe3();
		SensorAktorenKit andro3kit = new SensorAktorenKit_5kW();
		Android andro3 = new Bauarbeiter(3, andro3skin, andro3sw, andro3kit);
		//######## - SCHWERARBEITER - Servicetechniker #####################################################################//
		Skin andro4skin = new Skin_Hochfest();
		Software andro4sw = new Software_Stufe4();
		SensorAktorenKit andro4kit = new SensorAktorenKit_10kW();
		Android andro4 = new Servicetechniker(4, andro4skin, andro4sw, andro4kit);
		//######## - SCHWERARBEITER - Transportarbeiter ####################################################################//
		Skin andro5skin = new Skin_Hochfest();
		Software andro5sw = new Software_Stufe2(); //3-4?
		SensorAktorenKit andro5kit = new SensorAktorenKit_Unlimited();
		Android andro5 = new Transportarbeiter(5, andro5skin, andro5sw, andro5kit);
		//######## - BESCHUETZER - Objektbewacher ##########################################################################//
		Skin andro6skin = new Skin_Gepanzert();
		Software andro6sw = new Software_Stufe4();
		SensorAktorenKit andro6kit = new SensorAktorenKit_10kW();
		Android andro6 = new Objektbewacher(6, andro6skin, andro6sw, andro6kit);
		//######## - BESCHUETZER - Leibwaechter ############################################################################//
		Skin andro7skin = new Skin_Gepanzert();
		Software andro7sw = new Software_Stufe4();
		SensorAktorenKit andro7kit = new SensorAktorenKit_10kW();
		Android andro7 = new Leibwaechter(7, andro7skin, andro7sw, andro7kit);
		//######## - BESCHUETZER - Kaempfer ################################################################################//
		Skin andro8skin = new Skin_Gepanzert();
		Software andro8sw = new Software_Stufe5();
		SensorAktorenKit andro8kit = new SensorAktorenKit_Unlimited();
		Android andro8 = new Kaempfer(8, andro8skin, andro8sw, andro8kit);
		//##################################################################################################################//
		androidliste.insert(andro1);	
		androidliste.insert(andro2);
		androidliste.insert(andro3);
		
		/*
		androidliste.insert(andro4);
		androidliste.insert(andro5);
		androidliste.insert(andro6);
		androidliste.insert(andro7);
		androidliste.insert(andro8);*/ 
		
		System.out.println(androidliste.find(1));
		System.out.println(androidliste.find(2));
		System.out.println(androidliste.find(3));
		/*
		System.out.println(androidliste.find(4));
		System.out.println(androidliste.find(5));
		System.out.println(androidliste.find(6));
		System.out.println(androidliste.find(7));
		System.out.println(androidliste.find(8)); */
		
		

		
	}

}
