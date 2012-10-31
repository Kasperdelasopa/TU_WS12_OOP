
// Ein grundsaetzlicher Fehler in unserer Anwendung ist die Vermischung von Datentransferobjekten (DTO) mit Business-Logk, 
// die als eigene Service-Schicht haette implementiert werden sollen.
// Trotzdem ist in einigen Objekten der Klassenzusammenhang hoch geworden.
// Die Wartbarkeit ist bei alen Objekten gegeben, daher bewerten wir die Objekt-Kopplung im Allgemeinen als 
// mittelmaessig bis schwach.

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import UE1.*;


public class Test {

	private static final String UE1_Name = "Die Zahnaerzte";
	private static final String UE1_Ausrichtung = "Alternativer Mainstream-Metal-Hardcore-Punkrock";


	public static void main(String[] args) {

		Musikgruppe gruppe; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		

		
		Ort ortWien = new Ort();
		ortWien.setName("Wien");
		ortWien.setAddress("An der schönen blauen Donau");
		ortWien.setCountry("AUT");

		ArrayList<String> infrastructure1 = new ArrayList<String>();
		infrastructure1.add("Beleuchtung");
		infrastructure1.add("Mikrofon");
		ortWien.getInfrastructure().addAll(infrastructure1);

		Ort ortGraz = new Ort();
		ortGraz.setName("Graz");
		ortGraz.setAddress("An der grossen Uhr");
		ortGraz.setCountry("AUT");

		ArrayList<String> infrastructure2 = new ArrayList<String>();
		infrastructure1.add("Beleuchtung");
		infrastructure1.add("Verstaerker");
		ortGraz.getInfrastructure().addAll(infrastructure2);


		try {
			gruppe = new Musikgruppe(UE1_Ausrichtung, UE1_Name);
			gruppe.getRepertoire().addMusikstueck(
					"Das Leben von Schroedingers Katze", 3.5);
			gruppe.getRepertoire().addMusikstueck("Quadrate im Kreis", 2.4);
			gruppe.getRepertoire().addMusikstueck("Intro vor dem Anfang", 1.4);

			
			gruppe.getOrte().getOrte().add(ortWien);
			gruppe.getOrte().getOrte().add(ortGraz);

			Integer tmp;
			
			tmp = gruppe.getMitglieder().addMitglied("Gandalf", "0180666666",
					"Klarinette");
            //BAD tief verschachtelte Methoden-Aufrufe
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Quadrate im Kreis"));
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Intro vor dem Anfang"));
			gruppe.getBesetzung().addMitglied(
					gruppe.getMitglieder().getMitglied(tmp));

			tmp = gruppe.getMitglieder().addMitglied("Frodo", "019012345678",
					"Vocals");
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Quadrate im Kreis"));
			gruppe.getBesetzung().addMitglied(
					gruppe.getMitglieder().getMitglied(tmp));

			tmp = gruppe.getMitglieder().addMitglied("Smiagol", "019012345678",
					"Vocals");
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Intro vor dem Anfang"));
			gruppe.getBesetzung().addMitglied(
					gruppe.getMitglieder().getMitglied(tmp));

			
			tmp = gruppe.getMitglieder().addMitglied("Gandalf2", "0180666666",
					"Klarinette");
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Quadrate im Kreis"));
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Intro vor dem Anfang"));
			gruppe.getErsatzmitglieder().addMitglied(
					gruppe.getMitglieder().getMitglied(tmp));

			tmp = gruppe.getMitglieder().addMitglied("Frodo2", "019012345678",
					"Vocals");
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Quadrate im Kreis"));
			gruppe.getErsatzmitglieder().addMitglied(
					gruppe.getMitglieder().getMitglied(tmp));

			tmp = gruppe.getMitglieder().addMitglied("Smiagol2",
					"019012345678", "Vocals");
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder()
					.getMitglied(tmp)
					.getRepertoire()
					.addMusikstueck(
							gruppe.getRepertoire().getMusikstueckByName(
									"Intro vor dem Anfang"));
			gruppe.getErsatzmitglieder().addMitglied(
					gruppe.getMitglieder().getMitglied(tmp));

			
			Besetzung m_probe = new Besetzung();
			m_probe.getMitglieder().addAll(
					gruppe.getBesetzung().getMitglieder());
			m_probe.addMitglied(gruppe.getErsatzmitglieder().getMitgliedByName(
					"Gandalf2"));
			m_probe.addMitglied(gruppe.getErsatzmitglieder().getMitgliedByName(
					"Frodo2"));

			gruppe.getEreignisse().addProbe(55, ortWien,
					sdf.parse("2012-10-15"), 45, m_probe);
			gruppe.getEreignisse().addProbe(55, ortWien,
					sdf.parse("2012-10-16"), 45, m_probe);
			gruppe.getEreignisse().addProbe(55, ortGraz,
					sdf.parse("2012-10-18"), 45, m_probe);
			gruppe.getEreignisse().addProbe(55, ortGraz,
					sdf.parse("2012-10-20"), 45, m_probe);

		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}

		
		writeTestCaseInfo(1, "Reportoire pro Mitglied");
		try {

			for (Mitglied m : gruppe.getMitglieder().getMitglieder(new Date())) {
				System.out.println(m.toString() + ":");
				System.out.println(m.getRepertoire().toString());
			}

		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);

		
		writeTestCaseInfo(2, "Reportoire der Gruppe");
		try {

			System.out.println(gruppe.getMitglieder().gemeinsamesRepertoire()
					.toString());

		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);

		
		writeTestCaseInfo(3,
				"ein Staendiges Mitglied mit Ersatzmitglied tauschen");
		try {
			System.out.println("Vor dem Tausch Besetzung:");
			System.out.println(gruppe.getBesetzung().toString());
			System.out.println("Vor dem Tausch Ersatzmitglieder:");
			System.out.println(gruppe.getErsatzmitglieder().toString());

			System.out.println("tausche Gandalf mit Gandalf2...");
			if (!gruppe.verschiebe(gruppe.getErsatzmitglieder()
					.getMitgliedByName("Gandalf2").getNummer(), gruppe
					.getBesetzung().getMitgliedByName("Gandalf").getNummer()))
				throw new Exception("Mitglied existiert nicht");
			System.out.println("Nach dem Tausch Besetzung:");
			System.out.println(gruppe.getBesetzung().toString());
			System.out.println("Nach dem Tausch Ersatzmitglieder:");
			System.out.println(gruppe.getErsatzmitglieder().toString());

		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);

		writeTestCaseInfo(4,
				"Mitglied tauschen das an zu wenigen Proben teilgenommen hat");
		try {

			if (!gruppe.verschiebe(gruppe.getErsatzmitglieder()
					.getMitgliedByName("Smiagol2").getNummer(), gruppe
					.getBesetzung().getMitgliedByName("Gandalf2").getNummer()))
				throw new Exception("Mitglied existiert nicht");

		} catch (GesperrtException e) {
			writeTestCaseResult(true);
			e.printStackTrace(System.out);
			
		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}

		
		writeTestCaseInfo(5, "Ereignisse hinzufuegen");
		try {

			Besetzung m_probe = new Besetzung();
			m_probe.getMitglieder().addAll(
					gruppe.getMitglieder().getMitglieder());

			Ereignisse ereignisse = new Ereignisse();
			ereignisse.addAuftritt(100, ortWien, sdf.parse("2015-01-01"), 40,
					m_probe);
			ereignisse.addAuftritt(200, ortWien, sdf.parse("2014-01-01"), 50,
					m_probe);
			ereignisse.addAuftritt(300, ortWien, sdf.parse("2003-01-01"), 60,
					m_probe);
			ereignisse.addAuftritt(400, ortWien, sdf.parse("2000-01-01"), 70,
					m_probe);
			ereignisse.addProbe(100, ortGraz, sdf.parse("2013-10-15"), 50,
					m_probe);
			ereignisse.addProbe(200, ortGraz, sdf.parse("2014-10-15"), 40,
					m_probe);
			ereignisse.addProbe(300, ortGraz, sdf.parse("2015-10-15"), 30,
					m_probe);
			ereignisse.addProbe(400, ortGraz, sdf.parse("2002-10-15"), 20,
					m_probe);

			writeTestCaseInfo(5, "Manuelle Bestaetigung");
			ereignisse.getEreignisse().get(0).setBestaetigt(true);
			ereignisse.getEreignisse().get(1).setBestaetigt(true);
			ereignisse.getEreignisse().get(2).setBestaetigt(true);
			ereignisse.getEreignisse().get(3).setBestaetigt(true);
			ereignisse.getEreignisse().get(4).setBestaetigt(true);
			ereignisse.getEreignisse().get(5).setBestaetigt(true);

			writeTestCaseInfo(5, "Ereignisse ausgeben");

			System.out.println("###Auftritte:");
			System.out.println(ereignisse.getAuftritte());
			System.out.println("###Proben:");
			System.out.println(ereignisse.getProben());
			System.out.println("###Zukuenftige:");
			System.out.println(ereignisse.getZukuenftige());
			System.out.println("###Vergangene:");
			System.out.println(ereignisse.getVergangene());

			writeTestCaseInfo(5, "Loeschen");

			System.out.println("------VORHER--------");
			System.out.println(ereignisse.toString());

			ereignisse.delAuftritt(4);
			ereignisse.delProbe(9);
			ereignisse.delEreignis(5);
			System.out.println("------NACHHER--------");
			System.out.println(ereignisse.toString());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ereignis nicht gefunden!");
		}

		catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);

		
		writeTestCaseInfo(6, "Orteverwaltung - Suche nach Infrastruktur");
		boolean tc6_result = true;
		Collection<Ort> tc6_Orte = gruppe.getOrte().findOrteByInfrastructure(
				"Mikrofon");
		for (Ort tc6_Ort : tc6_Orte) {
			if (!tc6_Ort.equals(ortWien)) {
				tc6_result = false;
			}
			System.out.println(tc6_Ort.toString());
		}
		writeTestCaseResult(tc6_result);

		
		writeTestCaseInfo(7, "Zusatzkosten und Ertraege - Hinzufuegen");
		try {
			Zusatzbuchung buchung1 = new Zusatzbuchung(sdf.parse("2012-10-10"),
					100.0, "Spende");
			Zusatzbuchung buchung2 = new Zusatzbuchung(sdf.parse("2012-10-10"),
					-50.0, "Strafzettel");

			gruppe.getEreignisse().addZusatzbuchung(buchung1);
			gruppe.getEreignisse().addZusatzbuchung(buchung2);

			for (Zusatzbuchung z1 : gruppe.getEreignisse().getZusatzkosten()) {
				System.out.println(z1.toString());
			}
			for (Zusatzbuchung z1 : gruppe.getEreignisse().getZusatzertraege()) {
				System.out.println(z1.toString());
			}

		} catch (java.text.ParseException e) {
			writeTestCaseResult(false);
			e.printStackTrace();
		}

	}


	private static void writeTestCaseInfo(int number, String description) {
		System.out.print("***** Testfall ");
		System.out.println(number);
		System.out.println(description);
	}

	private static void writeTestCaseResult(boolean sucecss) {
		if (sucecss) {
			System.out.println("[OK]");
		} else {
			System.out.println("[Fehler]");
		}
		System.out.println();
	}
}
