@Guarantor(person="Goran Filcic")
public class Bauernhof {
	// instances represent a farm with a collection of type Traktor
	
	private final String name; // name!=null && name!="" and must be unique
	private TraktorList traktoren;
	
	public Bauernhof(String name){
		this.name=name;
		traktoren = new TraktorList();
	}
	//@param name !=null && name != "" and must be unique
	// creates and initializes Bauernhof
	
	@Override
	public String toString(){
		return name;
	}
	//returns the name of Bauernhof as a string
	
	@Guarantor(person="Goran Filcic")
	public void addTraktor(Traktor traktor){
		traktoren.add(traktor);
	}
	//@param traktor != null
	//adds a Traktor to the list
	
	@Guarantor(person="Goran Filcic")
	public void removeTraktor(int i){
		ITraktorIterator it = traktoren.iterator();
		while(it.hasNext()){
			if(it.next().getID()==i){
				it.remove();
				break; 
			}
		}
	}
	//@param i>0
	//searches a Traktor by ID and removes it
	
	@Guarantor(person="Goran Filcic")
	public void erhoeheDieselVerbrauch(int i){
		IDieselTraktorIterator it = traktoren.getDieselTraktoren().iterator();
		while(it.hasNext()){
			DieselTraktor traktor = it.next();
			if(traktor.getID()==i){
				traktor.incrementVerbrauch();
				break; 
			}
		}
	}
	
	
	//@param i>0
	//searches a DieselTraktor by ID and increments Verbrauch(consumption)

	@Guarantor(person="Goran Filcic")
	public void erhoeheGasVerbrauch(int i){
		IGasTraktorIterator it = traktoren.getGasTraktoren().iterator();
		while(it.hasNext()){
			GasTraktor traktor = it.next();
			if(traktor.getID()==i){
				traktor.incrementVerbrauch();
				break; 
			}
		}
	}
	//@param i>0
	//searches a GasTraktor by ID and increments Verbrauch(consumption)
	
