
public class Description<P> implements Shorter<P>{

	private String text;
	
	public Description(P element){
		this.text=element.toString();
	}
	
	public int getLineCount() {
		String [] inhalt = text.split("\n");
		return inhalt.length;
	}
	
	@Override
	public boolean shorter(P element) {
		if(this.toString().length() < element.toString().length()) return true;
		return false;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
