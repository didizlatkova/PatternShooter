package engine.concrete;

import elements.abstracts.characters.CapturingEnemy;
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
			this.checkForWin(field);

			for (Enemy enemy : field.getEnemies()) {
				enemy.takeTurn(field);
			}

			this.checkForLoss(field);

			Logger.getInstance().printMessage(field.toString());
		}
	}

	private void checkForWin(Field field) {
		if (field.getEnemies().isEmpty()) {
			Logger.getInstance().printMessage("You win!");
			Engine.getInstance().gameOver();
		} else if (field.getEnemies().size() == 1
				&& field.getEnemies().get(0) instanceof CapturingEnemy) {
			Logger.getInstance().printMessage(
					String.format(
							"%s got lonely and committed suicide! You win!",
							field.getEnemies().get(0).getName()));
			Engine.getInstance().gameOver();
		}
	}

	private void checkForLoss(Field field) {
		if (field.getHero().getHealthPoints() == 0) {
			Logger.getInstance().printMessage("You lost!");
			Engine.getInstance().gameOver();
		}
	}

}
