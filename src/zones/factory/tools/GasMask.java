package zones.factory.tools;

import zones.factory.weapons.ChemicalMachineGun;
import elements.abstracts.Tool;
import elements.abstracts.weapons.Weapon;
import engine.helpers.Logger;
import engine.helpers.ToolType;

public class GasMask extends Tool {

	@Override
	public String getName() {
		return "GasMask";
	}

	@Override
	public String toString() {
		return "GM";
	}

	@Override
	public int calculateDamage(Weapon weapon, int damagePoints) {
		if (weapon instanceof ChemicalMachineGun) {
			Logger.getInstance().printMessage("You have gas mask!");
			return 0;
		}

		return super.calculateDamage(weapon, damagePoints);
	}

	@Override
	public ToolType getType() {
		return ToolType.Mask;
	}

}
