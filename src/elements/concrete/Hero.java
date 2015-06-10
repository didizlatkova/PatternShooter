package elements.concrete;

import java.util.ArrayList;

import strategy.abstracts.AttackStrategy;
import strategy.concrete.HeroAttackStrategy;
import visitor.concrete.HeroVisitor;
import command.abstracts.Command;
import command.concrete.CommandParser;
import elements.abstracts.*;
import engine.concrete.Field;

public class Hero extends HeroVisitor {

	public Hero(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
		this.weapons = new ArrayList<Weapon>();
		this.weapons.add(weapon);
		this.toolbox = new ArrayList<Tool>();
	}

	protected AttackStrategy getStrategy() {
		return new HeroAttackStrategy(this);
	}

	@Override
	public void takeTurn(Field field) {
		String input = CommandParser.getInstance().getScanner().nextLine();
		Command command = CommandParser.getInstance().getCommand(input);
		if (command != null) {
			this.bindCommand(command, field);
			command.execute();
		}
	}

	public Weapon getWeaponByName(String name) {
		for (Weapon weapon : weapons) {
			if (weapon.getName().toLowerCase().equals(name.toLowerCase())) {
				return weapon;
			}
		}

		return null;
	}

	@Override
	public String getName() {
		return "You";
	}

	@Override
	public String toString() {
		return "H";
	}

}
