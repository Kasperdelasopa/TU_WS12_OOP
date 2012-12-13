
public class BestellPosition {
//This class represents a position in a costumer order
	
	private int anzahl;
	private Teigart teigart;
	private Form form;
	private Fuellung fuellung = null;
	
	public BestellPosition(int anzahl,
							Teigart teigart,
							Form form,
							Fuellung fuellung){
		this.anzahl = anzahl;
		this.teigart = teigart;
		this.form = form;
		this.fuellung = fuellung;
	}

	public String toString(){
		String tmp="";
		tmp = "Teigart: "+teigart.toString()+" / Form: "+form.toString();
		 
		if(fuellung != null)
			tmp += " / Fuellung: " + fuellung.toString();
		
		tmp += " / Anzahl: "+anzahl;
		
		return tmp;
	}
	//This Method returns a String with the content of this
	//order position
}
