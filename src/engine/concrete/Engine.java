package engine.concrete;

import visitor.concrete.Enemy;
import factory.abstracts.ZoneFactory;
import factory.concrete.MountainFactory;

public class Engine {

	public void start() {
		ZoneFactory factory = new MountainFactory();
		Field field = new Field(5, 5, factory);
		System.out.println(field.toString());

		for (Enemy enemy : field.getEnemies()) {
			enemy.takeTurn(field);
		}

		System.out.println(field.toString());
	}

}
