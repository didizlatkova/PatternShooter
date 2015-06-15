package zones.underwater.weapons;

import elements.abstracts.weapons.ContinuousDamageWeapon;

public class Watergun extends ContinuousDamageWeapon {

	public Watergun() {
		super(40);
	}
	
	@Override
	public String toString() {
		return "WG";
	}
	
	@Override
	public String getName() {
		return "Watergun";
	}

}
