package elements.concrete;

import java.util.ArrayList;
import java.util.List;

import strategy.abstracts.AttackStrategy;
import strategy.concrete.HeroAttackStrategy;
import visitor.concrete.HeroVisitor;
import command.abstracts.Command;
import command.concrete.CommandParser;
import elements.abstracts.*;
import engine.concrete.Field;
import engine.helpers.ToolType;

public class Hero extends HeroVisitor {

	public List<Tool> toolsInUse;

	public Hero(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
		this.toolbox = new ArrayList<Item>();
		this.toolbox.add(weapon);
		this.toolsInUse = new ArrayList<Tool>();
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

	public Item getItemByName(String name) {
		for (Item item : toolbox) {
			if (item.getName().toLowerCase().equals(name.toLowerCase())) {
				return item;
			}
		}

		return null;
	}

	public boolean isUsing(ToolType type) {
		for (Tool tool : toolsInUse) {
			if (tool.type.equals(type)) {
				return true;
			}
		}

		return false;
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
