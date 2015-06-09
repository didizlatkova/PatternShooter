package engine.concrete;

import command.concrete.CommandParser;
import elements.abstracts.Enemy;
import factory.abstracts.ZoneFactory;
import factory.concrete.MountainFactory;

public class Engine {

	private static Engine instance = new Engine();
	private static boolean gameOver;

	private Engine() {
	};

	public static Engine getInstance() {
		return instance;
	}

	public void gameOver() {
		gameOver = true;
	}

	public void start() {
		ZoneFactory factory = new MountainFactory();
		Field field = new Field(5, 5, factory);
		System.out.println(field.toString());

		while (!gameOver) {
			field.getHero().takeTurn(field);

			for (Enemy enemy : field.getEnemies()) {
				enemy.takeTurn(field);
			}
			
			field.removeDeadEnemies();

			System.out.println(field.toString());
		}
		CommandParser.getInstance().close();
	}

}
