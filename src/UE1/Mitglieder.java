package UE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mitglieder {

	private ArrayList<Mitglied> mitglieder;

	public Mitglieder() {
		mitglieder = new ArrayList<Mitglied>();
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

	public void addMitglied(String name, String tele, String instro) {
		mitglieder
				.add(new Mitglied(name, tele, instro, findBiggestNumber() + 1));
	}
	
	public void addMitglied(Mitglied m) {
		mitglieder.add(m);
	}

	public void addMitglied(String name, String tele, String instro,
			Date eintritt, Date austritt) {
		mitglieder.add(new Mitglied(name, tele, instro,
				findBiggestNumber() + 1, eintritt, austritt));
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
	

}
