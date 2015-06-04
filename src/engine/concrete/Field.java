package engine.concrete;

import java.util.List;

import factory.abstracts.ZoneFactory;
import visitor.abstracts.FieldElement;
import visitor.concrete.*;

public class Field {

	private FieldElement[][] elements;
	private List<Enemy> enemies;
	private Hero hero;

	public FieldElement[][] getElements() {
		return elements;
	}

	private void setElements(int height, int width) {
		this.elements = new FieldElement[height][width];

		this.elements[0][0] = this.enemies.get(0);
		this.elements[0][width - 1] = this.enemies.get(1);
		this.elements[height - 1][0] = this.enemies.get(2);
		this.elements[height - 1][width - 1] = this.enemies.get(3);

		this.elements[height / 2][width / 2] = this.hero;
	}

	public Field(int width, int height, ZoneFactory factory) {
		this.enemies = factory.createEnemies();
		this.hero = factory.createHero();
		this.setElements(height, width);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < elements.length; i++) {
			sb.append("|");
			for (int j = 0; j < elements[i].length; j++) {
				if (elements[i][j] == null) {
					sb.append(" ");
				} else {
					sb.append(elements[i][j].toString());
				}
				sb.append("|");
			}
			sb.append("\n");
			for (int j = 0; j < elements[i].length; j++) {
				sb.append("--");
			}
			sb.append("-\n");
		}

		return sb.toString();
	}

}
