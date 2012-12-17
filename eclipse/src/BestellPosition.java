
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
	// initializes a new instance of BestellPosition
	// @param anzahl > 0
	// @param teigart != null
	// @param form != null

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

	public int getAnzahl() {
		return anzahl;
	}
	//returns the amount for this position

	public Teigart getTeigart() {
		return teigart;
	}
	//this Methods returns the Teigart for this position

	public Form getForm() {
		return form;
	}
	//This Methods returns the Form for this position

	public Fuellung getFuellung() {
		return fuellung;
	}
	//this Method returns the Fuellung for this position
	//if it is a Doppelkeks 
	//else null will be returned
}
