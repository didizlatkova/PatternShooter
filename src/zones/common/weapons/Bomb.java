package zones.common.weapons;

import visitor.concrete.Weapon;

public class Bomb extends Weapon {

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public String getName() {
		return "Bomb";
	}

}
