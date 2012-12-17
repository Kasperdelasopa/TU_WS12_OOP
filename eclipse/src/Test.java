import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		/*****Bestellungen****************************************************************/
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


		/*****Baeckerei**Fuer jede Form eine Backmaschine****************************************************************/
		HashMap<Form, KeksBackmaschine> map = new HashMap<Form, KeksBackmaschine>();
		
		for (Form form : Form.values()) {
			map.put(form, new KeksBackmaschine(form));
		}			
		
		/*****Kekse backen************************************************************************************************/
		List<Crunchable> keksliste = new ArrayList<Crunchable>();
		
		for(BestellPosition p : bestellung.getPositions()){
			KeksBackmaschine x = map.get(p.getForm());
			keksliste.addAll(x.createKekse(p));
		}
		
		/*****Kekse in Keksdose*******************************************************************************************/
		System.out.println("KEKSDOSE: ");
		Keksdose dose = new Keksdose(keksliste);
		dose.inhalt();
	}
}