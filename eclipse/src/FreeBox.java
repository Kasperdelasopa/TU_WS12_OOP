
public class FreeBox implements Pict{

	private Double hoehe;
	private Double breite;
	private String text;
	
	
	// all lines from text must have the same length
	public FreeBox(String text){
		
		String []inhalt = text.split("\n");
		hoehe = (double)inhalt.length;
		breite = (double)inhalt[0].length();
		this.text=text;
		

	}
	
	// 0.1 <= factor <= 10.0; resize the picture
	@Override
	public void scale(double factor) {
		/* testing 
		int oldbreite = breite.intValue();
		hoehe *= factor;
		breite *= factor;
		
		String []inhalt = text.split("\n");
		
		int tbreite=  (int) Math.ceil(this.breite);
		
		
		String newtext = inhalt[0] + inhalt[0].substring(0,tbreite-oldbreite) + "\n";
		String newtext = inhalt[1] + inhalt[1].substring(0,tbreite-oldbreite) + "\n";
		String newtext = inhalt[2] + inhalt[2].substring(0,tbreite-oldbreite) + "\n";
		
		
		text=newtext;
		
			*/
	}
	

	@Override
	public String toString(){
		
		return text;
	
	}
	
	
}
