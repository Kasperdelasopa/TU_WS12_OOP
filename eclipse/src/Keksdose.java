import java.util.ArrayList;
import java.util.List;


public class Keksdose {
//This class represents a Keksdose which contains 
//all ordered Cookies
	private List<Crunchable> content = new ArrayList<Crunchable>();
	
	public  Keksdose(List<Crunchable> content){
		this.content = content;
	}
	//@parameter content must not be null
	
	private String createInhaltString(){
		
		String out = "";
		
		for(Crunchable c : content){
			out += c.toString() +"\n";
		}
		
		return out;
	}
	//This Method creates and returns a String with
	//the conent of this Keksdose
	
	public void inhalt(){
		System.out.println(this.createInhaltString());
	}
	//This Method prints the conetent of the Keksdose to the standardoutput
}
