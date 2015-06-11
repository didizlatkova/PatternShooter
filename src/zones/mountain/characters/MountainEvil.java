package zones.mountain.characters;

import elements.abstracts.characters.Enemy;
import zones.common.weapons.Bomb;

public class MountainEvil extends Enemy {

	public MountainEvil(int healthPoints) {
		super(new Bomb(), healthPoints);
	}
	
	@Override
	public String getName() {
		return "MountainEvil";
	}
	
}
