package command.abstracts;

import visitor.abstracts.Character;
import visitor.abstracts.Position;
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
		if (!isMovePossible()) {
			System.out
					.println(String.format("Cannot move %s!", this.getName()));
			return;
		}
		this.moveCharacter();
	}

	public boolean isMovePossible() {
		return !this.outsideFieldBorders()
				&& !this.clashesWithNeighborCharacter();
	}

	public abstract boolean outsideFieldBorders();

	public abstract void setNewPosition();

	public abstract String getName();

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
