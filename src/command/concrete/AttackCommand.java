package command.concrete;

import strategy.abstracts.AttackStrategy;
import command.abstracts.Command;

public class AttackCommand implements Command {

//	private Field field;
//	private Character character;
//	private Position currentPosition;
	private AttackStrategy strategy;

//	public void setField(Field field) {
//		this.field = field;
//	}
//
//	public void setCharacter(Character character) {
//		this.character = character;
//		this.currentPosition = character.getPosition();
//	}

	public void setStrategy(AttackStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void execute() {
		strategy.attack();
	}

}
