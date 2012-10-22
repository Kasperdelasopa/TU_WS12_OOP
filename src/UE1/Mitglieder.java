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
		return mitglieder;
	}

	public List<Mitglied> getMitglieder(Date am) {

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
		Integer num = Mitglieder.getNextIndex();
		this.getMitglieder().add(new Mitglied(name, tele, instro, num));
		return num;
	}
	
	public Boolean addMitglied(Mitglied m) {
		if(m!=null){
				
			try {
				m.setAustritt(new SimpleDateFormat( "yyyyMMdd" ).parse( "99991231" ));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		
			this.getMitglieder().add(m);
			return true;
		}
		return false;
	}

	public Integer addMitglied(String name, String tele, String instro,
			Date eintritt, Date austritt) {
		
		Integer num =  Mitglieder.getNextIndex();
		this.getMitglieder().add(new Mitglied(name, tele, instro, num, eintritt, austritt));
		
		return num;
	}

	/**
	 * Markiert Mitlgied mit angegebener Nummer (ID) als ausgetreten.
	 * 
	 * @param num
	 *            Eindeutige Kennzahl des Mitglieds
	 * @param austritt
	 *            Zeitpunkt des Austritts
	 * @return Liefert true zurueck, wenn das Mitglied gefunden wurde. Sonst
	 *         false.
	 */
	public Boolean deleteMitglied(int num, Date austritt) {
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
		Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.DATE, -1);
		return deleteMitglied(num,cal.getTime());
	}
	/**
	 * Markiert ALLE Mitglieder mit ueberliefertem Namen als ausgetreten.
	 * 
	 * @param name
	 *            Mitglieder mit diesem Namen werden als ausgetreten markiert.
	 *            Alle uebereinstimmungen werden verarbeitet.
	 * @param austritt
	 *            Zeitpunkt des Austritts
	 * @return Liefert true zurueck, wenn zumindest eine uebereinstimmung gefunden
	 *         wurde.
	 */
	public Boolean deleteMitgliederByName(String name, Date austritt) {
		Boolean ret = false;

		// Speichern aller uebereinstimmungen in tmp
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
		
		Mitglied ret = null;
		for(Mitglied m : mitglieder){
			if(m.getNummer() == id)
				return m;
		}
		
		return ret;
	}
	
	public Mitglied getMitgliedByName(String name){
		for(Mitglied m : this.getMitglieder()){
			if(m.getName().equals(name))
				return m;
		}
		return null;
	}

	public String toString(){
		String ret = "Mitlieder:";
		for(Mitglied m : this.getMitglieder(new Date())){
			ret += "\n"+m.toString();
		}
		return ret;
	}
}
