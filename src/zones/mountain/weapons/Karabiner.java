package zones.mountain.weapons;

import elements.abstracts.Weapon;

public class Karabiner extends Weapon {

	public Karabiner() {
		super(0);
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public String getName() {
		return "Karabiner";
	}
	
}
