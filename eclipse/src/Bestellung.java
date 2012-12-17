import java.util.ArrayList;
import java.util.List;


public class Bestellung {
//this class represents the order from a costumer
	
	private List<BestellPosition> positions = new ArrayList<BestellPosition>();
	
	public Bestellung(){}
	
	public void addPosition(BestellPosition position){
		this.positions.add(position);
	}
	//this Method adds a new order position to the order
	//@parameter position must not be null
	
	public void drucken(){
		System.out.println(createOrderInfo());
	}
	//this Method prints the informations for all order
	//positions to the standartoutput
	
	private String createOrderInfo(){
		String tmp = "################################\n";
		tmp += "Bestellpositionen:\n";
		int count =1;
		
		for(BestellPosition p : positions){
			tmp += "Pos: "+count++ + " | " + p.toString()+ "\n";
		}
		tmp += "################################\n";
		return tmp;
	}
	//This Method creates and returns the information for all
	//order positions

	public List<BestellPosition> getPositions() {
		return positions;
	}
	//returns the List of BestellPositionen
}
