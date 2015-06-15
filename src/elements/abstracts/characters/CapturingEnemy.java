package elements.abstracts.characters;

import strategy.abstracts.AttackStrategy;
import strategy.concrete.CaptureAttackStrategy;
import elements.abstracts.characters.Enemy;
import elements.abstracts.weapons.Weapon;

public abstract class CapturingEnemy extends Enemy {

	public CapturingEnemy(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
	}

	@Override
	protected AttackStrategy getStrategy() {
		return new CaptureAttackStrategy();
	}

	public abstract boolean canCapture();

}