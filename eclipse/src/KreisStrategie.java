
public class KreisStrategie implements Strategie {
	private int laenge;
	
	public KreisStrategie(Rennstrecke strecke, Auto auto){
		Fahrtrichtung richtung = auto.getRichtung();
		Feld current=auto.getCurrentField();
		laenge=0;
		
		if(richtung==Fahrtrichtung.Nord){
			while(current!=null){			
				current=current.Nord;
				laenge++;
			}
		}
		if(richtung==Fahrtrichtung.Sued){
			while(current!=null){			
				current=current.Sued;
				laenge++;
			}		
		}
		if(richtung==Fahrtrichtung.Ost){
			while(current!=null){			
				current=current.Ost;
				laenge++;
			}
		}
		if(richtung==Fahrtrichtung.West){
			while(current!=null){			
				current=current.West;
				laenge++;
			}
		}
		
		laenge = (int) (Math.random()*laenge+1);
		//jedes auto hat eine andere kreisgroesse
		
		//TODO - Algorithmus fuer KreisStrategie
		
		
	}
	
	public Feld getNextField(BeweglichesAuto auto){
		Fahrtrichtung richtung = auto.getRichtung();
		
		return auto.getCurrentField();
	}
	public Feld getNextField(SchnellesAuto auto){
		return auto.getCurrentField();
	}
}
