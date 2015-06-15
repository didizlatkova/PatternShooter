package zones.underwater.weapons;

import elements.abstracts.weapons.MultipleDamageWeapon;

public class DepthBomb extends MultipleDamageWeapon {

	public DepthBomb() {
		super(30);
	}
	
	@Override
	public String toString() {
		return "DB";
	}	

	@Override
	public String getName() {
		return "DepthBomb";
	}

}
