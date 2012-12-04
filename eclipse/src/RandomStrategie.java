import java.util.ArrayList;



public class RandomStrategie implements Strategie {
//represents a random strategy for a car
	public RandomStrategie(){
	}
	// creates instance
	
	public Feld getNextField(BeweglichesAuto auto){
		Fahrtrichtung richtung= auto.getRichtung();
		Feld currentpos = auto.getCurrentField();
		
		int i = (int) (Math.random()*3+1);
		if(richtung == Fahrtrichtung.Nord){
			switch(i){
			case 1: if(currentpos.West!=null) {auto.setRichtung(Fahrtrichtung.West); return currentpos.West;} else {auto.setRichtung(Fahrtrichtung.Ost); return currentpos.Ost;}
			case 2: if(currentpos.Nord!=null)  return currentpos.Nord; else if(currentpos.West!=null) {auto.setRichtung(Fahrtrichtung.West); return currentpos.West;} else {auto.setRichtung(Fahrtrichtung.Ost); return currentpos.Ost;}
			case 3: if(currentpos.Ost!=null) {auto.setRichtung(Fahrtrichtung.Ost); return currentpos.Ost;} else {auto.setRichtung(Fahrtrichtung.West); return currentpos.West;}
			}
		}
		if(richtung == Fahrtrichtung.Ost){
			switch(i){
			case 1: if(currentpos.Nord!=null) {auto.setRichtung(Fahrtrichtung.Nord); return currentpos.Nord;} else {auto.setRichtung(Fahrtrichtung.Sued); return currentpos.Sued;}
			case 2: if(currentpos.Ost!=null)  return currentpos.Ost; else if(currentpos.Sued!=null) {auto.setRichtung(Fahrtrichtung.Sued); return currentpos.Sued;} else {auto.setRichtung(Fahrtrichtung.Nord); return currentpos.Nord;}
			case 3: if(currentpos.Sued!=null) {auto.setRichtung(Fahrtrichtung.Sued); return currentpos.Sued;} else {auto.setRichtung(Fahrtrichtung.Nord); return currentpos.Nord;}
			}
		}
		if(richtung == Fahrtrichtung.Sued){
			switch(i){
			case 1: if(currentpos.West!=null) {auto.setRichtung(Fahrtrichtung.West); return currentpos.West;} else {auto.setRichtung(Fahrtrichtung.Ost); return currentpos.Ost;}
			case 2: if(currentpos.Sued!=null)  return currentpos.Sued; else if(currentpos.Ost!=null) {auto.setRichtung(Fahrtrichtung.Ost); return currentpos.Ost;} else {auto.setRichtung(Fahrtrichtung.West); return currentpos.West;}
			case 3: if(currentpos.Ost!=null) {auto.setRichtung(Fahrtrichtung.Ost); return currentpos.Ost;} else {auto.setRichtung(Fahrtrichtung.West); return currentpos.West;}
			}
		}
		if(richtung == Fahrtrichtung.West){
			switch(i){
			case 1: if(currentpos.Nord!=null) {auto.setRichtung(Fahrtrichtung.Nord); return currentpos.Nord;} else {auto.setRichtung(Fahrtrichtung.Sued); return currentpos.Sued;} 
			case 2: if(currentpos.West!=null)  return currentpos.West; else if(currentpos.Nord!=null) {auto.setRichtung(Fahrtrichtung.Nord); return currentpos.Nord;} else {auto.setRichtung(Fahrtrichtung.Sued); return currentpos.Sued;} 
			case 3: if(currentpos.Sued!=null) {auto.setRichtung(Fahrtrichtung.Sued); return currentpos.Sued;}  else {auto.setRichtung(Fahrtrichtung.Nord); return currentpos.Nord;}
			}		
		}
		return auto.getCurrentField();
	}
	//@param auto!= null
	//returns the next random field for the car of type BeweglichesAuto
	
