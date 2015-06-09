package zones.common.weapons;

import elements.abstracts.MultipleDamageWeapon;

public class Bomb extends MultipleDamageWeapon {

	public Bomb() {
		super(20);
	}

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public String getName() {
		return "Bomb";
	}

}
