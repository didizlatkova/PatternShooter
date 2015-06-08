package command.concrete;

import visitor.abstracts.Position;
import command.abstracts.MoveCommand;

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
		this.newPosition = new Position(currentPosition.x - 1, currentPosition.y);
	}

	@Override
	public String getName() {
		return "up";
	}
}
