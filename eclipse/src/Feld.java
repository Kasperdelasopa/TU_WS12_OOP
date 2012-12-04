import java.util.ArrayList;
import java.util.List;


public class Feld {
	
	public Feld Nord = null;
	public Feld NordOst = null;
	public Feld Ost = null;
	public Feld SuedOst = null;
	public Feld Sued = null;
	public Feld SuedWest = null;
	public Feld West = null;
	public Feld NordWest = null;
	
	public List<Auto> autos = new ArrayList<Auto>();
	
	public Feld(){
		
	}

	public synchronized List<Collision> moveIn(Auto auto){
		
		List<Collision> collisions = new ArrayList<Collision>();
		
		if(autos.size() > 0)
		{
			for(Auto a : autos){
				
				if(a.getRichtung() == Fahrtrichtung.Nord){
					if(auto.getRichtung() == Fahrtrichtung.Sued)
						collisions.add(new Collision(a, CollisionType.Frontalaufprall));
					else
						collisions.add(new Collision(a, CollisionType.SeitenOderHeckaufprall));					
				}
				else if(a.getRichtung() == Fahrtrichtung.Ost){
					if(auto.getRichtung() == Fahrtrichtung.West)
						collisions.add(new Collision(a, CollisionType.Frontalaufprall));
					else
						collisions.add(new Collision(a, CollisionType.SeitenOderHeckaufprall));
				}
				else if(a.getRichtung() == Fahrtrichtung.Sued){
					if(auto.getRichtung() == Fahrtrichtung.Nord)
						collisions.add(new Collision(a, CollisionType.Frontalaufprall));
					else
						collisions.add(new Collision(a, CollisionType.SeitenOderHeckaufprall));
				}
				else if(a.getRichtung() == Fahrtrichtung.West){
					if(auto.getRichtung() == Fahrtrichtung.Ost)
						collisions.add(new Collision(a, CollisionType.Frontalaufprall));
					else
						collisions.add(new Collision(a, CollisionType.SeitenOderHeckaufprall));
				}
			}
		}
		else
			collisions.add(new Collision(null, CollisionType.KeinAufprall));
		
		this.autos.add(auto);
		return collisions;
	}
	//Fahrtrichting has to be updated before visiting this Method
	//Method returners the collisions with each Auto in Feld
	
	public synchronized void moveOut(Auto auto){
		this.autos.remove(auto);
	}
	//Methods removes the given Auto from this Feld
}
