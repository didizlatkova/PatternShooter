package command.concrete;

import visitor.abstracts.Position;
import command.abstracts.MoveCommand;
import visitor.abstracts.Character;

public class LeftCommand extends MoveCommand {

	@Override
	public void execute() {
		if (this.getCharacter().getPosition().y == 0) {
			throw new IllegalStateException("Cannot move to the left!");
		}
		
		Position currentPosition = this.getCharacter().getPosition();
		Position newPosition = new Position(currentPosition.x, currentPosition.y - 1);
				
		if(this.getField().getElements()[newPosition.x][newPosition.y] instanceof Character){
			throw new IllegalStateException("Cannot move to the left!");
		}
		
		this.getField().moveCharacter(this.getCharacter(),
				newPosition);
	}
}
