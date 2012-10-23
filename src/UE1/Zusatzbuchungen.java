package UE1;

import java.util.ArrayList;
import java.util.Collection;

public class Zusatzbuchungen {

	ArrayList<Zusatzbuchung> buchungen;
	
	public Zusatzbuchungen() {
		buchungen = new ArrayList<Zusatzbuchung>();
	}
	
	public Collection<Zusatzbuchung> getZusatzkosten() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for(Zusatzbuchung b : buchungen) {
			if(b.getBetrag() > 0.0) {
				result.add(b);
			}
		}
		return result;
	}
	
	public Collection<Zusatzbuchung> getZusatzertraege() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for(Zusatzbuchung b : buchungen) {
			if(b.getBetrag() < 0.0) {
				result.add(b);
			}
		}
		return result;
	}
	
	public Collection<Zusatzbuchung> getNullBuchungen() {
		ArrayList<Zusatzbuchung> result = new ArrayList<Zusatzbuchung>();
		for(Zusatzbuchung b : buchungen) {
			if(b.getBetrag() == 0.0) {
				result.add(b);
			}
		}
		return result;
	}
	
	public void addBuchung(Zusatzbuchung buchung) {
		buchungen.add(buchung);
	}
	
}
