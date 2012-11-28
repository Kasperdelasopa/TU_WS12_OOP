

public class Test {

	public static void main(String[] args) {
		
		Tracker androidliste = new Tracker();
		
		System.out.println("###############  -- Androids: -- ##############");
		//######## - BEDIENER - Hilfskraft #################################################################################//
		Skin andro1skin = new Skin_Beruehrungsintensiv();
		Software andro1sw = new Software_Hilfskraft_Stufe1();
		SensorAktorenKit andro1kit = new SensorAktorenKit_1kW();
		Android andro1 = new Hilfskraft(1, andro1skin, andro1sw, andro1kit);
		//######## - BEDIENER - Hilfskraft #################################################################################//
		Skin andro2skin = new Skin_Beruehrungsintensiv();
		Software andro2sw = new Software_Hilfskraft_Stufe2();
		SensorAktorenKit andro2kit = new SensorAktorenKit_1kW();
		Android andro2 = new Hilfskraft(2, andro2skin, andro2sw, andro2kit);
		//######## - BEDIENER - Gesellschafter #############################################################################//
		Skin andro3skin = new Skin_Beruehrungsintensiv();
		Software andro3sw = new Software_Gesellschafter_Stufe1();
		SensorAktorenKit andro3kit = new SensorAktorenKit_1kW();
		Android andro3 = new Gesellschafter(3, andro3skin, andro3sw, andro3kit);
		//######## - SCHWERARBEITER - Servicetechniker #####################################################################//
		Skin andro4skin = new Skin_Hochfest();
		Software andro4sw = new Software_Servicetechniker_Stufe3();
		SensorAktorenKit andro4kit = new SensorAktorenKit_5kW();
		Android andro4 = new Servicetechniker(4, andro4skin, andro4sw, andro4kit);
		//######## - SCHWERARBEITER - Transportarbeiter ####################################################################//
		Skin andro5skin = new Skin_Hochfest();
		Software andro5sw = new Software_Transportarbeiter_Stufe3(); //3-4?
		SensorAktorenKit andro5kit = new SensorAktorenKit_5kW();
		Android andro5 = new Transportarbeiter(5, andro5skin, andro5sw, andro5kit);
		//######## - SCHWERARBEITER - Bauarbeiter ##########################################################################//
		Skin andro6skin = new Skin_Hochfest();
		Software andro6sw = new Software_Bauarbeiter_Stufe3();
		SensorAktorenKit andro6kit = new SensorAktorenKit_5kW();
		Android andro6 = new Bauarbeiter(6, andro6skin, andro6sw, andro6kit);
		//######## - SCHWERARBEITER - Servicetechniker #####################################################################//
		Skin andro7skin = new Skin_Beruehrungsintensiv();
		Software andro7sw = new Software_Servicetechniker_Stufe4();
		SensorAktorenKit andro7kit = new SensorAktorenKit_10kW();
		Android andro7 = new Servicetechniker(7, andro7skin, andro7sw, andro7kit);
		//######## - SCHWERARBEITER - Transportarbeiter ####################################################################//
		Skin andro8skin = new Skin_Beruehrungsintensiv();
		Software andro8sw = new Software_Transportarbeiter_Stufe4(); //3-4?
		SensorAktorenKit andro8kit = new SensorAktorenKit_10kW();
		Android andro8 = new Transportarbeiter(8, andro8skin, andro8sw, andro8kit);
		//######## - SCHWERARBEITER - Bauarbeiter ##########################################################################//
		Skin andro9skin = new Skin_Beruehrungsintensiv();
		Software andro9sw = new Software_Bauarbeiter_Stufe4();
		SensorAktorenKit andro9kit = new SensorAktorenKit_10kW();
		Android andro9 = new Bauarbeiter(9, andro9skin, andro9sw, andro9kit);
		//######## - BESCHUETZER - Objektbewacher ##########################################################################//
		Skin andro10skin = new Skin_Gepanzert();
		Software andro10sw = new Software_Objektbewacher_Stufe4();
		SensorAktorenKit andro10kit = new SensorAktorenKit_10kW();
		Android andro10 = new Objektbewacher(10, andro10skin, andro10sw, andro10kit);
		//######## - BESCHUETZER - Leibwaechter ############################################################################//
		Skin andro11skin = new Skin_Gepanzert();
		Software andro11sw = new Software_Leibwaechter_Stufe4();
		SensorAktorenKit andro11kit = new SensorAktorenKit_5kW();
		Android andro11 = new Leibwaechter(11, andro11skin, andro11sw, andro11kit);
		//######## - BESCHUETZER - Kaempfer ################################################################################//
		Skin andro12skin = new Skin_Gepanzert();
		Software andro12sw = new Software_Kaempfer_Stufe5();
		SensorAktorenKit andro12kit = new SensorAktorenKit_Unlimited();
		Android andro12 = new Kaempfer(12, andro12skin, andro12sw, andro12kit);
		//##################################################################################################################//
		
		androidliste.insert(andro1);	
		androidliste.insert(andro2);
		androidliste.insert(andro3);
		androidliste.insert(andro4);
		androidliste.insert(andro5);
		androidliste.insert(andro6);
		androidliste.insert(andro7);
		androidliste.insert(andro8);
		androidliste.insert(andro9);
		androidliste.insert(andro10);
		androidliste.insert(andro11);
		androidliste.insert(andro12);
		
		System.out.println(androidliste.find(1));
		System.out.println(androidliste.find(2));
		System.out.println(androidliste.find(3));
		System.out.println(androidliste.find(4));
		System.out.println(androidliste.find(5));
		System.out.println(androidliste.find(6));
		System.out.println(androidliste.find(7));
		System.out.println(androidliste.find(8)); 
		System.out.println(androidliste.find(9)); 
		System.out.println(androidliste.find(10)); 
		System.out.println(androidliste.find(11)); 
		System.out.println(androidliste.find(12)); 

		//##################################################################################################################//
		//##################################################################################################################//
		//##################################################################################################################//
		
		
		
		System.out.println("############### -- Changing Parts -- #################");
		System.out.println("Refreshing Parts");
		System.out.println("Before: " + androidliste.find(1));
		Skin newSkinForAndro1 = new Skin_Beruehrungsintensiv();
		SensorAktorenKit newKitForAndro1 = new SensorAktorenKit_1kW();
		newSkinForAndro1.setSerienNummer(andro1.getSerienNummer());
		newKitForAndro1.setSerienNummer(andro1.getSerienNummer());
		
		andro1.setSkin(newSkinForAndro1);
		andro1.setSensorAktorenKit(newKitForAndro1);
		androidliste.insert(andro1);
		
		System.out.println("Later:  " + androidliste.find(1));
		
		//##################################################################################################################//
		System.out.println("-----------------------");
		System.out.println("New Kit: 5kW to 1kW  // Another Skin");
		System.out.println("Before: " + androidliste.find(4));
		Skin newSkinForAndro4 = new Skin_Beruehrungsintensiv();
		SensorAktorenKit newKitForAndro4= new SensorAktorenKit_1kW();
		newSkinForAndro4.setSerienNummer(andro4.getSerienNummer());
		newKitForAndro4.setSerienNummer(andro4.getSerienNummer());
		
		andro4.setSkin(newSkinForAndro4);
		andro4.setSensorAktorenKit(newKitForAndro4);
		androidliste.insert(andro4);
		
		System.out.println("Later:  " + androidliste.find(4));
		//##################################################################################################################//
		System.out.println("-----------------------");
		System.out.println("New Kit: 10kW to 5kW to 1kW");
		System.out.println("Before: " + androidliste.find(9));
		SensorAktorenKit newKitForAndro9= new SensorAktorenKit_5kW();
		newKitForAndro9.setSerienNummer(andro9.getSerienNummer());
		andro9.setSensorAktorenKit(newKitForAndro9);
		SensorAktorenKit anotherKitForAndro9= new SensorAktorenKit_1kW();
		System.out.println("Step:   " + androidliste.find(9));
		anotherKitForAndro9.setSerienNummer(andro9.getSerienNummer());
		andro9.setSensorAktorenKit(anotherKitForAndro9);
		androidliste.insert(andro9);
		
		System.out.println("Later:  " + androidliste.find(9));
		//##################################################################################################################//
		//##################################################################################################################//
		//##################################################################################################################//
		
		System.out.println("############### -- Illegal cases -- #################");
		Skin andro13skin = new Skin_Gepanzert();
		Software andro13sw = new Software_Hilfskraft_Stufe1();
		SensorAktorenKit andro13kit = new SensorAktorenKit_Unlimited();
		Android andro13 = new Hilfskraft(13, andro13skin, andro13sw, andro13kit);
		System.out.println(andro13 + "-Android: adding wrong SensorAktorenKit and wrong Skin");
		System.out.println("Skin: " + andro13.getSkin() );
		System.out.println("Software: " + andro13.getSoftware() );
		System.out.println("Kit: " + andro13.getSensorenAktorenKit() );
		//##################################################################################################################//
		System.out.println("-----------------------");
		Skin andro14skin = new Skin_Hochfest();
		Software andro14sw = new Software_Hilfskraft_Stufe1();
		SensorAktorenKit andro14kit = new SensorAktorenKit_5kW();
		Android andro14 = new Bauarbeiter(14, andro14skin, andro14sw, andro14kit);
		System.out.println(andro14 + "-Android: adding wrong Software, Kit and correct Skin");
		System.out.println("Skin: " + andro14.getSkin() );
		System.out.println("Software: " + andro14.getSoftware() );
		System.out.println("Kit: " + andro14.getSensorenAktorenKit() );
		//##################################################################################################################//
		System.out.println("-----------------------");
		Skin andro15skin = new Skin_Beruehrungsintensiv();
		Software andro15sw = new Software_Leibwaechter_Stufe4();
		SensorAktorenKit andro15kit = new SensorAktorenKit_1kW();
		Android andro15 = new Kaempfer(15, andro15skin, andro15sw, andro15kit);
		System.out.println(andro15 + "-Android: all Parts wrong");
		System.out.println("Skin: " + andro15.getSkin() );
		System.out.println("Software: " + andro15.getSoftware() );
		System.out.println("Kit: " + andro15.getSensorenAktorenKit() );
		
		System.out.println("\n----------> Androids with null-values can't be added to the List!");
	}//Testcases

}
