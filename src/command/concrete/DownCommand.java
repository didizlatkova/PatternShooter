package command.concrete;

import command.abstracts.MoveCommand;
import elements.abstracts.Position;

public class DownCommand extends MoveCommand {

	@Override
	public boolean outsideFieldBorders() {
		if (this.currentPosition.x == this.field.getElements()[0].length - 1) {
			return true;
		}
		
		return false;
	}

	@Override
	public void setNewPosition() {
		this.newPosition = new Position(currentPosition.x + 1,
				currentPosition.y);
	}

	@Override
	public String getName() {
		return "down";
	}
}
