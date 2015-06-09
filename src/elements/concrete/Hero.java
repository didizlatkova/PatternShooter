package elements.concrete;

import java.util.ArrayList;
import java.util.List;

import command.abstracts.Command;
import command.concrete.CommandParser;
import elements.abstracts.*;
import elements.abstracts.Character;
import engine.concrete.Field;

public class Hero extends Character {

	private List<Weapon> weapons;

	public List<Tool> toolbox;

	public Hero(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
		this.weapons = new ArrayList<Weapon>();
		this.weapons.add(weapon);
		this.toolbox = new ArrayList<Tool>();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "H";
	}

	@Override
	public void takeTurn(Field field) {
		String input = CommandParser.getInstance().getScanner().nextLine();
		Command command = CommandParser.getInstance().getCommand(input);
		field.bindCommand(command, this);
		command.execute();
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
		this.weapons.add(weapon);
		System.out
				.println(String
						.format("Congratulations! You just found a(n) %s. It was added to your weapons!",
								weapon.getName()));
	}

	@Override
	public void visit(Character character) {
		System.out.println(String.format("Attacking %s with %s!",
				character.getName(), this.getWeapon().getName()));
	}

	@Override
	public String getName() {
		return "Hero";
	}

}
