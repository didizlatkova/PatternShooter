package elements.abstracts;

import elements.abstracts.weapons.Weapon;
import engine.helpers.ToolType;
import visitor.abstracts.Visitor;

public abstract class Tool extends Item {

	Tool handler;
	public ToolType type;

	public void nextHandler(Tool handler) {
		this.handler = handler;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public abstract int calculateDamage(Weapon weapon);

}
