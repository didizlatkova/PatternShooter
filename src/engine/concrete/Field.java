package engine.concrete;

import java.util.ArrayList;
import java.util.List;

import elements.abstracts.*;
import elements.abstracts.characters.Character;
import elements.abstracts.characters.Enemy;
import elements.concrete.*;
import engine.helpers.Logger;
import engine.helpers.RandomGenerator;
import factory.abstracts.ZoneFactory;

public class Field {

	private FieldElement[][] elements;
	private List<Enemy> enemies;
	private List<Item> items;
	private Hero hero;
	private RandomGenerator generator;

	public FieldElement[][] getElements() {
		return this.elements;
	}

	public List<Enemy> getEnemies() {
		return this.enemies;
	}

	public Hero getHero() {
		return this.hero;
	}

	private void setElements(int height, int width) {
		this.elements = new FieldElement[height][width];

		this.enemies.get(0).setPosition(new Position(0, 0), elements);
		this.enemies.get(1).setPosition(new Position(0, width - 1), elements);
		this.enemies.get(2).setPosition(new Position(height - 1, 0), elements);
		this.enemies.get(3).setPosition(new Position(height - 1, width - 1),
				elements);

		this.hero.setPosition(new Position(height / 2, width / 2), elements);

		int[] freePosition = new int[2];
		for (int i = 0; i < this.items.size(); i++) {
			freePosition = generator.getFreeFieldPosition(this.elements);
			this.elements[freePosition[0]][freePosition[1]] = this.items.get(i);
		}
	}

	public Field(int width, int height, ZoneFactory factory) {
		this.generator = RandomGenerator.getInstance();
		this.enemies = factory.createEnemies();
		this.hero = factory.createHero();
		this.items = factory.createItems();
		this.setElements(height, width);
	}

	public void moveCharacter(Character character, Position newPosition) {
		this.elements[character.getPosition().x][character.getPosition().y] = null;
		character.setPosition(newPosition, this.elements);
	}

	public boolean isInside(Position position) {
		if (position.x < 0 || position.x >= this.elements.length) {
			return false;
		}

		if (position.y < 0 || position.y >= this.elements[0].length) {
			return false;
		}

		return true;
	}

	public boolean isHeroInReach(Position position) {
		for (int i = position.x - 1; i < position.x + 2; i++) {
			for (int j = position.y - 1; j < position.y + 2; j++) {
				Position heroPosition = new Position(i, j);
				if (this.isInside(heroPosition)
						&& this.getElements()[heroPosition.x][heroPosition.y] instanceof Hero) {
					return true;
				}
			}
		}

		return false;
	}

	public void removeDeadEnemies() {
		List<Enemy> enemiesToRemove = new ArrayList<Enemy>();
		for (Enemy enemy : this.enemies) {
			if (enemy.getHealthPoints() == 0) {
				this.elements[enemy.getPosition().x][enemy.getPosition().y] = null;
				enemiesToRemove.add(enemy);
			}
		}

		for (Enemy enemy : enemiesToRemove) {
			this.enemies.remove(enemy);
		}

		Logger.getInstance().printMessage(
				"Enemies left: " + this.enemies.size());
	}

	public void checkForWin() {
		if (this.enemies.isEmpty()) {
			Logger.getInstance().printMessage("You win!");
			Engine.getInstance().gameOver();
		}
	}

	public void checkForLoss() {
		if (this.hero.getHealthPoints() == 0) {
			Logger.getInstance().printMessage("You lost!");
			Engine.getInstance().gameOver();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < elements[0].length; j++) {
			sb.append("---");
		}
		sb.append("-\n");

		for (int i = 0; i < elements.length; i++) {
			sb.append("|");
			for (int j = 0; j < elements[i].length; j++) {
				if (elements[i][j] == null) {
					sb.append("  ");
				} else {
					sb.append(elements[i][j].toString());
				}
				sb.append("|");
			}
			sb.append("\n");
			for (int j = 0; j < elements[i].length; j++) {
				sb.append("---");
			}
			sb.append("-\n");
		}

		return sb.toString();
	}

}
