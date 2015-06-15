package zones.underwater.weapons;

import elements.abstracts.weapons.Weapon;

public class Torpedo extends Weapon{

	public Torpedo() {
		super(50);
	}
	
	@Override
	public String toString() {
		return "T ";
	}

	@Override
	public String getName() {
		return "Torpedo";
	}

}
