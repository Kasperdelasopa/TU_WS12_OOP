import java.util.Iterator;


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
		Iterator<Traktor> it = traktoren.iterator();
		while(it.hasNext()){
			if(it.next().getID()==i){
				traktoren.iterator().remove();
				break; 
			}
		}
	}
	//@param i>0
	//searches a Traktor by ID and removes it
	
	@Guarantor(person="Goran Filcic")
	public void erhoeheDieselVerbrauch(int i){
		for(DieselTraktor e: traktoren.getDieselTraktoren()){
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
		for(GasTraktor e: traktoren.getGasTraktoren()){
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
		for(Traktor e: traktoren){
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
		double summe =0.0;
		
		for(Traktor e: traktoren)
		{
			summe+=e.getBetriebsstunden();
		}
		
		return summe/traktoren.size();
	}
	//returns the average of operating hours from all instances of Traktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDrillmaschine(){
		double summe=0.0;
		for(Traktor e: traktoren.getDrillmaschinen())
		{
			summe+=e.getBetriebsstunden();
		}
		return summe/traktoren.getDrillmaschinen().size();
	}
	//returns the average of operating hours from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDuengerstreuer(){
		double summe=0.0;
		for(Traktor e: traktoren.getDuengerstreuer())
		{
			summe+=e.getBetriebsstunden();
		}
		return summe/traktoren.getDuengerstreuer().size();
	}
	//returns the average of operating hours from all instances of Traktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenDieselTraktor(){
		double summe=0.0;
		for(Traktor e: traktoren.getDieselTraktoren())
		{
			summe+=e.getBetriebsstunden();
		}
		return summe/traktoren.getDieselTraktoren().size();
	}
	//returns the average of operating hours from all instances of DieselTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageBetriebsstundenGasTraktor(){
		double summe=0.0;
		for(Traktor e: traktoren.getGasTraktoren())
		{
			summe+=e.getBetriebsstunden();
		}
		return summe/traktoren.getGasTraktoren().size();
	}
	//returns the average of operating hours from all instances of GasTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauch(){
		double summe=0.0;
		for(DieselTraktor e: traktoren.getDieselTraktoren())
		{
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDieselTraktoren().size();
	}
	//returns the average of diesel consumption from all instances of DieselTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauchDrillmaschine(){
		double summe=0.0;
		for(DieselTraktor e:  traktoren.getDrillmaschinen().getDieselTraktoren())
		{
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDrillmaschinen().getDieselTraktoren().size();
	}
	//returns the average of diesel consumption from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageDieselVerbrauchDuengerstreuer(){
		double summe=0.0;	
		for(DieselTraktor e: traktoren.getDuengerstreuer().getDieselTraktoren())
		{
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDuengerstreuer().getDieselTraktoren().size();
	}
	//returns the average of diesel consumption from all instances of DieselTraktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauch(){
		double summe=0.0;
		for(GasTraktor e: traktoren.getGasTraktoren())
		{
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getGasTraktoren().size();
	}
	//returns the average of gas consumption from all instances of GasTraktor
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauchDrillmaschine(){
		double summe=0.0;
		for(GasTraktor e:  traktoren.getDrillmaschinen().getGasTraktoren())
		{
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDrillmaschinen().getGasTraktoren().size();
	}
	//returns the average of gas consumption from all instances of GasTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageGasVerbrauchDuengerstreuer(){
		double summe=0.0;
		for(GasTraktor e: traktoren.getDuengerstreuer().getGasTraktoren())
		{
			summe+=e.getVerbrauch();
		}
		return summe/traktoren.getDuengerstreuer().getGasTraktoren().size();
	}
	//returns the average of gas consumption from all instances of GasTraktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschare(){
		Iterator<Traktor> iter=traktoren.getDrillmaschinen().iterator();
		double min=iter.next().getFunktion().getMengeSaeschare();
		for(Traktor e: traktoren.getDrillmaschinen())
		{
			if(e.getFunktion().getMengeSaeschare()<min) min= e.getFunktion().getMengeSaeschare();
		}
		return min;
	}
	//returns lowest value of Saeschare from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschare(){
		double max=0.0;
		for(Traktor e: traktoren.getDrillmaschinen())
		{
			if(e.getFunktion().getMengeSaeschare()>max) max= e.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of Traktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschareDieselTraktor(){
		Iterator<Traktor> iter=traktoren.getDrillmaschinen().iterator();
		double min=iter.next().getFunktion().getMengeSaeschare();
		for(Traktor e: traktoren.getDrillmaschinen().getDieselTraktoren())
		{
			if(e.getFunktion().getMengeSaeschare()<min) min= e.getFunktion().getMengeSaeschare();
		}
		return min;
	}
	//returns lowest value of Saeschare from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschareDieselTraktor(){
		double max=0.0;
		for(Traktor e: traktoren.getDrillmaschinen().getDieselTraktoren())
		{
			if(e.getFunktion().getMengeSaeschare()>max) max= e.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of DieselTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMinSaeschareGasTraktor(){
		Iterator<Traktor> iter=traktoren.getDrillmaschinen().iterator();
		double min=iter.next().getFunktion().getMengeSaeschare();
		for(Traktor e: traktoren.getDrillmaschinen().getGasTraktoren())
		{
			if(e.getFunktion().getMengeSaeschare()<min) min= e.getFunktion().getMengeSaeschare();
		}
		return min;
	}
	//returns lowest value of Saeschare from all instances of GasTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getMaxSaeschareGasTraktor(){
		double max=0.0;
		for(Traktor e: traktoren.getDrillmaschinen().getGasTraktoren())
		{
			if(e.getFunktion().getMengeSaeschare()>max) max= e.getFunktion().getMengeSaeschare();
		}
		return max;
	}
	//returns highest value of Saeschare from all instances of GasTraktor with IFunktion Drillmaschine
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaet(){
		double summe =0.0;
		
		for(Traktor e: traktoren)
		{
			summe+=e.getFunktion().getFassungskapazitaet();
		}
		
		return summe/traktoren.size();
	}
	//returns average of  from all instances of Traktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaetDieselTraktor(){
		double summe =0.0;
		
		for(Traktor e: traktoren.getDieselTraktoren())
		{
			summe+=e.getFunktion().getFassungskapazitaet();
		}
		
		return summe/traktoren.size();
	}
	//returns average of capacity(Fassungskapazitaet) from all instances of DieselTraktor with IFunktion Duengestreuer
	
	@Guarantor(person="Goran Filcic")
	public double getAverageFassungskapazitaetGasTraktor(){
		double summe =0.0;
		
		for(Traktor e: traktoren.getGasTraktoren())
		{
			summe+=e.getFunktion().getFassungskapazitaet();
		}
		
		return summe/traktoren.size();
	}
	//returns average of capacity(Fassungskapazitaet) from all instances of GasTraktor with IFunktion Duengestreuer
}
