package zones.mountain.characters;

import elements.abstracts.Enemy;
import zones.mountain.weapons.Rope;

public class BigHook extends Enemy {

	public BigHook(int healthPoints) {
		super(new Rope(), healthPoints);
	}

	@Override
	public String getName() {
		return "BigHook";
	}
	
}
