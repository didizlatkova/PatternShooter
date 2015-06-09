package elements.abstracts;

import java.util.ArrayList;
import java.util.List;

import visitor.concrete.EnemyVisitor;
import command.abstracts.MoveCommand;
import command.concrete.*;
import engine.concrete.Field;
import engine.concrete.RandomGenerator;

public abstract class Enemy extends EnemyVisitor {

	public Enemy(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
	}

	@Override
	public void takeTurn(Field field) {
		List<MoveCommand> possibleMoves = this.getPossibleMoves(field);

		RandomGenerator.getInstance().getCommand(possibleMoves).execute();
	}

	private List<MoveCommand> getPossibleMoves(Field field) {
		List<MoveCommand> commands = new ArrayList<MoveCommand>();
		commands.add(new LeftCommand());
		commands.add(new RightCommand());
		commands.add(new UpCommand());
		commands.add(new DownCommand());

		List<MoveCommand> possibleMoves = new ArrayList<MoveCommand>();

		for (MoveCommand moveCommand : commands) {
			moveCommand.setField(field);
			moveCommand.setCharacter(this);
			moveCommand.setNewPosition();
			if (moveCommand.isMovePossible()) {
				possibleMoves.add(moveCommand);
			}
		}

		return possibleMoves;
	}
	
	@Override
	public String toString() {
		return "E";
	}

}
