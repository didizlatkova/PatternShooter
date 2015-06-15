package zones.underwater.characters;

import zones.underwater.weapons.Torpedo;
import elements.abstracts.characters.Enemy;

public class Amphibianshipswrecker extends Enemy {

	public Amphibianshipswrecker(int healthPoints) {
		super(new Torpedo(), healthPoints);
	}

	@Override
	public String toString() {
		return "AS";
	}

	@Override
	public String getName() {
		return "Amphibianshipswrecker";
	}

}
