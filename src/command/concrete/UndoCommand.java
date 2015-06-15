package command.concrete;

import command.abstracts.*;
import engine.concrete.*;
import engine.helpers.*;

public class UndoCommand implements Command, FieldCommand {

	private Field field;

	public void setField(Field field) {
		this.field = field;
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
