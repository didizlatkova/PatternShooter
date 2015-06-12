package zones.mountain.characters;

import elements.abstracts.characters.Enemy;
import zones.mountain.weapons.Rocket;

public class Baronom extends Enemy {

	public Baronom(int healthPoints) {
		super(new Rocket(), healthPoints);
	}

	@Override
	public String getName() {
		return "Baronom";
	}
	
	@Override
	public String toString() {
		return "Ba";
	}

}
