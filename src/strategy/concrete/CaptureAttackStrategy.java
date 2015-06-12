package strategy.concrete;

import elements.abstracts.characters.CapturingEnemy;
import elements.abstracts.characters.Character;
import engine.helpers.Logger;
import strategy.abstracts.AttackStrategy;

public class CaptureAttackStrategy extends AttackStrategy {

	@Override
	public void attack(Character character) {
		if (((CapturingEnemy) character).canCapture()) {
			this.field.getHero().setCanAttack(false);
			Logger.getInstance()
					.printMessage(
							String.format(
									"You got captured by %s! You cannot attack while he is near you!",
									character.getName()));
		}
	}

}
