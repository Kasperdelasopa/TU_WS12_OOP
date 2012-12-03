import java.util.List;
import java.util.ArrayList;

public class Rennen implements AutoEventListener {
	private List<Auto> autos = new ArrayList<Auto>();
	private Rennstrecke strecke;
	
	
	public Rennen(Rennstrecke rennstrecke, List<Auto> auto){
		autos=auto;
		
		for (Auto e : autos){
			e.setAutoEventListener(this);
		}
		
		start();
	}
	
	public void start(){
		for (Thread thread : autos){
			thread.start();
		}
		
	}
	
	public synchronized void notifyMaxPunkteReached() {
		interruptThreads();
	}
	
	public synchronized void notifyMaxSchritteReached() {
		interruptThreads();
	}
	
	private void interruptThreads() {
		for(Thread thread : autos) {
			try {
				thread.interrupt();
			} catch(SecurityException e) {
				e.printStackTrace();
			}
		}
	}

}
