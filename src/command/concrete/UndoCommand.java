package command.concrete;

import command.abstracts.Command;
import elements.abstracts.characters.Character;
import engine.concrete.Engine;
import engine.concrete.Field;
import engine.helpers.FieldCaretaker;
import engine.helpers.Logger;

public class UndoCommand implements Command {

	private Field field;

	public void setField(Field field) {
		this.field = field;
	}

	@Override
	public void setCharacter(Character character) {
		// not needed
	}

	@Override
	public void execute() {
		if (FieldCaretaker.getInstance().canUndo()) {
			FieldCaretaker.getInstance().restoreField(this.field);
			Engine.getInstance().setFieldUndone();
		} else {
			Logger.getInstance().printMessage("Cannot undo!");
		}
	}
}
