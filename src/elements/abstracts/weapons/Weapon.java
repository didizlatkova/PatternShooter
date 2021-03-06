package elements.abstracts.weapons;

import elements.abstracts.Item;
import engine.helpers.Logger;
import visitor.abstracts.Visitor;

public abstract class Weapon extends Item {

	public final int DAMAGE_POINTS;

	public Weapon(int damagePoints) {
		this.DAMAGE_POINTS = damagePoints;
	}

	public void fire() {
		Logger.getInstance().printMessage(
				String.format("Attacking with %s!", this.getName()));
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
