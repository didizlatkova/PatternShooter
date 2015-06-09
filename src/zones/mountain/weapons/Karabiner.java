package zones.mountain.weapons;

import visitor.concrete.Weapon;

public class Karabiner extends Weapon {

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public String getName() {
		return "Karabiner";
	}
	
}
