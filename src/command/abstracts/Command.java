package command.abstracts;

import elements.abstracts.characters.Character;

public interface Command {

	public void execute();

	public void setCharacter(Character character);

}
