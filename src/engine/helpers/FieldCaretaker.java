package engine.helpers;

import java.util.Stack;

import engine.concrete.Engine;
import engine.concrete.Field;
import engine.concrete.Engine.FieldMemento;

public class FieldCaretaker {

	private static FieldCaretaker instance = new FieldCaretaker();

	private FieldCaretaker() {
		this.mementos = new Stack<FieldMemento>();
	};

	public static FieldCaretaker getInstance() {
		return instance;
	}

	private Stack<FieldMemento> mementos;
	private FieldMemento currentField;

	public void saveField(Field field) {
		if (currentField != null) {
			this.mementos.push(currentField);
		}

		currentField = Engine.getInstance().saveField();
	}

	public void restoreField(Field field) {
		Engine.getInstance().restoreField(this.mementos.pop());
	}

	public boolean canUndo() {
		return !this.mementos.isEmpty();
	}

}
