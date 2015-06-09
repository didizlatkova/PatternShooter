package command.abstracts;

import elements.abstracts.Character;
import elements.abstracts.FieldElement;
import elements.abstracts.Position;
import elements.abstracts.Tool;
import elements.concrete.*;
import engine.concrete.Field;

public abstract class MoveCommand implements Command {

	protected Field field;
	private Character character;
	protected Position currentPosition;
	protected Position newPosition;

	public void setField(Field field) {
		this.field = field;
	}

	public void setCharacter(Character character) {
		this.character = character;
		this.currentPosition = character.getPosition();
	}

	@Override
	// Template method
	public void execute() {
		this.setNewPosition();
		FieldElement visited = this.field.getElements()[this.newPosition.x][this.newPosition.y];
		if (!isMovePossible()) {
			System.out
					.println(String.format("Cannot move %s!", this.getName()));
			return;
		}
		this.moveCharacter();
		if (visited != null) {
			visited.accept(this.character);
		}
	}

	public boolean isMovePossible() {
		if (this.character instanceof Hero) {
			return !this.outsideFieldBorders()
					&& !this.clashesWithNeighborCharacter();
		}

		return !this.outsideFieldBorders()
				&& !this.clashesWithNeighborCharacter()
				&& !this.clashesWithTool();

	}

	public abstract boolean outsideFieldBorders();

	public abstract void setNewPosition();

	public abstract String getName();

	public boolean clashesWithTool() {
		if (this.field.getElements()[newPosition.x][newPosition.y] instanceof Tool) {
			return true;
		}

		return false;
	}

	public boolean clashesWithNeighborCharacter() {
		if (this.field.getElements()[newPosition.x][newPosition.y] instanceof Character) {
			return true;
		}

		return false;
	}

	public void moveCharacter() {
		this.field.moveCharacter(this.character, newPosition);
	}

}
