package elements.abstracts.characters;

import command.abstracts.*;
import command.concrete.*;
import strategy.abstracts.AttackStrategy;
import visitor.abstracts.Visitor;
import elements.abstracts.FieldElement;
import elements.abstracts.Position;
import elements.abstracts.weapons.Weapon;
import engine.concrete.Field;
import engine.helpers.Logger;

public abstract class Character implements FieldElement, Visitor {

	protected Position position;
	private Weapon weapon;
	protected int healthPoints;
	protected int damagePoints;

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

	public void takeAttack(Weapon weapon) {
		this.healthPoints -= damagePoints;
		if (this.healthPoints < 0) {
			this.healthPoints = 0;
		}
		Logger.getInstance().printMessage(
				String.format(
						"%s got damaged by %d points. Health points left: %d",
						this.getName(), damagePoints, this.healthPoints));
	}

	public void bindCommand(Command command, Field field) {
		if (command instanceof MoveCommand) {
			((MoveCommand) command).setField(field);
		} else if (command instanceof AttackCommand) {
			AttackStrategy strategy = this.getStrategy();
			strategy.setField(field);
			((AttackCommand) command).setStrategy(strategy);
		} else if (command instanceof UndoCommand) {
			((UndoCommand) command).setField(field);
		}

		command.setCharacter(this);
	}

	protected abstract AttackStrategy getStrategy();

	public abstract void takeTurn(Field field);

}
