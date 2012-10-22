package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mitglieder {

	private ArrayList<Mitglied> mitglieder;
	private static Integer  biggestIndex = 0;

	public Mitglieder() {
		mitglieder = new ArrayList<Mitglied>();
	}

	public static Integer getNextIndex(){
		return biggestIndex++;
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

	public Mitglied getMitgliedByName(String name){
		for(Mitglied m : this.getMitglieder()){
			if(m.getName().equals(name))
				return m;
		}
		return null;
	}
	
	public Integer addMitglied(String name, String tele, String instro) {
		Integer num = Mitglieder.getNextIndex();
		mitglieder
				.add(new Mitglied(name, tele, instro, num));
		return num;
	}
	
	public void addMitglied(Mitglied m) {
		mitglieder.add(m);
	}

	public Integer addMitglied(String name, String tele, String instro,
			Date eintritt, Date austritt) {
		
		Integer num =  Mitglieder.getNextIndex();
		mitglieder.add(new Mitglied(name, tele, instro, num, eintritt, austritt));
		
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
		Boolean ret = false;

		// Speichern aller uebereinstimmungen in tmp
		ArrayList<Mitglied> tmp = new ArrayList<Mitglied>();

		for (Mitglied m : getMitglieder()) {
			if (m.getNummer() == num) {
				tmp.add(m);
				ret = true;
			}
		}

		for (int i = 0; i < tmp.size(); i++) {
			tmp.get(i).setAustritt(austritt);
		}

		return ret;

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
			tmp.get(i).setAustritt(austritt);
		}

		return ret;
	}

	private int findBiggestNumber() {

		int biggest = 0;

		for (Mitglied m : getMitglieder()) {

			if (m.getNummer() > biggest)
				biggest = m.getNummer();
		}

		return biggest;
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

	public String toString(){
		String ret = "Mitlieder:";
		for(Mitglied m : this.getMitglieder()){
			ret += "\n"+m.toString();
		}
		return ret;
	}
}
