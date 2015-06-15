package command.concrete;

import strategy.abstracts.AttackStrategy;
import command.abstracts.CharacterCommand;
import command.abstracts.Command;
import elements.abstracts.characters.Character;

public class AttackCommand implements Command, CharacterCommand {

	private AttackStrategy strategy;
	protected Character character;

	public void setStrategy(AttackStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void setCharacter(Character character) {
		this.character = character;
	}

	@Override
	public void execute() {
		strategy.attack(this.character);
	}

}
