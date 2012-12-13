
public class Test {

	public static void main(String[] args) {
		Bestellung bestellung = new Bestellung();
		
		bestellung.addPosition(new BestellPosition(1, Teigart.MUERBTEIG, 
														Form.MOND, null));
		bestellung.addPosition(new BestellPosition(2, Teigart.SCHOKOLADENTEIG, 
														Form.RUND, null));
		bestellung.addPosition(new BestellPosition(3, Teigart.ZIMTSTERNTEIG, 
														Form.WEIHNACHTSMANN, null));
		
		bestellung.addPosition(new BestellPosition(4, Teigart.MUERBTEIG, 
														Form.MOND, Fuellung.MARMELADE));	
		bestellung.addPosition(new BestellPosition(5, Teigart.MUERBTEIG, 
														Form.MOND, Fuellung.SCHOKOLADE));
		bestellung.addPosition(new BestellPosition(6, Teigart.SCHOKOLADENTEIG, 
														Form.RUND, Fuellung.MARMELADE));

		bestellung.drucken();

	}
}