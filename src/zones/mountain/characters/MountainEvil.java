package zones.mountain.characters;

import engine.concrete.Field;
import visitor.concrete.Enemy;
import zones.common.weapons.Bomb;

public class MountainEvil extends Enemy {

	public MountainEvil() {
		super(new Bomb());
	}

	@Override
	public void takeTurn(Field field) {
		// TODO Auto-generated method stub
		
	}

}
