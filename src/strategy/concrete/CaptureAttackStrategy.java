package strategy.concrete;

import elements.abstracts.characters.CapturingEnemy;
import engine.helpers.Logger;
import strategy.abstracts.AttackStrategy;

public class CaptureAttackStrategy extends AttackStrategy {

	public CaptureAttackStrategy(CapturingEnemy character) {
		super(character);
	}

	@Override
	public void attack() {
		if (((CapturingEnemy) this.character).canCapture()) {
			this.field.getHero().setCanAttack(false);
			Logger.getInstance()
					.printMessage(
							String.format(
									"You got captured by %s! You cannot attack while he is near you!",
									this.character.getName()));
		}
	}

}
