package command.concrete;

import command.abstracts.Command;
import elements.abstracts.*;
import elements.abstracts.characters.Character;
import elements.concrete.Hero;

public class EquiptCommand implements Command {

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
			if (!this.character.isUsing(((Tool) tool).type)) {
				this.character.toolsInUse.add((Tool) tool);
				System.out.println(tool.getName() + " equipped!");
			} else {
				System.out.println("You are already using a(n) "
						+ ((Tool) tool).type);
			}
		} else {
			System.out.println(String.format("You don't have %s!",
					this.toolName));
		}
	}

}
