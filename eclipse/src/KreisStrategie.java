import java.util.ArrayList;
import java.util.List;
public class KreisStrategie implements Strategie {
	private int durchmesser;
	int position=0;
	List<Character> strategie = new ArrayList<Character>();
	
	public KreisStrategie(){}
	
	public KreisStrategie(Rennstrecke strecke, Auto auto){
		Fahrtrichtung richtung = auto.getRichtung();
		int laenge=0;
		int breite=0;
		char vertikal; char horizontal;
		
		int l1=0; int l2=0; int b1=0; int b2=0;
		Feld currentl1=auto.getCurrentField();
		Feld currentl2=auto.getCurrentField();
		Feld currentb1=auto.getCurrentField();
		Feld currentb2=auto.getCurrentField();
		while(currentl1!=null){			
			currentl1=currentl1.West;
			l1++;
		}
		while(currentl2!=null){			
			currentl2=currentl2.Ost;
			l2++;
		}
		while(currentb1!=null){			
			currentb1=currentb1.Nord;
			b1++;
		}
		while(currentb2!=null){			
			currentb2=currentb2.Sued;
			b2++;
		}
		
		if(l1>l2) {laenge=l1; horizontal='W';}  else laenge=l2; horizontal='O';
		if(b1>b2) {breite=b1; vertikal='N';} else breite=b2; vertikal='S';
		if(laenge>breite) durchmesser=breite; else durchmesser=laenge;
		durchmesser = (int) (Math.random()*durchmesser+1);

		boolean uhrzeigersinn=true;	
		if(horizontal=='O' && vertikal=='N' && (richtung==Fahrtrichtung.Nord || richtung==Fahrtrichtung.West)) uhrzeigersinn=true;
		if(horizontal=='O' && vertikal=='N' && (richtung==Fahrtrichtung.Sued || richtung==Fahrtrichtung.Ost)) uhrzeigersinn=false;
		if(horizontal=='O' && vertikal=='S' && (richtung==Fahrtrichtung.Nord || richtung==Fahrtrichtung.Ost)) uhrzeigersinn=true;
		if(horizontal=='O' && vertikal=='S' && (richtung==Fahrtrichtung.Sued || richtung==Fahrtrichtung.West)) uhrzeigersinn=false;
		if(horizontal=='W' && vertikal=='N' && (richtung==Fahrtrichtung.Sued || richtung==Fahrtrichtung.West)) uhrzeigersinn=true;
		if(horizontal=='W' && vertikal=='N' && (richtung==Fahrtrichtung.Nord || richtung==Fahrtrichtung.Ost)) uhrzeigersinn=false;
		if(horizontal=='W' && vertikal=='S' && (richtung==Fahrtrichtung.Sued || richtung==Fahrtrichtung.Ost)) uhrzeigersinn=true;
		if(horizontal=='W' && vertikal=='S' && (richtung==Fahrtrichtung.Nord || richtung==Fahrtrichtung.West)) uhrzeigersinn=false;
		
		if(uhrzeigersinn){
			for(int x=0; x<4; x++){
				strategie.add('R');
				for(int y=0; y<durchmesser; y++){
					strategie.add('G');
				}
			}
			
		}
		else{
			for(int x=0; x<4; x++){
				strategie.add('L');
				for(int y=0; y<durchmesser-2; y++){
					strategie.add('G');
				}
			}
		
		}
		
		if((richtung==Fahrtrichtung.Nord && b1>b2)||(richtung==Fahrtrichtung.Sued && b2>b1)||(richtung==Fahrtrichtung.West && l1>l2)||(richtung==Fahrtrichtung.Ost &&l2>l1) ){
			position=1;
		}
		
	}
	

	
	public Feld getNextField(BeweglichesAuto auto){
		Fahrtrichtung richtung = auto.getRichtung();
		Feld current=auto.getCurrentField();
		
		nextRound();
		
		if(strategie.get(position).equals('G')){
			geradeAus(richtung, current);
		}
		if(strategie.get(position).equals('R')){
			if( richtung==Fahrtrichtung.West) current=current.Nord;
			if( richtung==Fahrtrichtung.Ost) current=current.Sued;
			if( richtung==Fahrtrichtung.Sued) current=current.West;
			if( richtung==Fahrtrichtung.Nord) current=current.Ost;
		}
		if(strategie.get(position).equals('L')){
			if( richtung==Fahrtrichtung.West) current=current.Sued;
			if( richtung==Fahrtrichtung.Ost) current=current.Nord;
			if( richtung==Fahrtrichtung.Sued) current=current.Ost;
			if( richtung==Fahrtrichtung.Nord) current=current.West;
		}
		position++;
		return current;	
	
	}
	
	public Feld getNextField(SchnellesAuto auto){
		Fahrtrichtung richtung = auto.getRichtung();
		Feld current=auto.getCurrentField();
		if( (richtung==Fahrtrichtung.West && current.West==null) && (richtung==Fahrtrichtung.Nord && current.Nord==null) &&
			(richtung==Fahrtrichtung.Ost && current.Ost==null) && (richtung==Fahrtrichtung.Sued && current.Sued==null))
				return current;
		nextRound();
		
		if(strategie.get(position).equals('G')){
			geradeAus(richtung, current);
		}
		if(strategie.get(position).equals('R')){
			if( richtung==Fahrtrichtung.West) current=current.NordWest;
			if( richtung==Fahrtrichtung.Ost) current=current.SuedOst;
			if( richtung==Fahrtrichtung.Sued) current=current.SuedWest;
			if( richtung==Fahrtrichtung.Nord) current=current.NordOst;
		}
		if(strategie.get(position).equals('L')){
			if( richtung==Fahrtrichtung.West) current=current.SuedWest;
			if( richtung==Fahrtrichtung.Ost) current=current.NordOst;
			if( richtung==Fahrtrichtung.Sued) current=current.SuedOst;
			if( richtung==Fahrtrichtung.Nord) current=current.NordWest;
		}
		position++;
		return current;	
	
	}
	
	private void geradeAus(Fahrtrichtung richtung, Feld current){
		if( richtung==Fahrtrichtung.West) current=current.West;
		if( richtung==Fahrtrichtung.Ost) current=current.Ost;
		if( richtung==Fahrtrichtung.Sued) current=current.Sued;
		if( richtung==Fahrtrichtung.Nord) current=current.Nord;
	}
	
	private void nextRound(){
		if(position>=strategie.size()) position=0;
	}
}
