package command.concrete;

import visitor.abstracts.Position;
import command.abstracts.MoveCommand;

public class LeftCommand extends MoveCommand {

	@Override
	public boolean outsideFieldBorders() {
		if (this.currentPosition.y == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public void setNewPosition() {
		this.newPosition = new Position(currentPosition.x, currentPosition.y - 1);
	}

	@Override
	public String getName() {
		return "left";
	}
}
