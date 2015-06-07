package visitor.abstracts;

import engine.concrete.Field;
import visitor.concrete.Weapon;

public abstract class Character implements FieldElement {

	private Position position;

	private Weapon weapon;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position, FieldElement[][] elements) {
		this.position = position;
		elements[position.x][position.y] = this;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Character(Weapon weapon) {
		this.setWeapon(weapon);
	}

	public abstract void takeTurn(Field field);

}
