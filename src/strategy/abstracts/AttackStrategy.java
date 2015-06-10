package strategy.abstracts;

import elements.abstracts.Character;
import engine.concrete.Field;

public abstract class AttackStrategy {

	protected Field field;
	protected Character character;

	public void setField(Field field) {
		this.field = field;
	}
	
	public AttackStrategy(Character character) {
		this.character = character;
	}

	public abstract void attack();

}
