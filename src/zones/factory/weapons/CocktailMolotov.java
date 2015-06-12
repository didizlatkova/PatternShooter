package zones.factory.weapons;

import elements.abstracts.weapons.Weapon;

public class CocktailMolotov extends Weapon {

	public CocktailMolotov() {
		super(30);
	}
	
	@Override
	public String toString() {
		return "CM";
	}

	@Override
	public String getName() {
		return "CocktailMolotov";
	}

}
