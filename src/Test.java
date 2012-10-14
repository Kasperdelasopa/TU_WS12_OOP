import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import UE1.*;

/**
 * Einfache Test-Applikation.
 * 
 * @author Peter Nirschl
 */
public class Test {

	private static final String UE1_Name = "Die Zahnärzte";
	private static final String UE1_Ausrichtung = "Alternativer Mainstream-Metal-Hardcore-Punkrock";

	/**
	 * Programmeinstiegspunkt Testet die Grundfunktionalität der Applikation und
	 * gibt die Ergebnisse auf den Standard-Output aus.
	 * 
	 * Please forgive me for writing spagetti-style. I was going for Junit...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Musikgruppe gruppe; // Unsere Testgruppe
		double summe_gage = 0.0; // Kontrollwert (hinzugefügte Gagen kumuliert)
		double summe_miete = 0.0; // Kontrollwert (hinzugefügte Mieten
									// kumuliert)
		Date datum_von; // Kontrollwert Zeitraum von
		Date datum_bis; // Kontrollwert Zeitraum bis

		// Initialization - Kontrollzeitraum festlegen
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			datum_von = sdf.parse("2012-10-01");
			datum_bis = sdf.parse("2012-10-30");
		} catch (ParseException e1) {
			e1.printStackTrace();
			return;
		}

		// Testfall 1
		writeTestCaseInfo(1,
				"Erstellen einer Musikgruppe per Konstruktoraufruf");
		try {
			gruppe = new Musikgruppe(UE1_Ausrichtung, UE1_Name);
			writeTestCaseResult(true);
		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			gruppe = null;
			return;
		}

		// Testfall 2
		writeTestCaseInfo(2, "Prüfen der Attribute der Musikgruppe");
		if (gruppe.getName() != UE1_Name) {
			writeTestCaseResult(false);
			return;
		}
		if (gruppe.getAusrichtung() != UE1_Ausrichtung) {
			writeTestCaseResult(false);
			return;
		}
		writeTestCaseResult(true);

		// Testfall 3
		writeTestCaseInfo(3,
				"Anlegen einer Probe und eines Auftritts und anschließende Auflistung.");

		try {
			Probe probe = new Probe(250.0, "Maria Enzersdorf",
					sdf.parse("2013-11-02"), 60);
			gruppe.getProben().addProbe(probe);
			gruppe.getProben().addProbe(200.0, "Wien", sdf.parse("2012-10-02"),
					30);
			summe_miete += 200.0;

			gruppe.getAuftritte().addAuftritt(4500.0, "Wien",
					sdf.parse("2012-10-05"), 10);
			summe_gage += 4500.0;

			// Proben auflisten
			System.out.println("* Auflistung der Proben");
			List<Probe> proben = gruppe.getProben().getProben(datum_von,
					datum_bis);
			for (Probe p : proben) {
				System.out.println(p.toString());
			}

			// Auftritte auflisten
			System.out.println("* Auflistung der Auftritte");
			List<Auftritt> auftritte = gruppe.getAuftritte().getAuftritte(
					datum_von, datum_bis);
			for (Auftritt a : auftritte) {
				System.out.println(a.toString());
			}

			// Alles auflisten
			System.out.println("* Alles auflisten");
			List<Ereignis> ereignisse = gruppe.getProben_Auftritte(datum_von,
					datum_bis);
			for (Ereignis e : ereignisse) {
				System.out.println(e.toString());
			}

			writeTestCaseResult(true);
		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}

		// Testfall 4
		writeTestCaseInfo(4, "Abfragen der Summen (Gage, Miete, Gesamttotal");
		System.out.print("Summe Gage (Auftritte): ");
		System.out.println(gruppe.getGewinn_Auftritte(datum_von, datum_bis));
		System.out.print("Summe Miete (Proben): ");
		System.out.println(gruppe.getKosten_Proben(datum_von, datum_bis));
		System.out.print("Total: ");
		System.out.println(gruppe.getGage_minus_Miete(datum_von, datum_bis));

		if (gruppe.getGewinn_Auftritte(datum_von, datum_bis) != summe_gage
				|| gruppe.getKosten_Proben(datum_von, datum_bis) != summe_miete
				|| gruppe.getGage_minus_Miete(datum_von, datum_bis) != (summe_gage - summe_miete)) {
			writeTestCaseResult(false);
			return;
		}
		writeTestCaseResult(true);

		// Testfall 5
		writeTestCaseInfo(5,
				"Prüfen der Mitgliederverwaltung - Hinzufügen, Entfernen, Auflisten");
		try {
			gruppe.getMitglieder().addMitglied("Gandalf", "0180666666",
					"Klarinette");
			gruppe.getMitglieder().addMitglied("Frodo", "019012345678",
					"Vocals", sdf.parse("2010-02-01"), sdf.parse("2015-04-01"));
			gruppe.getMitglieder().deleteMitgliederByName("Gandalf",
					sdf.parse("2005-01-07"));

			for (Mitglied m : gruppe.getMitglieder().getMitglieder()) {
				System.out.println(m);
			}
		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);

		// Testfall 6
		writeTestCaseInfo(6,
				"Prüfen der Mitgliederverwaltung - Abfrage auf Zeitpunkt");
		try {
			for (Mitglied m : gruppe.getMitglieder().getMitglieder(
					sdf.parse("2012-10-01"))) {
				System.out.println(m);
			}
		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);

		// Testcase 7
		writeTestCaseInfo(7, "Reportoire - Hinzufügen, Entfernen, Auflisten");
		try {
			gruppe.getRepertoire().addMusikstueck("Das Leben von Schrödingers Katze", 3.5, sdf.parse("1984-01-01"));
			gruppe.getRepertoire().addMusikstueck("Quadrate im Kreis", 2.4);
			gruppe.getRepertoire().addMusikstueck("Intro vor dem Anfang", 1.4);
			
			gruppe.getRepertoire().deleteMusikstueck("Quadrate im Kreis", sdf.parse("2014-01-01"));
			
			System.out.println("* Auflistung aller Musikstücke");
			for(Musikstueck m : gruppe.getRepertoire().getRepertoire()) {
				System.out.println(m.toString());
			}
			
			System.out.println("* Auflistung nach Zeitpunkt");
			for(Musikstueck m : gruppe.getRepertoire().getRepertoire(sdf.parse("2012-10-01"))) {
				System.out.println(m.toString());
			}

		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);
	}

	/**
	 * Schreibt Informationen zu einem Testfall auf die Standard-Ausgabe.
	 * 
	 * @param number
	 *            Nummer des Testfalls
	 * @param description
	 *            Beschreibung des Testfalls
	 */
	private static void writeTestCaseInfo(int number, String description) {
		System.out.print("***** Testfall ");
		System.out.println(number);
		System.out.println(description);
	}

	/**
	 * Schreibt das Ergebnis zu einem Testfall auf die Standard-Ausgabe.
	 * 
	 * @param sucecss
	 *            Wahr, wenn der Testfall erfolgreich abgeschlossen wurde.
	 */
	private static void writeTestCaseResult(boolean sucecss) {
		if (sucecss) {
			System.out.println("[OK]");
		} else {
			System.out.println("[Fehler]");
		}
		System.out.println();
	}
}
