package strategy.abstracts;

import elements.abstracts.characters.Character;
import engine.concrete.Field;

public abstract class AttackStrategy {

	protected Field field;

	public void setField(Field field) {
		this.field = field;
	}

	public abstract void attack(Character character);

}
