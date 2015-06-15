package zones.underwater.weapons;

import elements.abstracts.weapons.Weapon;

public class Harpoon extends Weapon {

	public Harpoon() {
		super(10);
	}

	@Override
	public String toString() {
		return "H ";
	}
	
	@Override
	public String getName() {
		return "Harpoon";
	}

}
