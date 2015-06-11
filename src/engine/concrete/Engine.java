package engine.concrete;

import elements.abstracts.characters.Enemy;
import engine.helpers.Logger;

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

	public void start(Field field) {
		while (!gameOver) {
			Logger.getInstance().promptUser();
			field.getHero().takeTurn(field);
			field.removeDeadEnemies();
			field.checkForWin();

			for (Enemy enemy : field.getEnemies()) {
				enemy.takeTurn(field);
			}

			field.checkForLoss();

			Logger.getInstance().printMessage(field.toString());
		}
	}

}