	public Feld getNextField(SchnellesAuto auto){
		Fahrtrichtung richtung= auto.getRichtung();
		Feld currentpos = auto.getCurrentField();
		
		int i = (int) (Math.random()*3+1);
		if(richtung == Fahrtrichtung.Nord){
			if(currentpos.Nord!=null){
				switch(i){
				case 1: if(currentpos.NordWest!=null) if(currentpos.NordWest.West!=null) {auto.setRichtung(Fahrtrichtung.West); return currentpos.NordWest;} else {auto.setRichtung(Fahrtrichtung.Ost);return currentpos.NordOst;}
				case 2: if(currentpos.Nord.Nord!=null) return currentpos.Nord; else if(currentpos.NordWest!=null) if(currentpos.NordWest.West!=null) {auto.setRichtung(Fahrtrichtung.West); return currentpos.NordWest;} else {auto.setRichtung(Fahrtrichtung.Ost);return currentpos.NordOst;}
				case 3: if(currentpos.NordOst!=null) if(currentpos.NordOst.Ost!=null) {auto.setRichtung(Fahrtrichtung.Ost);return currentpos.NordOst;} else {auto.setRichtung(Fahrtrichtung.West); return currentpos.NordWest;}
				}
			}
		}
		if(richtung == Fahrtrichtung.Ost){
			if(currentpos.Ost!=null){
				switch(i){
				case 1: if(currentpos.NordOst!=null) if(currentpos.NordOst.Nord!=null) {auto.setRichtung(Fahrtrichtung.Nord);return currentpos.NordOst;} else {auto.setRichtung(Fahrtrichtung.Sued);return currentpos.SuedOst;}
				case 2: if(currentpos.Ost.Ost!=null)  return currentpos.Ost; else if(currentpos.NordOst!=null) if(currentpos.NordOst.Nord!=null) {auto.setRichtung(Fahrtrichtung.Nord);return currentpos.NordOst;} else {auto.setRichtung(Fahrtrichtung.Sued);return currentpos.SuedOst;}
				case 3: if(currentpos.SuedOst!=null) if(currentpos.SuedOst.Sued!=null) {auto.setRichtung(Fahrtrichtung.Sued);return currentpos.SuedOst;} else {auto.setRichtung(Fahrtrichtung.Nord);return currentpos.NordOst;}
				}
			}
		}
		if(richtung == Fahrtrichtung.Sued){
			if(currentpos.Sued!=null){
				switch(i){
				case 1: if(currentpos.SuedOst!=null) if(currentpos.SuedOst.Ost!=null) {auto.setRichtung(Fahrtrichtung.Ost);return currentpos.SuedOst;} else {auto.setRichtung(Fahrtrichtung.West);return currentpos.SuedWest;}
				case 2: if(currentpos.Sued.Sued!=null) return currentpos.Sued; else if(currentpos.SuedOst!=null) if(currentpos.SuedOst.Ost!=null) {auto.setRichtung(Fahrtrichtung.Ost);return currentpos.SuedOst;} else {auto.setRichtung(Fahrtrichtung.West);return currentpos.SuedWest;}
				case 3: if(currentpos.SuedWest!=null) if(currentpos.SuedWest.West!=null) {auto.setRichtung(Fahrtrichtung.West);return currentpos.SuedWest;} else {auto.setRichtung(Fahrtrichtung.Ost);return currentpos.SuedOst;}
				}
			}
		}
		
		if(richtung == Fahrtrichtung.West){
			if(currentpos.West!=null ){
				switch(i){
				case 1: if(currentpos.NordWest!=null) if(currentpos.NordWest.Nord!=null) {auto.setRichtung(Fahrtrichtung.Nord);return currentpos.NordWest;} else {auto.setRichtung(Fahrtrichtung.Sued);return currentpos.SuedWest;}
				case 2: if(currentpos.West.West!=null) return currentpos.West; else  if(currentpos.NordWest!=null)  if(currentpos.NordWest.Nord!=null)  {auto.setRichtung(Fahrtrichtung.Nord);return currentpos.NordWest;} else {auto.setRichtung(Fahrtrichtung.Sued);return currentpos.SuedWest;}
				case 3: if(currentpos.SuedWest!=null) if(currentpos.SuedWest.Sued!=null){auto.setRichtung(Fahrtrichtung.Sued);return currentpos.SuedWest;} else  {auto.setRichtung(Fahrtrichtung.Nord);return currentpos.NordWest;}
				}		
			}
		}
		
		return auto.getCurrentField();
	}
	//@param auto!= null
	//returns the next random field for the car of type SchnellesAuto
}
