package command.concrete;

import visitor.abstracts.Position;
import command.abstracts.MoveCommand;

public class DownCommand extends MoveCommand {

	@Override
	public void checkFieldBorders() {
		if (this.currentPosition.x == this.field.getElements()[0].length - 1) {
			throw new IllegalStateException("Cannot move down!");
		}
	}

	@Override
	public void setNewPosition() {
		this.newPosition = new Position(currentPosition.x + 1,
				currentPosition.y);
	}

	@Override
	protected String getName() {
		return "down";
	}
}
