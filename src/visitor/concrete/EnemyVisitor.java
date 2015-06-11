package visitor.concrete;

import visitor.abstracts.Visitor;
import elements.abstracts.Tool;
import elements.abstracts.characters.Character;
import elements.abstracts.weapons.Weapon;
import engine.helpers.Logger;

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
		Logger.getInstance().printMessage(
				String.format("%s just found a(n) %s.", this.getName(),
						weapon.getName()));

		if (weapon.DAMAGE_POINTS > this.getWeapon().DAMAGE_POINTS) {
			this.setWeapon(weapon);
		}
	}

	@Override
	public void visit(Character character) {
		Logger.getInstance().printMessage(
				String.format("%s is attacking you with %s!", this.getName(),
						this.getWeapon().getName()));
		character.takeAttack(this.getWeapon());
	}

}
