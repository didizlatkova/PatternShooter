package zones.common.weapons;

import elements.abstracts.weapons.Weapon;

public class Blast extends Weapon {

	public Blast() {
		super(20);
	}

	@Override
	public String toString() {
		return "Bl";
	}

	@Override
	public String getName() {
		return "Blast";
	}
	
}
