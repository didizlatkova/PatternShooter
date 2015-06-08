package command.concrete;

import visitor.abstracts.Position;
import command.abstracts.MoveCommand;

public class UpCommand extends MoveCommand {

	@Override
	public void checkFieldBorders() {
		if (this.currentPosition.x == 0) {
			throw new IllegalStateException("Cannot move up!");
		}
	}

	@Override
	public void setNewPosition() {
		this.newPosition = new Position(currentPosition.x - 1, currentPosition.y);
	}

	@Override
	protected String getName() {
		return "up";
	}
}
