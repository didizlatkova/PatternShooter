package zones.underwater.characters;

import zones.underwater.weapons.Net;
import elements.abstracts.characters.Enemy;
import elements.abstracts.weapons.Weapon;

public class Dumbfishead extends Enemy {

	public Dumbfishead(Weapon weapon, int healthPoints) {
		super(new Net(), healthPoints);
	}
	
	@Override
	public String toString() {
		return "D ";
	}

	@Override
	public String getName() {
		return "Dumbfishead";
	}

}
