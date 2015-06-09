package command.concrete;

import strategy.abstracts.AttackStrategy;
import command.abstracts.Command;

public class AttackCommand implements Command {

	private AttackStrategy strategy;

	public void setStrategy(AttackStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void execute() {
		strategy.attack();
	}

}
