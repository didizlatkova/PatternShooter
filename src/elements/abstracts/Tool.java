package elements.abstracts;

import elements.abstracts.weapons.Weapon;
import engine.helpers.ToolType;
import visitor.abstracts.Visitor;

public abstract class Tool extends Item {

	protected Tool handler;

	public void nextHandler(Tool handler) {
		this.handler = handler;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public abstract ToolType getType();

	public int calculateDamage(Weapon weapon, int damagePoints) {
		if (this.handler != null) {
			return this.handler.calculateDamage(weapon, damagePoints);
		}

		return damagePoints;
	}

}
