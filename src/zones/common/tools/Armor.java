package zones.common.tools;

import elements.abstracts.Tool;
import elements.abstracts.weapons.Weapon;
import engine.helpers.ToolType;

public class Armor extends Tool {

	public Armor() {
		this.type = ToolType.Armor;
	}

	@Override
	public String toString() {
		return "A";
	}

	@Override
	public String getName() {
		return "Armor";
	}

	@Override
	public int calculateDamage(Weapon weapon) {
		System.out.println("You have armor!");
		return weapon.DAMAGE_POINTS / 2;
	}
}
