package zones.mountain.characters;

import visitor.concrete.Enemy;
import zones.mountain.weapons.Pickax;

public class Icelander extends Enemy {

	public Icelander() {
		super(new Pickax());
	}

}
