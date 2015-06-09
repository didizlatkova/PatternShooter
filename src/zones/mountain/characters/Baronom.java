package zones.mountain.characters;

import visitor.concrete.Enemy;
import zones.common.weapons.Blast;

public class Baronom extends Enemy {

	public Baronom(int healthPoints) {
		super(new Blast(), healthPoints);
	}

	@Override
	public String getName() {
		return "Baronom";
	}	

}
