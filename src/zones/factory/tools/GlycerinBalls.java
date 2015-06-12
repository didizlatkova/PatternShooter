package zones.factory.tools;

import zones.factory.weapons.CocktailMolotov;
import elements.abstracts.Tool;
import elements.abstracts.weapons.Weapon;
import engine.helpers.Logger;
import engine.helpers.ToolType;

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
	public int calculateDamage(Weapon weapon, int damagePoints) {
		if (weapon instanceof CocktailMolotov) {
			Logger.getInstance().printMessage("You have glycerin balls!");
			return 0;
		}

		return super.calculateDamage(weapon, damagePoints);
	}

	@Override
	public ToolType getType() {
		return ToolType.Chemical;
	}

}
