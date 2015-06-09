package command.concrete;

import java.util.ArrayList;
import java.util.List;

import command.abstracts.Command;
import elements.abstracts.Character;
import elements.abstracts.Enemy;
import elements.abstracts.MultipleDamageWeapon;
import elements.abstracts.Position;
import engine.concrete.Field;

public class AttackCommand implements Command {

	private Field field;
	private Character character;
	private Position currentPosition;

	public void setField(Field field) {
		this.field = field;
	}

	public void setCharacter(Character character) {
		this.character = character;
		this.currentPosition = character.getPosition();
	}

	private List<Enemy> getSurroundingEnemies() {
		List<Enemy> enemies = new ArrayList<Enemy>();

		for (int i = this.currentPosition.x - 1; i < this.currentPosition.x + 2; i++) {
			for (int j = this.currentPosition.y - 1; j < this.currentPosition.y + 2; j++) {
				Position enemyPosition = new Position(i, j);
				if (field.isInside(enemyPosition)
						&& !enemyPosition.equals(currentPosition)
						&& field.getElements()[enemyPosition.x][enemyPosition.y] instanceof Enemy) {
					enemies.add((Enemy) field.getElements()[enemyPosition.x][enemyPosition.y]);
				}
			}
		}

		return enemies;
	}

	@Override
	public void execute() {
		List<Enemy> surroundingEnemies = this.getSurroundingEnemies();
		if (surroundingEnemies.isEmpty()) {
			System.out.println("No enemies near you. Cannot attack!");
			return;
		}

		if (this.character.getWeapon() instanceof MultipleDamageWeapon) {
			for (Enemy enemy : surroundingEnemies) {
				enemy.accept(this.character);
			}
		} else {
			surroundingEnemies.get(0).accept(this.character);
		}
	}

}
