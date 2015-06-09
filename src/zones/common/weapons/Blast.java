package zones.common.weapons;

import elements.abstracts.Weapon;

public class Blast extends Weapon {

	public Blast() {
		super(30);
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
