import java.util.List;
import java.util.ArrayList;

public class Rennen implements AutoEventListener {
	private List<Auto> autos = new ArrayList<Auto>();
	private Rennstrecke strecke;
	List<Runnable> threadlist= new ArrayList<Runnable>();
	
	
	public Rennen(Rennstrecke rennstrecke, List<Auto> auto){
		autos=auto;
		
		for (Auto e : autos){
			threadlist.add(new Thread(e));
		}
		
		start();
	}
	
	public void start(){
		for (Runnable e : threadlist){
			e.run();
		}
		
	}
	
	public synchronized void notifyMaxPunkteReached(){
		System.out.println("Test");
	};
	public synchronized void notifyMaxSchritteReached(){
		System.out.println("Test");
	};

}
