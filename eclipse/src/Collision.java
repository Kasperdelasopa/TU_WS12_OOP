
public class Collision {

	private Auto auto;
	private CollisionType collisionType;
	
	public Collision(Auto auto, CollisionType type){
		this.auto = auto;
		this.collisionType = type;
		
	}

	public Auto getAuto() {
		return auto;
	}
	//If no collision (collisionType = CollisionType.KeinAufprall) appeared return is null
	
	public CollisionType getCollisionType() {
		return collisionType;
	}
	//returns the CollisionType of the Collision
	
}
