package zones.factory.characters;

import zones.factory.weapons.CocktailMolotov;
import elements.abstracts.characters.Enemy;

public class Gorgonel extends Enemy {

	public Gorgonel(int healthPoints) {
		super(new CocktailMolotov(), healthPoints);
	}
	
	@Override
	public String toString() {
		return "G ";
	}

	@Override
	public String getName() {
		return "Gorgonel";
	}

}
