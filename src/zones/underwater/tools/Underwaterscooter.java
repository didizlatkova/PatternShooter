package zones.underwater.tools;

import zones.underwater.weapons.Torpedo;
import elements.abstracts.Tool;
import elements.abstracts.weapons.Weapon;
import engine.helpers.*;

public class Underwaterscooter extends Tool {

	@Override
	public String getName() {
		return "Underwaterscooter";
	}

	@Override
	public String toString() {
		return "US";
	}

	@Override
	public int calculateDamage(Weapon weapon, int damagePoints) {
		if (weapon instanceof Torpedo) {
			Logger.getInstance().printMessage("You have underwaterscooter!");
			return 0;
		}

		return super.calculateDamage(weapon, damagePoints);
	}
	
	@Override
	public ToolType getType() {
		return ToolType.Vehicle;
	}

}
