package zones.underwater.characters;

import zones.underwater.weapons.Harpoon;
import elements.abstracts.characters.Enemy;

public class Whalesknighter extends Enemy {

	public Whalesknighter(int healthPoints) {
		super(new Harpoon(), healthPoints);
	}

	@Override
	public String toString() {
		return "WK";
	}

	@Override
	public String getName() {
		return "Whalesknighter";
	}

}
