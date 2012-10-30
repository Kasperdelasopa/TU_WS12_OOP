package UE1;

public class Person {
	
	private String name;
	private String tele;
	private int nummer;
	
	public Person(Integer num, String name, String tele){
		setName(name);
		setTele(tele);
		setNummer(num);
	}
	
	public String getName() {
		//Methode gibt den Namen der Person zurueck 
		return name;
	}

	public void setName(String name) {
		//Methode setzt den Namen der Person
		//FEHLER: kein Test ob name != "", nur Buchstaben enthaelt
		this.name = name;
	}

	public String getTele() {
		//Methode gibt Telefonnummer zurueck
		return tele;
	}

	public void setTele(String tele) {
		//Methode setzt die die Telefonnummer
		//FEHLER: kein Test ob tele != "", Nummer auch gueltige Telefonnummer ist
		this.tele = tele;
	}
	
	public int getNummer() {
		//Methode gibt die ID der Person zurueck
		return nummer;
	}


	public void setNummer(int nummer) {
		//Methode setzt die ID der Person
		//FEHLER: kein Test ob nummer > 0
		this.nummer = nummer;
	}
}
