
public class Description implements Shorter<Description>{

	private String text;
	
	public Description(String text){
		this.text=text;
	}
	
	public int getLineCount() {
		String [] inhalt = text.split("\n");
		return inhalt.length;
	}
	
	@Override
	public boolean shorter(Description element) {
		if(this.toString().length() < element.toString().length()) return true;
		return false;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
