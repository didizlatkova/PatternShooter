package visitor.concrete;

import command.abstracts.Command;
import command.concrete.CommandParser;
import engine.concrete.Field;
import visitor.abstracts.*;
import visitor.abstracts.Character;

public class Hero extends Character {

	public Hero(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

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

}
