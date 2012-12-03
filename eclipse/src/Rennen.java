import java.util.List;
import java.util.ArrayList;

public class Rennen implements AutoEventListener {
	private List<Auto> autos = new ArrayList<Auto>();
	private Rennstrecke strecke;
	boolean running=true;
	
	public Rennen(int streckenLaenge, int streckenBreite, List<Auto> auto){
		strecke = new Rennstrecke(streckenLaenge, streckenBreite);
		autos=auto;
		start();
	}
	
	public void start(){
		while(running){
			autos.get(0).move();
		}
	}
	
	public synchronized void notifyMaxPunkteReached(){
		running=false;
	};
	public synchronized void notifyMaxSchritteReached(){
		System.out.println("TEST");
		running=false;
	};

}
