package elements.abstracts;

import visitor.abstracts.Visitor;
import engine.concrete.Field;

public abstract class Character implements FieldElement, Visitor {

	private Position position;
	private Weapon weapon;
	private int healthPoints;

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

	public int getHealthPoints() {
		return healthPoints;
	}

	public void takeAttack(int damagePoints) {
		this.healthPoints -= damagePoints;
		if (this.healthPoints < 0) {
			this.healthPoints = 0;
		}
		System.out.println(String.format(
				"%s got damaged by %d points. Health points left: %d",
				this.getName(), damagePoints, this.healthPoints));
	}

	public Character(Weapon weapon, int healthPoints) {
		this.setWeapon(weapon);
		this.healthPoints = healthPoints;
	}

	public abstract void takeTurn(Field field);

}
