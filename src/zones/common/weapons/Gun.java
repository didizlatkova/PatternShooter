package zones.common.weapons;

import elements.abstracts.weapons.Weapon;

public class Gun extends Weapon {

	public Gun() {
		super(20);
	}

	@Override
	public String toString() {
		return "G";
	}
	
	@Override
	public String getName() {
		return "Gun";
	}

}
