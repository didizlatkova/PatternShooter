package command.concrete;

import visitor.abstracts.Position;
import command.abstracts.MoveCommand;

public class LeftCommand extends MoveCommand {

	@Override
	public void checkFieldBorders() {
		if (this.currentPosition.y == 0) {
			throw new IllegalStateException("Cannot move to the left!");
		}
	}

	@Override
	public void setNewPosition() {
		this.newPosition = new Position(currentPosition.x, currentPosition.y - 1);
	}

	@Override
	protected String getName() {
		return "left";
	}
}
