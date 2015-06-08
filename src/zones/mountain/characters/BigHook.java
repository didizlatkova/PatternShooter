package zones.mountain.characters;

import visitor.concrete.Enemy;
import zones.mountain.weapons.Rope;

public class BigHook extends Enemy {

	public BigHook() {
		super(new Rope());
	}

}
