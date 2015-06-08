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
	}
	
	public void setCurrentPosition(Position position) {
		this.currentPosition = position;
	}

	@Override
	public void execute() {
		this.setCurrentPosition(this.character.getPosition());
		this.checkFieldBorders();
		this.setNewPosition();
		this.checkNeighborCharacter();
		this.moveCharacter();
	}

	public abstract void checkFieldBorders();

	public abstract void setNewPosition();
	
	protected abstract String getName();

	public void checkNeighborCharacter() {
		if (this.field.getElements()[newPosition.x][newPosition.y] instanceof Character) {
			throw new IllegalStateException(String.format(
					"Cannot move to the %s!", this.getName()));
		}
	}

	public void moveCharacter() {
		this.field.moveCharacter(this.character, newPosition);
	}		

}
