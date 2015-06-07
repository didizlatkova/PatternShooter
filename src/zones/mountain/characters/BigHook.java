package zones.mountain.characters;

import engine.concrete.Field;
import visitor.concrete.Enemy;
import zones.mountain.weapons.Rope;

public class BigHook extends Enemy {

	public BigHook() {
		super(new Rope());
	}

	@Override
	public void takeTurn(Field field) {
		// TODO Auto-generated method stub
		
	}

}
