package zones.common.tools;

import elements.abstracts.Tool;
import elements.abstracts.weapons.Weapon;
import engine.helpers.Logger;
import engine.helpers.ToolType;

public class Armor extends Tool {

	@Override
	public String toString() {
		return "A ";
	}

	@Override
	public String getName() {
		return "Armor";
	}

	@Override
	public int calculateDamage(Weapon weapon, int damagePoints) {
		Logger.getInstance().printMessage("You have armor!");
		return super.calculateDamage(weapon, damagePoints / 2);
	}

	@Override
	public ToolType getType() {
		return ToolType.Armor;
	}
}
