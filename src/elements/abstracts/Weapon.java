package elements.abstracts;

import visitor.abstracts.Visitor;


public abstract class Weapon extends Item {

	public final int DAMAGE_POINTS;

	public Weapon(int damagePoints){
		this.DAMAGE_POINTS = damagePoints;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
