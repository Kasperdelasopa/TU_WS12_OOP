

public class RandomStrategie implements Strategie {
	
	public RandomStrategie(){
	}
	
	public Feld getNextField(BeweglichesAuto auto){
		Fahrtrichtung richtung= auto.getRichtung();
		Feld currentpos = auto.getCurrentField();
		
		int i = (int) (Math.random()*3+1);
		if(richtung == Fahrtrichtung.Nord){
			switch(i){
			case 1: if(currentpos.West!=null) return currentpos.West; else return currentpos.Ost;
			case 2: if(currentpos.Nord!=null) return currentpos.Nord; else if(currentpos.West!=null) return currentpos.West; else return currentpos.Ost;
			case 3: if(currentpos.Ost!=null) return currentpos.Ost; else return currentpos.West;
			}
		}
		if(richtung == Fahrtrichtung.Ost){
			switch(i){
			case 1: if(currentpos.Nord!=null) return currentpos.Nord; else return currentpos.Sued;
			case 2: if(currentpos.Ost!=null) return currentpos.Ost; else if(currentpos.Sued!=null) return currentpos.Sued; else return currentpos.Nord;
			case 3: if(currentpos.Sued!=null) return currentpos.Sued; else return currentpos.Nord;
			}
		}
		if(richtung == Fahrtrichtung.Sued){
			switch(i){
			case 1: if(currentpos.West!=null) return currentpos.West; else return currentpos.Ost;
			case 2: if(currentpos.Sued!=null) return currentpos.Sued; else if(currentpos.Ost!=null) return currentpos.Ost; else return currentpos.West;
			case 3: if(currentpos.Ost!=null) return currentpos.Ost; else return currentpos.West;
			}
		}
		if(richtung == Fahrtrichtung.West){
			switch(i){
			case 1: if(currentpos.Nord!=null) return currentpos.Nord; else return currentpos.Sued;
			case 2: if(currentpos.West!=null) return currentpos.West; else if(currentpos.Nord!=null) return currentpos.Nord; else return currentpos.Sued;
			case 3: if(currentpos.Sued!=null) return currentpos.Sued; else return currentpos.Nord;
			}		
		}
		return auto.getCurrentField();
	}
	
	public Feld getNextField(SchnellesAuto auto){
		Fahrtrichtung richtung= auto.getRichtung();
		Feld currentpos = auto.getCurrentField();
		
		int i = (int) (Math.random()*3+1);
		if(richtung == Fahrtrichtung.Nord){
			switch(i){
			case 1: if(currentpos.NordWest.West!=null) return currentpos.NordWest; else return currentpos.NordOst;
			case 2: if(currentpos.Nord.Nord!=null) return currentpos.Nord; else if(currentpos.NordWest.West!=null) return currentpos.NordWest; else return currentpos.NordOst;
			case 3: if(currentpos.NordOst.Ost!=null) return currentpos.NordOst; else return currentpos.NordWest;
			}
		}
		if(richtung == Fahrtrichtung.Ost){
			switch(i){
			case 1: if(currentpos.NordOst.Nord!=null) return currentpos.NordOst; else return currentpos.SuedOst;
			case 2: if(currentpos.Ost.Ost!=null) return currentpos.Ost; else if(currentpos.NordOst.Nord!=null) return currentpos.NordOst; else return currentpos.SuedOst;
			case 3: if(currentpos.SuedOst.Sued!=null) return currentpos.SuedOst; else return currentpos.NordOst;
			}
		}
		if(richtung == Fahrtrichtung.Sued){
			switch(i){
			case 1: if(currentpos.SuedOst.Ost!=null) return currentpos.SuedOst; else return currentpos.SuedWest;
			case 2: if(currentpos.Sued.Sued!=null) return currentpos.Sued; else if(currentpos.SuedOst.Ost!=null) return currentpos.SuedOst; else return currentpos.SuedWest;
			case 3: if(currentpos.SuedWest.West!=null) return currentpos.SuedWest; else return currentpos.SuedOst;
			}
		}
		if(richtung == Fahrtrichtung.West){
			switch(i){
			case 1: if(currentpos.NordWest.Nord!=null) return currentpos.NordWest; else return currentpos.SuedWest;
			case 2: if(currentpos.West.West!=null) return currentpos.West; else if(currentpos.NordWest.Nord!=null) return currentpos.NordWest; else return currentpos.SuedWest;
			case 3: if(currentpos.SuedWest.Sued!=null) return currentpos.SuedWest; else return currentpos.NordWest;
			}		
		}
		
		return auto.getCurrentField();
	}
}
