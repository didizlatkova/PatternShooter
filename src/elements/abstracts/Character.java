package elements.abstracts;

import command.abstracts.*;
import command.concrete.*;
import strategy.abstracts.AttackStrategy;
import visitor.abstracts.Visitor;
import elements.concrete.Hero;
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

	public Character(Weapon weapon, int healthPoints) {
		this.setWeapon(weapon);
		this.healthPoints = healthPoints;
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

	public void bindCommand(Command command, Field field) {
		if (command instanceof MoveCommand) {
			((MoveCommand) command).setField(field);
			((MoveCommand) command).setCharacter(this);
		} else if (command instanceof AttackCommand) {
			AttackStrategy strategy = this.getStrategy();
			strategy.setField(field);
			((AttackCommand) command).setStrategy(strategy);
		} else if (command instanceof ChangeWeaponCommand) {
			((ChangeWeaponCommand) command).setCharacter((Hero) this);
		}
	}

	protected abstract AttackStrategy getStrategy();

	public abstract void takeTurn(Field field);

}
