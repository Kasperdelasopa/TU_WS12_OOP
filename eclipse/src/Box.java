
public class Box implements Pict {
// instances represent 2-dimensional pictures
// consisting of printable characters
	
	// breite, hoehe > 0
	protected Double breite;
	protected Double hoehe;
	// rand <> ' ' AND NOT empty
	protected Character rand;
	// inhalt NOT empty
	protected Character inhalt;
	
	// initializes and creates a new instance of Box
	// @param rand <> ' ' AND NOT empty
	// @param breite, hoehe > 0
	// @param inhalt NOT empty
	public Box(Double hoehe, Double breite, Character rand, Character inhalt){
				
			this.hoehe = hoehe;
			this.breite = breite;
			this.rand = rand;
			this.inhalt = inhalt;
		
	}
	
	// 0.1 <= factor <= 10.0; resize the picture
	@Override
	public void scale(double factor) {

		this.hoehe *= factor;
		this.breite *= factor;
		
	}
	
	// returns the picture as String
	@Override
	public String toString(){
		String ret="";
		Integer tbreite = (int) Math.ceil(this.breite);
		Integer thoehe = (int) Math.ceil(this.hoehe);
		
		for(Integer h = 1; h<=thoehe; h++) {
			
			for(Integer b = 1; b<=tbreite; b++){
				if(h.equals(1) || h.equals(thoehe)){
					ret += rand;
				}
				else{
					if(thoehe > 2){
						if(b.equals(1) || b.equals(tbreite)){
							ret += rand;
						}
						else{
							ret += inhalt;
						}
					}
					else{
						thoehe -= 1;
						continue;
					}				
				}
			}
			
			if(h != thoehe)
				ret += "\n";
		}
		
		return ret;
	}

}
