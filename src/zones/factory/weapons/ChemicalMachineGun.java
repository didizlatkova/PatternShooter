package zones.factory.weapons;

import elements.abstracts.weapons.ContinuousDamageWeapon;

public class ChemicalMachineGun extends ContinuousDamageWeapon {

	public ChemicalMachineGun() {
		super(40);
	}

	@Override
	public String toString() {
		return "Ch";
	}
	
	@Override
	public String getName() {
		return "ChemicalMachineGun";
	}

}
