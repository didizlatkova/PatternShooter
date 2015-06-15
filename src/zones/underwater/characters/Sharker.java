package zones.underwater.characters;

import zones.common.weapons.Blast;
import elements.abstracts.characters.Enemy;

public class Sharker extends Enemy {

	public Sharker(int healthPoints) {
		super(new Blast(), healthPoints);
	}
	
	@Override
	public String toString() {
		return "S ";
	}
	
	@Override
	public String getName() {
		return "Sharker";
	}

}
