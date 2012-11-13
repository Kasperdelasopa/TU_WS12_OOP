
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
		int oldbreite = (int) Math.ceil(breite);
		int oldhoehe = (int) Math.ceil(hoehe);
		hoehe *= factor;
		breite *= factor;
		
		String []inhalt = text.split("\n");
		
		int tbreite=  (int) Math.ceil(breite);
		int thoehe=  (int) Math.ceil(hoehe);
		
		String newtext="";
		
		for(int ho=0; ho<thoehe; ho++){
			
			for(int br=0; br<tbreite; br++){
				newtext+=inhalt[ho%oldhoehe].charAt(br%oldbreite);
			}
			if(ho<thoehe-1) newtext+="\n";
		}				
		text=newtext;		
			
	}	

	@Override
	public String toString(){
		
		return text;
	
	}
	
	
}
