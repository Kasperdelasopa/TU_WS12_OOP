public class Scaled<P extends Pict> extends AbstractCompositePict<P> {

	public Scaled(P[][] inhalt) {
		this.inhalt = inhalt;
	}

	@Override
	public String toString() {
		StringBuilder stringRep = new StringBuilder();
		
		for(P[] row : inhalt) {
			for(P column : row) {
				stringRep.append(column.toString());
			}
			
		}
		
		return stringRep.toString();
	}

	@Override
	public void scale(double factor) {
		for (P[] row : inhalt) {
			for (P column : row) {
				column.scale(factor);
			}
		}
	}

}
