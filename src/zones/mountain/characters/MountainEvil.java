package zones.mountain.characters;

import elements.abstracts.characters.Enemy;
import zones.common.weapons.Blast;

public class MountainEvil extends Enemy {

	public MountainEvil(int healthPoints) {
		super(new Blast(), healthPoints);
	}
	
	@Override
	public String getName() {
		return "MountainEvil";
	}
	
}
