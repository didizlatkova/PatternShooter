package zones.factory.tools;

import zones.factory.weapons.CocktailMolotov;
import elements.abstracts.Tool;
import elements.abstracts.weapons.Weapon;
import engine.helpers.Logger;

public class GlycerinBalls extends Tool {

	@Override
	public String getName() {
		return "GlycerinBalls";
	}
	
	@Override
	public String toString() {
		return "GB";
	}

	@Override
	public int calculateDamage(Weapon weapon) {
		if (weapon instanceof CocktailMolotov) {
			Logger.getInstance().printMessage("You have glycerin balls!");
			return 0;
		}

		return weapon.DAMAGE_POINTS;
	}

}
