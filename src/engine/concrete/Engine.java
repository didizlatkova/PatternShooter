package engine.concrete;

import elements.abstracts.characters.CapturingEnemy;
import elements.abstracts.characters.Enemy;
import engine.helpers.FieldCaretaker;
import engine.helpers.Logger;

public class Engine {

	private static Engine instance = new Engine();
	private static boolean gameOver;
	private boolean fieldUndone;
	private Field field;

	public void setFieldUndone() {
		this.fieldUndone = true;
	}

	private Engine() {
	};

	public static Engine getInstance() {
		return instance;
	}

	public void gameOver() {
		gameOver = true;
	}

	public void start(Field field) {
		this.field = field;
		FieldCaretaker.getInstance().saveField(this.field);
		while (!gameOver) {
			Logger.getInstance().promptUser();
			this.field.getHero().takeTurn(this.field);
			this.field.removeDeadEnemies();
			this.checkForWin(this.field);

			if (!this.fieldUndone) {
				for (Enemy enemy : this.field.getEnemies()) {
					enemy.takeTurn(this.field);
				}

				this.checkForLoss(this.field);
				FieldCaretaker.getInstance().saveField(this.field);
			} else {
				fieldUndone = false;
			}
			Logger.getInstance().printMessage(this.field.toString());
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

	public FieldMemento saveField() {
		return new FieldMemento(this.field);
	}

	public void restoreField(FieldMemento memento) {
		this.field = new Field(memento.getField());
	}

	public static class FieldMemento {
		private Field field;

		private FieldMemento(Field field) {
			this.field = new Field(field);
		}

		private Field getField() {
			return this.field;
		}
	}

}
