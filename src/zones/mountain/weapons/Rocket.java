package zones.mountain.weapons;

import elements.abstracts.weapons.MultipleDamageWeapon;

public class Rocket extends MultipleDamageWeapon {

	public Rocket() {
		super(10);
	}

	@Override
	public String toString() {
		return "R ";
	}
	
	@Override
	public String getName() {
		return "Rocket";
	}

}