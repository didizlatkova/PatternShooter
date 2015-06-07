package command.abstracts;

import visitor.abstracts.Character;
import engine.concrete.Field;

public abstract class MoveCommand implements Command {

	private Field field;
	private Character character;

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	@Override
	public abstract void execute();

}
