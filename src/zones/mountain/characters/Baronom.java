package zones.mountain.characters;

import engine.concrete.Field;
import visitor.concrete.Enemy;
import zones.common.weapons.Blast;

public class Baronom extends Enemy {

	public Baronom() {
		super(new Blast());
	}

	@Override
	public void takeTurn(Field field) {
		// TODO Auto-generated method stub

	}

}
