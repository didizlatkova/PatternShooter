package elements.abstracts.characters;

import elements.abstracts.characters.Enemy;
import elements.abstracts.weapons.Weapon;

public abstract class CapturingEnemy extends Enemy {

	public CapturingEnemy(Weapon weapon, int healthPoints) {
		super(weapon, healthPoints);
	}

	public abstract boolean canCapture();

}