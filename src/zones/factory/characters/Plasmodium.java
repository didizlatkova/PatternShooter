package zones.factory.characters;

import zones.factory.weapons.ChemicalMachineGun;
import elements.abstracts.characters.Enemy;

public class Plasmodium extends Enemy {

	public Plasmodium(int healthPoints) {
		super(new ChemicalMachineGun(), healthPoints);
	}
	
	@Override
	public String toString() {
		return "P ";
	}

	@Override
	public String getName() {
		return "Plasmodium";
	}

}
