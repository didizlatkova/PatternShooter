package elements.abstracts.characters;

import java.util.ArrayList;
import java.util.List;

import strategy.abstracts.AttackStrategy;
import strategy.concrete.EnemyAttackStrategy;
import visitor.concrete.EnemyVisitor;
import command.abstracts.MoveCommand;
import command.concrete.*;
import elements.abstracts.Position;
import elements.abstracts.weapons.Weapon;
import elements.concrete.Hero;
import engine.concrete.Field;
import engine.helpers.RandomGenerator;

public abstract class Enemy extends EnemyVisitor {

	public Enemy(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
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

	protected AttackStrategy getStrategy() {
		return new EnemyAttackStrategy();
	}

	@Override
	public void takeTurn(Field field) {
		if (this.isHeroInReach(field)) {
			AttackCommand command = new AttackCommand();
			this.bindCommand(command, field);
			command.execute();
		} else {
			List<MoveCommand> possibleMoves = this.getPossibleMoves(field);
			if (possibleMoves.isEmpty()) {
				return;
			}

			RandomGenerator.getInstance().getCommand(possibleMoves).execute();
		}
	}

	private boolean isHeroInReach(Field field) {
		for (int i = position.x - 1; i < position.x + 2; i++) {
			for (int j = position.y - 1; j < position.y + 2; j++) {
				Position heroPosition = new Position(i, j);
				if (field.isInside(heroPosition)
						&& field.getElements()[heroPosition.x][heroPosition.y] instanceof Hero) {
					return true;
				}
			}
		}

		return false;
	}

	public void takeAttack(Weapon weapon) {
		this.damagePoints = weapon.DAMAGE_POINTS;
		super.takeAttack(weapon);
	}

	@Override
	public String toString() {
		return "E ";
	}

}
