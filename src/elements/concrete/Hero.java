package elements.concrete;

import java.util.ArrayList;
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
	public String getName() {
		return "You";
	}

}
