package elements.abstracts;

import visitor.abstracts.Visitor;


public abstract class Weapon extends Item {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
