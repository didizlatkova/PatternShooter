package zones.common.weapons;

import elements.abstracts.weapons.ContinuousDamageWeapon;

public class MachineGun extends ContinuousDamageWeapon {

	public MachineGun() {
		super(40);
	}

	@Override
	public String toString() {
		return "M ";
	}

	@Override
	public String getName() {
		return "MachineGun";
	}

}
