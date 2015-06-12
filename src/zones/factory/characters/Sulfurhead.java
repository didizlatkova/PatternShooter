package zones.factory.characters;

import zones.common.weapons.Gun;
import elements.abstracts.characters.Enemy;

public class Sulfurhead extends Enemy {

	public Sulfurhead(int healthPoints) {
		super(new Gun(), healthPoints);
	}
	
	@Override
	public String toString() {
		return "Su";
	}

	@Override
	public String getName() {
		return "Sulfurhead";
	}

}
