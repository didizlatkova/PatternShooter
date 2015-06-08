package command.concrete;

import visitor.abstracts.Position;
import command.abstracts.MoveCommand;

public class RightCommand extends MoveCommand {

	@Override
	public void checkFieldBorders() {
		if (this.currentPosition.y == this.field.getElements()[0].length - 1) {
			throw new IllegalStateException("Cannot move right!");
		}
	}

	@Override
	public void setNewPosition() {
		this.newPosition = new Position(currentPosition.x,
				currentPosition.y + 1);
	}

	@Override
	protected String getName() {
		return "right";
	}
}
