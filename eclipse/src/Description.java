
public class Description implements Shorter<Description>{
	// instances represent a text
	
	private String text;
	// text != "" && text != null;
	
	public Description(String text){
		this.text=text;
	}
	// initializes and creates a new instance of Description
	// @param text != "" && text != null;
	
	public int getLineCount() {
		String [] inhalt = text.split("\n");
		return inhalt.length;
	}
	// returns number of lines from text
	
	@Override
	public boolean shorter(Description element) {
		if(this.toString().length() < element.toString().length()) return true;
		return false;
	}
	// @param element != null;
	// returns true if text of current instance is shorter than element.
	
	@Override
	public String toString() {
		return text;
	}
	// returns text
}
