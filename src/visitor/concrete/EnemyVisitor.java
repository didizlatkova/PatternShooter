package visitor.concrete;

import visitor.abstracts.Visitor;
import elements.abstracts.Character;
import elements.abstracts.Tool;
import elements.abstracts.Weapon;

public abstract class EnemyVisitor extends Character {

	public EnemyVisitor(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void visit(Tool tool) {
		// do nothing since enemies cannot use tools
	}

	@Override
	public void visit(Weapon weapon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Character character) {
		// TODO Auto-generated method stub

	}

}
