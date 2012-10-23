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
    
	private static final String UE1_Name = "Die Zahnaerzte";
	private static final String UE1_Ausrichtung = "Alternativer Mainstream-Metal-Hardcore-Punkrock";
    
	/**
	 * Programmeinstiegspunkt Testet die Grundfunktionalitaet der Applikation und
	 * gibt die Ergebnisse auf den Standard-Output aus.
	 * 
	 * Please forgive me for writing spagetti-style. I was going for Junit...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        
		Musikgruppe gruppe; // Unsere Testgruppe
		double summe_gage = 0.0; // Kontrollwert (hinzugefuegte Gagen kumuliert)
		double summe_miete = 0.0; // Kontrollwert (hinzugefuegte Mieten
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
        
		/*// Testfall 1
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
         writeTestCaseInfo(2, "Pruefen der Attribute der Musikgruppe");
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
         "Anlegen einer Probe und eines Auftritts und anschliessende Auflistung.");
         
         try {
         Probe probe = new Probe(250.0, "Maria Enzersdorf",
         sdf.parse("2013-11-02"), 60, gruppe.getMitglieder());
         gruppe.getProben().addProbe(probe);
         gruppe.getProben().addProbe(200.0, "Wien", sdf.parse("2012-10-02"),
         30, gruppe.getMitglieder());
         summe_miete += 200.0;
         
         gruppe.getAuftritte().addAuftritt(4500.0, "Wien",
         sdf.parse("2012-10-05"), 10,gruppe.getMitglieder());
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
         "Pruefen der Mitgliederverwaltung - Hinzufuegen, Entfernen, Auflisten");
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
         "Pruefen der Mitgliederverwaltung - Abfrage auf Zeitpunkt");
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
         writeTestCaseInfo(7, "Reportoire - Hinzufuegen, Entfernen, Auflisten");
         try {
         gruppe.getRepertoire().addMusikstueck("Das Leben von Schroedingers Katze", 3.5, sdf.parse("1984-01-01"));
         gruppe.getRepertoire().addMusikstueck("Quadrate im Kreis", 2.4);
         gruppe.getRepertoire().addMusikstueck("Intro vor dem Anfang", 1.4);
         
         gruppe.getRepertoire().deleteMusikstueck("Quadrate im Kreis", sdf.parse("2014-01-01"));
         
         System.out.println("* Auflistung aller Musikstuecke");
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
         
         */	
		//�bung 2
		
		//init
		try {
			gruppe = new Musikgruppe(UE1_Ausrichtung, UE1_Name);
			gruppe.getRepertoire().addMusikstueck("Das Leben von Schroedingers Katze", 3.5);
			gruppe.getRepertoire().addMusikstueck("Quadrate im Kreis", 2.4);
			gruppe.getRepertoire().addMusikstueck("Intro vor dem Anfang", 1.4);				
			
			Integer tmp;
			//Mitglieder hinzuf�gen
			tmp = gruppe.getMitglieder().addMitglied("Gandalf", "0180666666","Klarinette");
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Quadrate im Kreis"));	
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Intro vor dem Anfang"));	
			gruppe.getBesetzung().addMitglied(gruppe.getMitglieder().getMitglied(tmp));
			
			tmp = gruppe.getMitglieder().addMitglied("Frodo", "019012345678","Vocals");
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Quadrate im Kreis"));	
			gruppe.getBesetzung().addMitglied(gruppe.getMitglieder().getMitglied(tmp));
			
			tmp = gruppe.getMitglieder().addMitglied("Smiagol", "019012345678","Vocals");
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Intro vor dem Anfang"));	
			gruppe.getBesetzung().addMitglied(gruppe.getMitglieder().getMitglied(tmp));
			
			//Ersatzmitglieder hinzuf�gen
			tmp = gruppe.getMitglieder().addMitglied("Gandalf2", "0180666666","Klarinette");
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Quadrate im Kreis"));	
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Intro vor dem Anfang"));
			gruppe.getErsatzmitglieder().addMitglied(gruppe.getMitglieder().getMitglied(tmp));
			
			
			tmp = gruppe.getMitglieder().addMitglied("Frodo2", "019012345678","Vocals");
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Quadrate im Kreis"));
			gruppe.getErsatzmitglieder().addMitglied(gruppe.getMitglieder().getMitglied(tmp));
			
			tmp = gruppe.getMitglieder().addMitglied("Smiagol2", "019012345678","Vocals");
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Das Leben von Schroedingers Katze"));
			gruppe.getMitglieder().getMitglied(tmp).getRepertoire().addMusikstueck(
                                                                                   gruppe.getRepertoire().getMusikstueckByName("Intro vor dem Anfang"));
			gruppe.getErsatzmitglieder().addMitglied(gruppe.getMitglieder().getMitglied(tmp));
			
			//Zusammensetzung f�r Probe (alle Mitlgieder + Ersatzmitglieder aber ohne Smiagol2)
			Besetzung m_probe = new Besetzung();
			m_probe.getMitglieder().addAll(gruppe.getBesetzung().getMitglieder());
			m_probe.addMitglied(gruppe.getErsatzmitglieder().getMitgliedByName("Gandalf2"));
			m_probe.addMitglied(gruppe.getErsatzmitglieder().getMitgliedByName("Frodo2"));
			
			gruppe.getEreignisse().addProbe(55, "Probeplatz", sdf.parse("2012-10-15"), 45, m_probe);
			gruppe.getEreignisse().addProbe(55, "Probeplatz", sdf.parse("2012-10-16"), 45, m_probe);
			gruppe.getEreignisse().addProbe(55, "Probeplatz", sdf.parse("2012-10-18"), 45, m_probe);
			gruppe.getEreignisse().addProbe(55, "Probeplatz", sdf.parse("2012-10-20"), 45, m_probe);
			
			
            
		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		
		// Testcase 2_1
		writeTestCaseInfo(1, "Reportoire pro Mitglied");
		try {
			
			for(Mitglied m : gruppe.getMitglieder().getMitglieder(new Date())){
				System.out.println(m.toString() + ":");
				System.out.println(m.getRepertoire().toString());			
			}
            
		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);
		
		// Testcase 2_2
		writeTestCaseInfo(2, "Reportoire der Gruppe");
		try {
			
			System.out.println(gruppe.getMitglieder().gemeinsamesRepertoire().toString());
            
		} catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
		writeTestCaseResult(true);
		
		// Testcase 2_2
		writeTestCaseInfo(3, "ein Staendiges Mitglied mit Ersatzmitglied tauschen");
		try {
			System.out.println("Vor dem Tausch Besetzung:");
			System.out.println(gruppe.getBesetzung().toString());
			System.out.println("Vor dem Tausch Ersatzmitglieder:");
			System.out.println(gruppe.getErsatzmitglieder().toString());
			
			System.out.println("tausche Gandalf mit Gandalf2...");
			if(!gruppe.verschiebe(gruppe.getErsatzmitglieder().getMitgliedByName("Gandalf2").getNummer(), gruppe.getBesetzung().getMitgliedByName("Gandalf").getNummer()))
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
		
		writeTestCaseInfo(4, "Mitglied tauschen das an zu wenigen Proben teilgenommen hat");
		try {

			if(!gruppe.verschiebe(gruppe.getErsatzmitglieder().getMitgliedByName("Smiagol2").getNummer(), gruppe.getBesetzung().getMitgliedByName("Gandalf2").getNummer()))
				throw new Exception("Mitglied existiert nicht");

            
		} 
		catch (GesperrtException e) {
			writeTestCaseResult(true);
			e.printStackTrace(System.out);
			//return;
		}
		catch (Exception e) {
			writeTestCaseResult(false);
			e.printStackTrace(System.out);
			return;
		}
        
        
        
        
        
        //#########EREIGNISSE###### 
		writeTestCaseInfo(5, "Ereignisse hinzufuegen");
		try {
            
            Besetzung m_probe = new Besetzung();
            m_probe.getMitglieder().addAll(gruppe.getMitglieder().getMitglieder());
			
			
            Ereignisse ereignisse = new Ereignisse();
            ereignisse.addAuftritt(100, "Auftritt1", sdf.parse("2015-01-01"), 40, m_probe);
            ereignisse.addAuftritt(200, "Auftritt2", sdf.parse("2014-01-01"), 50, m_probe);
            ereignisse.addAuftritt(300, "Auftritt3", sdf.parse("2003-01-01"), 60, m_probe);
            ereignisse.addAuftritt(400, "Auftritt4", sdf.parse("2000-01-01"), 70, m_probe);
            ereignisse.addProbe(100, "Wienprobe", sdf.parse("2013-10-15"), 50, m_probe);
            ereignisse.addProbe(200, "Wienprobe2", sdf.parse("2014-10-15"), 40, m_probe);
            ereignisse.addProbe(300, "Wienprobe3", sdf.parse("2015-10-15"), 30, m_probe);
            ereignisse.addProbe(400, "Wienprobe4", sdf.parse("2002-10-15"), 20, m_probe);

			
            
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
            
            
            
            
        } 
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ereignis nicht gefunden!");
        }
        
        catch (Exception e) {
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
