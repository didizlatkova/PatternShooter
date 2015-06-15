package zones.underwater.tools;

import zones.underwater.weapons.DepthBomb;
import elements.abstracts.Tool;
import elements.abstracts.weapons.Weapon;
import engine.helpers.*;

public class BreathMask extends Tool {

	@Override
	public String getName() {
		return "BreathMask";
	}
	
	@Override
	public String toString() {
		return "BM";
	}

	@Override
	public int calculateDamage(Weapon weapon, int damagePoints) {
		if (weapon instanceof DepthBomb) {
			Logger.getInstance().printMessage("You have breath mask!");
			return 0;
		}

		return super.calculateDamage(weapon, damagePoints);
	}

	@Override
	public ToolType getType() {
		return ToolType.Mask;
	}

}
