package zones.mountain.characters;

import elements.abstracts.characters.Enemy;
import zones.mountain.weapons.Pickax;

public class Icelander extends Enemy {

	public Icelander(int healthPoints) {
		super(new Pickax(), healthPoints);
	}

	@Override
	public String getName() {
		return "Icelander";
	}
	
	@Override
	public String toString() {
		return "I ";
	}
	
}
