package command.concrete;

import command.abstracts.CharacterCommand;
import command.abstracts.Command;
import elements.abstracts.*;
import elements.abstracts.characters.Character;
import elements.concrete.Hero;
import engine.helpers.Logger;

public class EquiptCommand implements Command, CharacterCommand {

	private Hero character;
	private String toolName;

	public void setCharacter(Character character) {
		this.character = (Hero) character;
	}

	public EquiptCommand(String toolName) {
		this.toolName = toolName;
	}

	@Override
	public void execute() {
		Item tool = (this.character).getItemByName(toolName);
		if (tool != null && tool instanceof Tool) {
			if (!this.character.isUsing(((Tool) tool).getType())) {
				this.character.toolsInUse.add((Tool) tool);
				Logger.getInstance()
						.printMessage(tool.getName() + " equipped!");
			} else {
				Logger.getInstance()
						.printMessage(
								"You are already using a(n) "
										+ ((Tool) tool).getType());
			}
		} else {
			Logger.getInstance().printMessage(
					String.format("You don't have %s!", this.toolName));
		}
	}

}
