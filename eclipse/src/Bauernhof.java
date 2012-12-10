

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
		IDieselTraktorIterator iterator = traktoren.getDieselTraktoren().iterator();
		while(iterator.hasNext()) {
			DieselTraktor e = iterator.next();
			if(e.getID()==i){
				e.incrementVerbrauch();
				break;
			}
		}
	}
	//@param i>0
	//searches a DieselTraktor by ID and increments Verbrauch(consumption)

	@Guarantor(person="Goran Filcic")
	public void erhoeheGasVerbrauch(int i){
		IGasTraktorIterator iterator = traktoren.getGasTraktoren().iterator();
		while(iterator.hasNext()){
			GasTraktor e = iterator.next();
			if(e.getID()==i){
				e.incrementVerbrauch();
				break;
			}
		}
	}
	//@param i>0
	//searches a GasTraktor by ID and increments Verbrauch(consumption)
	
	@Guarantor(person="Goran Filcic")
	public void aendereFunktion(int i, IFunktion funktion){
		ITraktorIterator iterator = traktoren.iterator();
		while(iterator.hasNext()){
			Traktor e = iterator.next();
			if(e.getID()==i){
				e.setFunktion(funktion);
				break;
			}
		}
	}
	//@param i>0
	//searches a Traktor by ID and sets a new IFunktion
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstunden(){
<<<<<<< HEAD
		double summe = 0.0;
		
		ITraktorIterator it = traktoren.iterator();
		while(it.hasNext()){
			Traktor e = it.next();
			summe+=e.getBetriebsstunden();
		}
		
		return summe/traktoren.size();
=======
		return averageBetrieb(0);
>>>>>>> branch 'master' of https://github.com/Kasperdelasopa/TU_WS12_OOP.git
	}
	//returns the average of operating hours from all instances of Traktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDrillmaschine(){
<<<<<<< HEAD
		double summe=0.0;
		
		ITraktorIterator iterator =  traktoren.getDrillmaschinen().iterator();
		while(iterator.hasNext())
		{
			Traktor e = iterator.next();
			summe+=e.getBetriebsstunden();
		}
		return summe/traktoren.getDrillmaschinen().size();
=======
		return averageBetrieb(1);
