import java.util.List;
import java.util.ArrayList;

public class Rennen extends Thread implements AutoEventListener {
//instance represents a race
	private List<Auto> autos; // autos !=null
	private boolean run;
		
	public Rennen(Rennstrecke rennstrecke, List<Auto> autos){
		autos=new ArrayList<Auto>();
		this.autos.addAll(autos);
		
		for (Auto auto : autos){
			auto.setAutoEventListener(this);
		}
	}
	//@param rennstrecke != null
	//@param autos !=null && must contain cars
	//initializes and creates the race
	//adds all cars to list autos and sets the AutoEventListener for each car
	
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
	//starts the thread for each car and runs the race 
	
	public synchronized void notifyEndOfRace() {
		interruptThreads();
	}
	//calls the method interruptThreads();
	
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
	//interrupts the threads of all cars
	//cancels the race and interrupts the class Rennen

}
