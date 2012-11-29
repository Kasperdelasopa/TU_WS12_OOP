
public class Rennstrecke {
	private int laenge;
	private int breite;
	
	private Feld[][] rennstrecke;
	
	public Rennstrecke(int laenge, int breite){
		this.laenge = laenge;
		this.breite = breite;
		
		this.rennstrecke = buildStrecke(laenge, breite);
	}

	private Feld[][] buildStrecke(int laenge, int breite){
		Feld[][] feld = new Feld[breite][laenge];
		
		for(int b = 0; b < breite; b++){
			for(int l = 0; l < laenge; l++){
				feld[b][l] = new Feld();				
			}
		}
		
		for(int b = 0; b < breite; b++){
			for(int l = 0; l < laenge; l++){
				if(b<(breite-1)){
					feld[b][l].Ost = feld[b][l+1];
					feld[b][l+1].West = feld[b][l];
				}
				if(l<(laenge-1) && b < (breite-1)){
					feld[b][l].SuedOst = feld[b+1][l+1];
					feld[b+1][l+1].NordWest = feld[b][l];
				}
				if(l<(laenge-1)){
					feld[b][l].Sued = feld[b][l+1];
					feld[b][l+1].Nord = feld[b][l];
				}
				if(b>0 && l<(laenge-1)){
					feld[b][l].SuedWest = feld[b-1][l+1];
					feld[b-1][l+1].NordOst = feld[b][l];
				}
			}
		}
		
		return feld;
	}
	//@param laenge must be bigger than 0
	//@param breite must be bigger than 0

	public int getLaenge() {
		return laenge;
	}
	//laenge is bigger than 0
	
	public int getBreite() {
		return breite;
	}
	
	

}
