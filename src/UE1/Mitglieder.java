package UE1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Mitglieder extends Personen {

	List<Mitglied> mitglieder = new ArrayList<Mitglied>();
	private Ersatzmitglieder ersatz;
	private Besetzung besetzung;
	
	public Mitglieder(Ersatzmitglieder ersatz, Besetzung besetzung ) {
		mitglieder = new ArrayList<Mitglied>();
		
		this.besetzung = besetzung;
		this.ersatz = ersatz;
		
	}


	public List<Mitglied> getMitglieder() {
		//Methode gibt die Liste der aktuellen Mitglieder zurück
		return mitglieder;
	}

	public List<Mitglied> getMitglieder(Date am) {
		//Methode gibt die Liste der Mitglieder zu einem bestimmen Stichtag zurück
		//FEHLER: kein Test ob am < 31.12.9999
		List<Mitglied> tmp = new ArrayList<Mitglied>();

		for (Mitglied e : getMitglieder()) {

			Date dvon = e.getEintritt();
			Date dbis = e.getAustritt();
			if ((dvon.before(am) && dbis.after(am)) || dvon.equals(am)
					|| dbis.equals(am)) {
				tmp.add(e);
			}
		}

		return tmp;
	}


	public Integer addMitglied(String name, String tele, String instro) {
		//Methode erzeugt neues Mitglied und fügt dieses in die Liste ein
		Integer num = Mitglieder.getNextIndex();
		this.getMitglieder().add(new Mitglied(name, tele, instro, num));
		return num;
	}
	
	public Boolean addMitglied(Mitglied m) {
		//Methode füght neues Mitglied in die Liste ein
		//FEHLER: kein Test ob Mitglied bereits vorhanden
		if(m!=null){
				
			try {
				m.setAustritt(new SimpleDateFormat( "yyyyMMdd" ).parse( "99991231" ));
			} catch (ParseException e) {
				e.printStackTrace();
				
			}
		
			this.getMitglieder().add(m);
			return true;
		}
		return false;
	}
	
	public Integer addMitglied(String name, String tele, String instro,
			Date eintritt, Date austritt) {
		//Methode erzeugt ein neues Mitglied, setzt eintritt u. austritt und fügt es in die Liste ein
		Integer num =  Mitglieder.getNextIndex();
		this.getMitglieder().add(new Mitglied(name, tele, instro, num, eintritt, austritt));
		
		return num;
	}

	
	public Boolean deleteMitglied(int num, Date austritt) {
		//Methode löscht ein Element aus der Liste  anhand der ID wenn vorhanden und schreibt das Austrittsdatum
		for (Mitglied m : getMitglieder()) {
			if (m.getNummer() == num) {
				m.setAustritt(austritt);
				
				besetzung.deleteMitglied(m.getNummer());
				ersatz.deleteMitglied(m.getNummer());
				return true;
			}
		}
		
		return false;

	}
	
	public Boolean deleteMitglied(int num) {
		//Methode löscht ein Element aus der Liste anhand der ID wenn vorhanden
		Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.DATE, -1);
		return deleteMitglied(num,cal.getTime());
	}

	
	public Boolean deleteMitgliederByName(String name, Date austritt) {
		//Methode löscht ein Element aus der Liste anhand des Namens wenn vorhanden und setzt das Asutrittsdatum
		Boolean ret = false;

		ArrayList<Mitglied> tmp = new ArrayList<Mitglied>();

		for (Mitglied m : getMitglieder()) {
			if (m.getName().equals(name)) {
				tmp.add(m);
				ret = true;
			}
		}

		for (int i = 0; i < tmp.size(); i++) {
			deleteMitglied(tmp.get(i).getNummer(),austritt);
			besetzung.deleteMitglied(tmp.get(i).getNummer());
			ersatz.deleteMitglied(tmp.get(i).getNummer());
		}

		return ret;
	}

	
	public Repertoire gemeinsamesRepertoire(){
		//Methode gibt die Schnittmenge der Repertoires der Mitglieder zurück
		//Nur die Musikstücke die jedes Mitglied im Repertoire hat werden zurückgegeben
		Repertoire ret = new Repertoire();
		List<Musikstueck> t_rep = new  ArrayList<Musikstueck>();
		List<Mitglied> t_mitg = getMitglieder(new Date());
		
		if(getMitglieder().size() > 0){
			t_rep = t_mitg.get(0).getRepertoire().getRepertoire();
			
			for(int i = 1; i<t_mitg.size(); i++){
				if(!t_mitg.get(i).equals(null)){						
						t_rep.retainAll(t_mitg.get(i).getRepertoire().getRepertoire());						
				}
				else
					break;
			}
		}
		
		ret.getRepertoire().addAll(t_rep);
		return ret;
		
	}
	
	public Mitglied getMitglied(int id){
		//Methode liefert ein Mitglied anhand der ID, wenn diese vorhanden
		Mitglied ret = null;
		for(Mitglied m : mitglieder){
			if(m.getNummer() == id)
				return m;
		}
		
		return ret;
	}
	
	public Mitglied getMitgliedByName(String name){
		//Methode liefert ein Mitglied anhand des Namens, wenn dieser vorhanden
		for(Mitglied m : this.getMitglieder()){
			if(m.getName().equals(name))
				return m;
		}
		return null;
	}

	public String toString(){
		//liefert Informationen über die Mitglieder
		String ret = "Mitlieder:";
		for(Mitglied m : this.getMitglieder(new Date())){
			ret += "\n"+m.toString();
		}
		return ret;
	}
}
