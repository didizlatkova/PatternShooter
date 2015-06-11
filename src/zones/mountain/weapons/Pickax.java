package zones.mountain.weapons;

import elements.abstracts.weapons.Weapon;

public class Pickax extends Weapon {

	public Pickax() {
		super(6);
	}

	@Override
	public String toString() {
		return "P ";
	}
	
	@Override
	public String getName() {
		return "Pickax";
	}

}
