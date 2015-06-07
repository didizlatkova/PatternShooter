package zones.mountain.characters;

import engine.concrete.Field;
import visitor.concrete.Enemy;
import zones.mountain.weapons.Pickax;

public class Icelander extends Enemy {

	public Icelander() {
		super(new Pickax());
	}

	@Override
	public void takeTurn(Field field) {
		// TODO Auto-generated method stub

	}

}
