package command.concrete;

import command.abstracts.MoveCommand;
import elements.abstracts.Position;

public class UpCommand extends MoveCommand {

	@Override
	public boolean outsideFieldBorders() {
		if (this.currentPosition.x == 0) {
			return true;
		}

		return false;
	}

	@Override
	public void setNewPosition() {
		this.newPosition = new Position(currentPosition.x - 1,
				currentPosition.y);
	}

	@Override
	public String getName() {
		return "up";
	}
}
