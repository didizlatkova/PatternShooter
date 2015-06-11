package visitor.concrete;

import java.util.List;

import visitor.abstracts.Visitor;
import elements.abstracts.Item;
import elements.abstracts.Tool;
import elements.abstracts.characters.Character;
import elements.abstracts.weapons.Weapon;

public abstract class HeroVisitor extends Character {

	protected List<Item> toolbox;

	public HeroVisitor(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void visit(Tool tool) {
		this.toolbox.add(tool);
		System.out
				.println(String
						.format("Congratulations! You just found a(n) %s. It was added to your toolbox!",
								tool.getName()));
	}

	@Override
	public void visit(Weapon weapon) {
		this.toolbox.add(weapon);
		System.out
				.println(String
						.format("Congratulations! You just found a(n) %s. It was added to your weapons!",
								weapon.getName()));
	}

	@Override
	public void visit(Character character) {
		System.out.println(String.format("Attacking %s with %s!",
				character.getName(), this.getWeapon().getName()));
		character.takeAttack(this.getWeapon());
	}

}
