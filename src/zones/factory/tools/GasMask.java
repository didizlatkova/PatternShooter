package zones.factory.tools;

import zones.factory.weapons.ChemicalMachineGun;
import elements.abstracts.Tool;
import elements.abstracts.weapons.Weapon;
import engine.helpers.Logger;

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
	public int calculateDamage(Weapon weapon) {
		if (weapon instanceof ChemicalMachineGun) {
			Logger.getInstance().printMessage("You have gas mask!");
			return 0;
		}

		return weapon.DAMAGE_POINTS;
	}

}
