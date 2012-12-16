
public class DoppelkeksBackmaschine {
	// instances represent a machine that makes a double-cookie with filling(sandwich-cookie) from one prototype cookie
	// only one instance can be created - singleton
	
	private static DoppelkeksBackmaschine instance= new DoppelkeksBackmaschine();
	
	private DoppelkeksBackmaschine(){}
	//creates an instance of DoppelkeksBackmaschine
	
	public static DoppelkeksBackmaschine getInstance(){
		return instance;
	}
	// returns the instance
	
	public Doppelkeks createDoppelkeks(Keks keks1, Fuellung fuellung){		
		return new Doppelkeks(keks1, keks1.clone(), fuellung);
	}
	//@param keks1 != null
	//@param fuellung != null
	//returns a double-cookie with filling, consists of a cookie and his cloned part
}
