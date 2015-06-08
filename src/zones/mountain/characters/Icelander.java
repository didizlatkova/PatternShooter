package zones.mountain.characters;

import visitor.concrete.Enemy;
import zones.mountain.weapons.Pickax;

public class Icelander extends Enemy {

	public Icelander(int healthPoints) {
		super(new Pickax(), healthPoints);
	}

}
