package zones.underwater.characters;

import zones.underwater.weapons.DepthBomb;
import elements.abstracts.characters.Enemy;

public class Sharker extends Enemy {

	public Sharker(int healthPoints) {
		super(new DepthBomb(), healthPoints);
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
