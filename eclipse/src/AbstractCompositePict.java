
public abstract class AbstractCompositePict<P> implements Pict {
	// instances represent compositions of 2-dimensional pictures
	// consists of objects of type P that have a string representation
	
	protected final static String LINE_FEED = "\n";
	// constant holding the line feed for performance reasons
	
	protected P[][] inhalt;
	// inhalt != null;
	// inhalt.length > 0;
	// objects that form the picture composition
	
	public AbstractCompositePict(P[][] inhalt) {
		this.inhalt = inhalt;
	}
	// inhalt != null; 
	// initializes the content array
	
	@Override
	public String toString() {
		int inhaltWidth = inhalt[0].length;
		int inhaltHeight = inhalt.length;
		int inhaltMaxLength = getInhaltMaxLength();
		int inhaltMaxHeight = getInhaltMaxHeight();
		java.util.ArrayList<StringBuffer> lines = new java.util.ArrayList<StringBuffer> ();
		
		for(int i = 0; i < inhaltHeight; i++) {
			int lineIndex = lines.size();
			
			for(int j = 0; j < inhaltWidth; j++) {
				String[] elemLines = inhalt[i][j].toString().split(LINE_FEED);
				
				for(int k = 0; k < elemLines.length; k++) {
					try {
						lines.get(k + lineIndex).append(elemLines[k]);
						// fill up white-space padding
						for(int l = elemLines[k].length(); l < inhaltMaxLength; l++) {
							lines.get(k + lineIndex).append(" ");
						}
						
					} catch(IndexOutOfBoundsException exception) {
						lines.add(new StringBuffer(elemLines[k]));
						// fill up white-space padding
						for(int l = elemLines[k].length(); l < inhaltMaxLength; l++) {
							lines.get(k + lineIndex).append(" ");
						}
					}
				}
				// fill up blank lines (padding)
				for(int k = elemLines.length; k < inhaltMaxHeight; k++) {
					StringBuffer emptyLine = new StringBuffer();
					
					for(int l = 0; l < inhaltMaxLength; l++) {
						emptyLine.append(" ");
					}
					
					try {
						lines.get(k + lineIndex).append(emptyLine);
					} catch(IndexOutOfBoundsException exception) {
						lines.add(emptyLine);
					}
				}
			}
		}
		
		// NOTE put the whole string together
		StringBuffer sb = new StringBuffer();
		for(StringBuffer line : lines) {
			sb.append(line);
			sb.append(LINE_FEED);
		}
		return sb.toString();
	}
	// returns the picture as String
	
	public abstract void scale(double factor);
	// 0.1 <= factor <= 10.0; resize the picture composition
	
	protected int getInhaltMaxLength() {
		int max = 0;
		
		for(P[] lines : inhalt) {
			for(P column : lines) {
				for(String elemLine : column.toString().split(LINE_FEED)) {
					if(elemLine.length() > max) {
						max = elemLine.length();
					}
				}
			}
		}
		return max;
	}
	// returns the maximum line width of all objects in inhalt
	
	protected int getInhaltMaxHeight() {
		int max = 0;
		
		for(P[] lines : inhalt) {
			for(P column : lines) {
				String[] elemLines = column.toString().split(LINE_FEED);
				if(elemLines.length > max) {
					max = elemLines.length;
				}
			}
		}
		return max;
	}
	// returns the highest line number per object of all objects in inhalt
}
