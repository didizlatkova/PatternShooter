package zones.underwater.weapons;

import elements.abstracts.weapons.Weapon;

public class Net extends Weapon {

	public Net() {
		super(0);
	}

	@Override
	public String toString() {
		return "N ";
	}
	
	@Override
	public String getName() {
		return "Net";
	}

}
