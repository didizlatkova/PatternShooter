package proxy.concrete;

import command.abstracts.Command;
import command.concrete.CommandParser;
import elements.concrete.Hero;
import engine.concrete.Field;
import proxy.abstracts.TurnManager;

public class HeroTurnManager implements TurnManager {

	@Override
	public void takeTurn(Field field, Hero hero) {
		String input = CommandParser.getInstance().getScanner().nextLine();
		Command command = CommandParser.getInstance().getCommand(input);
		this.takeTurn(field, hero, command);
	}

	public void takeTurn(Field field, Hero hero, Command command) {
		if (command != null) {
			hero.bindCommand(command, field);
			command.execute();
		}
	}

}
