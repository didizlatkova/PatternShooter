package strategy.concrete;

import java.util.ArrayList;
import java.util.List;

import elements.abstracts.*;
import elements.abstracts.characters.Character;
import elements.abstracts.characters.Enemy;
import elements.abstracts.weapons.MultipleDamageWeapon;
import elements.concrete.Hero;
import engine.helpers.Logger;
import strategy.abstracts.AttackStrategy;

public class HeroAttackStrategy extends AttackStrategy {

	private List<Enemy> getSurroundingEnemies(Position currentPosition) {
		List<Enemy> enemies = new ArrayList<Enemy>();

		for (int i = currentPosition.x - 1; i < currentPosition.x + 2; i++) {
			for (int j = currentPosition.y - 1; j < currentPosition.y + 2; j++) {
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
	public void attack(Character character) {
		if (((Hero) character).canAttack()) {
			List<Enemy> surroundingEnemies = this.getSurroundingEnemies(character.getPosition());
			if (surroundingEnemies.isEmpty()) {
				Logger.getInstance().printMessage(
						"No enemies near you. Cannot attack!");
				return;
			}

			character.getWeapon().fire();
			if (character.getWeapon() instanceof MultipleDamageWeapon) {
				for (Enemy enemy : surroundingEnemies) {
					enemy.accept(character);
				}
			} else {
				surroundingEnemies.get(0).accept(character);
			}
		} else {
			Logger.getInstance().printMessage(
					"Sorry you are captured and can't attack!");
		}
	}

}