>>>>>>> branch 'master' of https://github.com/Kasperdelasopa/TU_WS12_OOP.git
	}
	//returns the average of operating hours from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDuengerstreuer(){
		return averageBetrieb(2);
	}
	//returns the average of operating hours from all instances of Traktor with IFunktion Duengestreuer
	
	private double averageBetrieb(int i){
		double summe=0.0;
<<<<<<< HEAD
		ITraktorIterator iterator =  traktoren.getDuengerstreuer().iterator();
		while(iterator.hasNext())
=======
		TraktorList list;
		switch(i){
			case 1: list= traktoren.getDrillmaschinen(); break;
			case 2: list= traktoren.getDuengerstreuer(); break;
			default: list=traktoren; break;
		}
		
		for(Traktor e: list)
>>>>>>> branch 'master' of https://github.com/Kasperdelasopa/TU_WS12_OOP.git
		{
			Traktor e = iterator.next();
			summe+=e.getBetriebsstunden();
		}
		
		if(list.size()==0) return 0.0;
		return summe/list.size();

	}
	//returns the average of operating hours for Traktor with specified IFunktion
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDieselTraktor(){
		double summe=0.0;
		IDieselTraktorIterator iterator =  traktoren.getDieselTraktoren().iterator();
		while(iterator.hasNext())
		{
			Traktor e = iterator.next();
			summe+=e.getBetriebsstunden();
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
		
		for(DieselTraktor e: list)
		{
			summe+=e.getVerbrauch();
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
		
		for(GasTraktor e: list)
		{
			summe+=e.getVerbrauch();
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
		IGasTraktorIterator iterator = traktoren.getGasTraktoren().iterator();
		while(iterator.hasNext())
		{
			Traktor e = iterator.next();
			summe+=e.getBetriebsstunden();
		}
			
		if(traktoren.getGasTraktoren().size()==0) return 0.0;
		return summe/traktoren.getGasTraktoren().size();
	
	}
	//returns the average of operating hours from all instances of GasTraktor
<<<<<<< HEAD
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauch(){
		double summe=0.0;
		IDieselTraktorIterator iterator = traktoren.getDieselTraktoren().iterator();
		while(iterator.hasNext())
		{
			DieselTraktor e = iterator.next();
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDieselTraktoren().size();
	}
	//returns the average of diesel consumption from all instances of DieselTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauchDrillmaschine(){
		double summe=0.0;
		IDieselTraktorIterator iterator = traktoren.getDrillmaschinen().getDieselTraktoren().iterator();
		while(iterator.hasNext())
		{
			DieselTraktor e = iterator.next();
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDrillmaschinen().getDieselTraktoren().size();
	}
	//returns the average of diesel consumption from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauchDuengerstreuer(){
		double summe=0.0;
		IDieselTraktorIterator iterator = traktoren.getDuengerstreuer().getDieselTraktoren().iterator();
		while(iterator.hasNext())
		{
			DieselTraktor e = iterator.next();
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDuengerstreuer().getDieselTraktoren().size();
	}
	//returns the average of diesel consumption from all instances of DieselTraktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauch(){
		double summe=0.0;
		IGasTraktorIterator iterator = traktoren.getGasTraktoren().iterator();
		while(iterator.hasNext())
		{
			GasTraktor e = iterator.next();
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getGasTraktoren().size();
	}
	//returns the average of gas consumption from all instances of GasTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauchDrillmaschine(){
		double summe=0.0;
		IGasTraktorIterator iterator = traktoren.getDrillmaschinen().getGasTraktoren().iterator();
		while(iterator.hasNext())
		{
			GasTraktor e = iterator.next();
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDrillmaschinen().getGasTraktoren().size();
	}
	//returns the average of gas consumption from all instances of GasTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauchDuengerstreuer(){
		double summe=0.0;
		IGasTraktorIterator iterator = traktoren.getDuengerstreuer().getGasTraktoren().iterator();
		while(iterator.hasNext())
		{
			GasTraktor e = iterator.next();
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDuengerstreuer().getGasTraktoren().size();
	}
	//returns the average of gas consumption from all instances of GasTraktor with IFunktion Duengestreuer
=======
>>>>>>> branch 'master' of https://github.com/Kasperdelasopa/TU_WS12_OOP.git
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschare(){
		ITraktorIterator iter=traktoren.getDrillmaschinen().iterator();
		double min = 0.0;
		while(iter.hasNext())
		{
			Traktor e = iter.next();
			if(e.getFunktion().getMengeSaeschare()<min) min= e.getFunktion().getMengeSaeschare();
		}
		return min;
	}
	//returns lowest value of Saeschare from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschare(){
		double max = 0.0;
		ITraktorIterator iterator = traktoren.getDrillmaschinen().iterator();
		while(iterator.hasNext())
		{
			Traktor e = iterator.next();
			if(e.getFunktion().getMengeSaeschare()>max) max= e.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschareDieselTraktor(){
<<<<<<< HEAD
		ITraktorIterator iter=traktoren.getDrillmaschinen().iterator();
		double min = 0.0;
		while(iter.hasNext())
=======
		Iterator<DieselTraktor> iter=traktoren.getDrillmaschinen().getDieselTraktoren().iterator();
		double min=iter.next().getFunktion().getMengeSaeschare();
		for(Traktor e: traktoren.getDrillmaschinen().getDieselTraktoren())
>>>>>>> branch 'master' of https://github.com/Kasperdelasopa/TU_WS12_OOP.git
		{
			Traktor e = iter.next();
			if(e.getFunktion().getMengeSaeschare()<min) min= e.getFunktion().getMengeSaeschare();
		}
		return min;
	}
	//returns lowest value of Saeschare from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschareDieselTraktor(){
		double max=0.0;
		IDieselTraktorIterator iterator = traktoren.getDrillmaschinen().getDieselTraktoren().iterator();
		while(iterator.hasNext())
		{
			DieselTraktor e = iterator.next();
			if(e.getFunktion().getMengeSaeschare()>max) max= e.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschareGasTraktor(){
<<<<<<< HEAD
		IGasTraktorIterator iter=traktoren.getDrillmaschinen().getGasTraktoren().iterator();
=======
		Iterator<GasTraktor> iter=traktoren.getDrillmaschinen().getGasTraktoren().iterator();
>>>>>>> branch 'master' of https://github.com/Kasperdelasopa/TU_WS12_OOP.git
		double min=iter.next().getFunktion().getMengeSaeschare();
		while(iter.hasNext())
		{
			GasTraktor e = iter.next();
			if(e.getFunktion().getMengeSaeschare()<min) min= e.getFunktion().getMengeSaeschare();
		}
		return min;
	}
	//returns lowest value of Saeschare from all instances of GasTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschareGasTraktor(){
		double max=0.0;
		IGasTraktorIterator iterator =  traktoren.getDrillmaschinen().getGasTraktoren().iterator();
		while(iterator.hasNext())
		{
			GasTraktor e = iterator.next();
			if(e.getFunktion().getMengeSaeschare()>max) max= e.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of GasTraktor with IFunktion Drillmaschine
	
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaet(){
		double summe =0.0;
		
		ITraktorIterator iterator = traktoren.iterator();
		while(iterator.hasNext())
		{
			Traktor e = iterator.next();
			summe+=e.getFunktion().getFassungskapazitaet();
		}
		
		if(traktoren.size()==0) return 0.0;
		return summe/traktoren.size();

	}
	//returns average of  from all instances of Traktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaetDieselTraktor(){
		double summe =0.0;
		
		IDieselTraktorIterator iterator = traktoren.getDieselTraktoren().iterator();
		while(iterator.hasNext())
		{
			DieselTraktor e = iterator.next();
			summe+=e.getFunktion().getFassungskapazitaet();
		}
		
		
		if(traktoren.getDieselTraktoren().size()==0) return 0.0;	
		return summe/traktoren.getDieselTraktoren().size();
		
	}
	//returns average of capacity(Fassungskapazitaet) from all instances of DieselTraktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaetGasTraktor(){
		double summe =0.0;
		
		IGasTraktorIterator iterator = traktoren.getGasTraktoren().iterator();
		while(iterator.hasNext())
		{
			GasTraktor e = iterator.next();
			summe+=e.getFunktion().getFassungskapazitaet();
		}
		
		
		if(traktoren.getGasTraktoren().size()==0) return 0.0;
		return summe/traktoren.getGasTraktoren().size();
		
	}
	//returns average of capacity(Fassungskapazitaet) from all instances of GasTraktor with IFunktion Duengestreuer

}
