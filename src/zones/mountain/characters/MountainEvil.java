package zones.mountain.characters;

import visitor.concrete.Enemy;
import zones.common.weapons.Bomb;

public class MountainEvil extends Enemy {

	public MountainEvil() {
		super(new Bomb());
	}
	
}