	@Guarantor(person="Goran Filcic")
	public void aendereFunktion(int i, IFunktion funktion){
		ITraktorIterator it = traktoren.iterator();
		while(it.hasNext()){
			Traktor traktor = it.next();
			if(traktor.getID()==i){
				traktor.setFunktion(funktion);
				break; 
			}
		}
	}
	//@param i>0
	//searches a Traktor by ID and sets a new IFunktion
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstunden(){
		return averageBetrieb(0);
	}
	//returns the average of operating hours from all instances of Traktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDrillmaschine(){
		return averageBetrieb(1);
	}
	//returns the average of operating hours from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDuengerstreuer(){
		return averageBetrieb(2);
	}
	//returns the average of operating hours from all instances of Traktor with IFunktion Duengestreuer
	
	private double averageBetrieb(int i){
		double summe=0.0;
		TraktorList list;
		switch(i){
			case 1: list= traktoren.getDrillmaschinen(); break;
			case 2: list= traktoren.getDuengerstreuer(); break;
			default: list=traktoren; break;
		}
		
		ITraktorIterator it = list.iterator();
		while(it.hasNext()){
			summe+=it.next().getBetriebsstunden();
		}
		
		if(list.size()==0) return 0.0;
		return summe/list.size();

	}
	//returns the average of operating hours for Traktor with specified IFunktion
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDieselTraktor(){
		double summe=0.0;
		
		IDieselTraktorIterator it = traktoren.getDieselTraktoren().iterator();
		while(it.hasNext()){
			summe+=it.next().getBetriebsstunden();
		}
		
		if(traktoren.getDieselTraktoren().size()==0) return 0.0;
		return summe/traktoren.getDieselTraktoren().size();
		
	}
	//returns the average of operating hours from all instances of DieselTraktor
	
	private double averageDiesel(int i){
		double summe=0.0;
		DieselTraktorList list;
		switch(i){
			case 1: list= traktoren.getDrillmaschinen().getDieselTraktoren(); break;
			case 2: list= traktoren.getDuengerstreuer().getDieselTraktoren(); break;
			default: list= traktoren.getDieselTraktoren(); break;
		}
		
		IDieselTraktorIterator it = list.iterator();
		while(it.hasNext()){
			summe+=it.next().getVerbrauch();
		}
		
		if(list.size()==0) return 0.0;
		return summe/list.size();

	}
	//returns the average of diesel consumption for DieselTraktor with specified IFunktion
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauch(){
		return averageDiesel(0);
	}
	//returns the average of diesel consumption from all instances of DieselTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauchDrillmaschine(){
		return averageDiesel(1);
	}
	//returns the average of diesel consumption from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauchDuengerstreuer(){
		return averageDiesel(2);
	}
	//returns the average of diesel consumption from all instances of DieselTraktor with IFunktion Duengestreuer
	
	private double averageGas(int i){
		double summe=0.0;
		GasTraktorList list;
		switch(i){
			case 1: list= traktoren.getDrillmaschinen().getGasTraktoren(); break;
			case 2: list= traktoren.getDuengerstreuer().getGasTraktoren(); break;
			default: list= traktoren.getGasTraktoren(); break;
		}
		
		IGasTraktorIterator it = list.iterator();
		while(it.hasNext()){
			summe+=it.next().getVerbrauch();
		}
		
		if(list.size()==0) return 0.0;
		return summe/list.size();

	
		
	}
	//returns the average of diesel consumption for GasTraktor with specified IFunktion
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauch(){
		return averageGas(0);
	}
	//returns the average of gas consumption from all instances of GasTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauchDrillmaschine(){
		return averageGas(1);
	}
	//returns the average of gas consumption from all instances of GasTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauchDuengerstreuer(){
		return averageGas(2);
	}
	//returns the average of gas consumption from all instances of GasTraktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenGasTraktor(){
		double summe=0.0;
		
		IGasTraktorIterator it = traktoren.getGasTraktoren().iterator();
		while(it.hasNext()){
			summe+=it.next().getBetriebsstunden();
		}
		
		if(traktoren.getGasTraktoren().size()==0) return 0.0;
		return summe/traktoren.getGasTraktoren().size();
	
	}
	//returns the average of operating hours from all instances of GasTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschare(){
		ITraktorIterator it=traktoren.getDrillmaschinen().iterator();
		double min=it.next().getFunktion().getMengeSaeschare();
		while(it.hasNext()){
			Traktor traktor=it.next();
			if(traktor.getFunktion().getMengeSaeschare()<min) min= traktor.getFunktion().getMengeSaeschare();
		}
		
		return min;
	}
	//returns lowest value of Saeschare from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschare(){
		double max=0.0;
		
		ITraktorIterator it=traktoren.getDrillmaschinen().iterator();
		while(it.hasNext()){
			Traktor traktor=it.next();
			if(traktor.getFunktion().getMengeSaeschare()>max) max= traktor.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschareDieselTraktor(){
		IDieselTraktorIterator it=traktoren.getDrillmaschinen().getDieselTraktoren().iterator();
		double min=it.next().getFunktion().getMengeSaeschare();
		while(it.hasNext()){
			Traktor traktor=it.next();
			if(traktor.getFunktion().getMengeSaeschare()<min) min= traktor.getFunktion().getMengeSaeschare();
		}
		return min;
	}
	//returns lowest value of Saeschare from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschareDieselTraktor(){
		double max=0.0;
		IDieselTraktorIterator it=traktoren.getDrillmaschinen().getDieselTraktoren().iterator();
		while(it.hasNext()){
			Traktor traktor=it.next();
			if(traktor.getFunktion().getMengeSaeschare()>max) max= traktor.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschareGasTraktor(){
		IGasTraktorIterator it=traktoren.getDrillmaschinen().getGasTraktoren().iterator();
		double min=it.next().getFunktion().getMengeSaeschare();
		while(it.hasNext()){
			Traktor traktor=it.next();
			if(traktor.getFunktion().getMengeSaeschare()<min) min= traktor.getFunktion().getMengeSaeschare();
		}
		return min;
	}
	//returns lowest value of Saeschare from all instances of GasTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschareGasTraktor(){
		double max=0.0;
		IGasTraktorIterator it=traktoren.getDrillmaschinen().getGasTraktoren().iterator();
		while(it.hasNext()){
			Traktor traktor=it.next();
			if(traktor.getFunktion().getMengeSaeschare()>max) max= traktor.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of GasTraktor with IFunktion Drillmaschine
	
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaet(){
		double summe =0.0;
		
		ITraktorIterator it=traktoren.getDuengerstreuer().iterator();
		while(it.hasNext()){
			
			summe+=it.next().getFunktion().getFassungskapazitaet();
		}
		
		if(traktoren.getDuengerstreuer().size()==0) return 0.0;
		return summe/traktoren.getDuengerstreuer().size();

	}
	//returns average of  from all instances of Traktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaetDieselTraktor(){
		double summe =0.0;
		
		IDieselTraktorIterator it=traktoren.getDuengerstreuer().getDieselTraktoren().iterator();
		while(it.hasNext()){
			
			summe+=it.next().getFunktion().getFassungskapazitaet();
		}
		
		if(traktoren.getDuengerstreuer().getDieselTraktoren().size()==0) return 0.0;	
		return summe/traktoren.getDuengerstreuer().getDieselTraktoren().size();
		
	}
	//returns average of capacity(Fassungskapazitaet) from all instances of DieselTraktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaetGasTraktor(){
		double summe =0.0;
		
		IGasTraktorIterator it=traktoren.getDuengerstreuer().getGasTraktoren().iterator();
		while(it.hasNext()){
			
			summe+=it.next().getFunktion().getFassungskapazitaet();
		}
		
		if(traktoren.getDuengerstreuer().getGasTraktoren().size()==0) return 0.0;
		return summe/traktoren.getDuengerstreuer().getGasTraktoren().size();
		
	}
	//returns average of capacity(Fassungskapazitaet) from all instances of GasTraktor with IFunktion Duengestreuer

	@Guarantor(person="Peter Nirschl")
	public String getName() {
		return name;
	}
	// returns  the name of the Bauernhof;
	// return value != "" and return value != null
}
