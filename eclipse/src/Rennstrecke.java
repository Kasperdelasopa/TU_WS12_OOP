import java.util.Random;


public class Rennstrecke {
	private int laenge;
	private int breite;
	private Feld startFeld;
	private Feld[][] rennstrecke;
	
	public Rennstrecke(int laenge, int breite){
		this.laenge = laenge;
		this.breite = breite;
		
		this.rennstrecke = buildStrecke(laenge, breite);
		this.startFeld = rennstrecke[1][1];
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
				if(l<(laenge-1)){
					feld[b][l].Ost = feld[b][l+1];
					feld[b][l+1].West = feld[b][l];
				}
				if(l<(laenge-1) && b < (breite-1)){
					feld[b][l].SuedOst = feld[b+1][l+1];
					feld[b+1][l+1].NordWest = feld[b][l];
				}
				if(b<(breite-1)){
					feld[b][l].Sued = feld[b+1][l];
					feld[b+1][l].Nord = feld[b][l];
				}
				if(l>0 && b<(breite-1)){
					feld[b][l].SuedWest = feld[b+1][l-1];
					feld[b+1][l-1].NordOst = feld[b][l];
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
	//returns width of Rennstrecke
	
	public Feld[][] getRennstrecke(){
		return this.rennstrecke;
	}
	//returns the whole Rennstrecke
	
	public Feld getStartField(){
		return this.startFeld;
	}
	//Returnes the Startfeld
	//by default Startfeld = rennstrecke[1][1];
	
	public void setStartFeld(Feld feld){
		this.startFeld = feld;
	}
	//sets a new Feld to StartFeld
	
	public Feld getRandomFeld(){
		Random r = new Random();
		
		int b = r.nextInt(this.breite);
		int l = r.nextInt(this.laenge);
		
		return this.rennstrecke[b][l];
	}
	//returns a random Field in Rennstrecke
}
