import java.util.List;
import java.util.ArrayList;

public class Rennen implements AutoEventListener {
	private List<Auto> autos = new ArrayList<Auto>();
	private Rennstrecke strecke;
	
	public Rennen(int streckenLaenge, int streckenBreite, ArrayList<Auto> auto){
		strecke = new Rennstrecke(streckenLaenge, streckenBreite);
		
		
	}
	
	public void start(){
		
	}
	
	public synchronized void notifyMaxPunkteReached(){};
	public synchronized void notifyMaxSchritteReached(){};

}
