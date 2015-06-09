package zones.common.weapons;

import elements.abstracts.Weapon;

public class MachineGun extends Weapon {

	public MachineGun() {
		super(40);
	}

	@Override
	public String toString() {
		return "M";
	}

	@Override
	public String getName() {
		return "MachineGun";
	}
	
}
