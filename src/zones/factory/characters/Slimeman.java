package zones.factory.characters;

import zones.common.weapons.Blast;
import elements.abstracts.characters.Enemy;

public class Slimeman extends Enemy {

	public Slimeman(int healthPoints) {
		super(new Blast(), healthPoints);
	}

	@Override
	public String toString() {
		return "S ";
	}
	
	@Override
	public String getName() {
		return "Slimeman";
	}

}
