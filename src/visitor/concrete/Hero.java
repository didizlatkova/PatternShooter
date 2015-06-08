package visitor.concrete;

import java.util.ArrayList;
import java.util.List;

import command.abstracts.Command;
import command.concrete.CommandParser;
import engine.concrete.Field;
import visitor.abstracts.*;
import visitor.abstracts.Character;

public class Hero extends Character {

	private List<Weapon> weapons;
	
	public Hero(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
		this.weapons = new ArrayList<Weapon>();
		this.weapons.add(weapon);
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

	@Override
	public void visit(Tool tool) {
		super.visit(tool);
		System.out.println("Congratulations! You just found a %s. It was added to your toolbox!");
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
