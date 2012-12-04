import java.util.List;
import java.util.ArrayList;

public class Rennen extends Thread implements AutoEventListener {
	private List<Auto> autos = new ArrayList<Auto>();
	private boolean run;
		
	public Rennen(Rennstrecke rennstrecke, List<Auto> autos){
		this.autos.addAll(autos);
		
		for (Auto auto : autos){
			auto.setAutoEventListener(this);
		}
	}
	
	@Override
	public void run() {
		run = true;
		
		for (Thread thread : autos){
			thread.start();
		}
		
		while(run) {
			try {
				// wait for other threads to interrupt
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// ignore
			}
		}
	}
	
	public synchronized void notifyMaxPunkteReached() {
		interruptThreads();
	}
	
	public synchronized void notifyMaxSchritteReached() {
		interruptThreads();
	}
	
	private synchronized void interruptThreads() {
		for(Thread thread : autos) {
			try {
				thread.interrupt();
			} catch(SecurityException e) {
				e.printStackTrace();
			}
		}
		this.run = false;
		this.interrupt();
	}

}
