package strategy.concrete;

import java.util.ArrayList;
import java.util.List;

import elements.abstracts.*;
import elements.abstracts.characters.Character;
import elements.abstracts.characters.Enemy;
import elements.abstracts.weapons.MultipleDamageWeapon;
import engine.helpers.Logger;
import strategy.abstracts.AttackStrategy;

public class HeroAttackStrategy extends AttackStrategy {

	private Position currentPosition;

	public HeroAttackStrategy(Character character) {
		super(character);
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
	public void attack() {
		List<Enemy> surroundingEnemies = this.getSurroundingEnemies();
		if (surroundingEnemies.isEmpty()) {
			Logger.getInstance().printMessage(
					"No enemies near you. Cannot attack!");
			return;
		}

		this.character.getWeapon().fire();
		if (this.character.getWeapon() instanceof MultipleDamageWeapon) {
			for (Enemy enemy : surroundingEnemies) {
				enemy.accept(this.character);
			}
		} else {
			surroundingEnemies.get(0).accept(this.character);
		}
	}

}
