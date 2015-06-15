package zones.underwater.characters;

import zones.underwater.weapons.Net;
import elements.abstracts.characters.CapturingEnemy;

public class Dumbfishead extends CapturingEnemy {

	public Dumbfishead(int healthPoints) {
		super(new Net(), healthPoints);
	}
	
	@Override
	public String toString() {
		return "D ";
	}

	@Override
	public String getName() {
		return "Dumbfishead";
	}
	
	@Override
	public boolean canCapture() {
		return true;
	}

}
