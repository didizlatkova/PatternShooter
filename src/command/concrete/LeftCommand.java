package command.concrete;

import visitor.abstracts.Position;
import command.abstracts.MoveCommand;

public class LeftCommand extends MoveCommand {

	@Override
	public void execute() {
		if (this.getCharacter().getPosition().y == 0) {
			throw new IllegalStateException("Cannot move to the left!");
		}

		Position currentPosition = this.getCharacter().getPosition();
		this.getField().moveCharacter(this.getCharacter(),
				new Position(currentPosition.x, currentPosition.y - 1));
	}

}
