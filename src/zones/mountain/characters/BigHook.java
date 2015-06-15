package zones.mountain.characters;

import elements.abstracts.characters.CapturingEnemy;
import elements.abstracts.weapons.Weapon;
import engine.helpers.Logger;
import zones.mountain.weapons.*;

public class BigHook extends CapturingEnemy {

	private boolean canCapture;

	public boolean canCapture() {
		return canCapture;
	}

	public BigHook(int healthPoints) {
		super(new Rope(), healthPoints);
	}

	@Override
	public String getName() {
		return "BigHook";
	}

	@Override
	public void visit(Weapon weapon) {
		if (weapon instanceof Karabiner) {
			this.canCapture = true;
		}
		Logger.getInstance().printMessage(
				String.format("%s just found a(n) %s. Now it can capture you!",
						this.getName(), weapon.getName()));
	}

	@Override
	public String toString() {
		return "BH";
	}

}
