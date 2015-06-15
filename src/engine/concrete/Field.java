package engine.concrete;

import java.util.ArrayList;
import java.util.List;

import elements.abstracts.*;
import elements.abstracts.characters.*;
import elements.abstracts.characters.Character;
import elements.concrete.*;
import engine.helpers.*;
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

	public Field() {
	};

	public Field(int width, int height, ZoneFactory factory) {
		this.generator = RandomGenerator.getInstance();
		this.enemies = factory.createEnemies();
		this.hero = factory.createHero();
		this.items = factory.createItems();
		this.setElements(height, width);
	}

	public Field(Field field) {
		this.elements = new FieldElement[field.elements.length][field.elements[0].length];
		for (int i = 0; i < field.elements.length; i++) {
			for (int j = 0; j < field.elements[0].length; j++) {
				this.elements[i][j] = field.elements[i][j];
			}
		}

		this.enemies = new ArrayList<Enemy>();
		for (int i = 0; i < field.enemies.size(); i++) {
			this.enemies.add(field.enemies.get(i));
		}

		this.hero = field.hero;

		this.items = new ArrayList<Item>();
		for (int i = 0; i < field.items.size(); i++) {
			this.items.add(field.items.get(i));
		}

		this.generator = field.generator;
	}

	public void moveCharacter(Character character, Position newPosition) {
		this.elements[character.getPosition().x][character.getPosition().y] = null;
		character.setPosition(newPosition, this.elements);
	}

	public boolean isInside(Position position) {
		if (position.x < 0 || position.x >= this.elements.length
				|| position.y < 0 || position.y >= this.elements[0].length) {
			return false;
		}

		return true;
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

	public void removeSuicidalEnemy() {
		this.enemies.remove(0);
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
