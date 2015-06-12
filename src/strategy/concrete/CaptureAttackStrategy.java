package strategy.concrete;

import elements.abstracts.characters.CapturingEnemy;
import strategy.abstracts.AttackStrategy;

public class CaptureAttackStrategy extends AttackStrategy {

	public CaptureAttackStrategy(CapturingEnemy character) {
		super(character);
	}

	@Override
	public void attack() {
		if (((CapturingEnemy) this.character).canCapture()) {
			this.field.getHero().setCanAttack(false);
		}
	}

}
