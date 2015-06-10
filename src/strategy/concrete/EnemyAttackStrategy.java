package strategy.concrete;

import elements.abstracts.Character;
import strategy.abstracts.AttackStrategy;

public class EnemyAttackStrategy extends AttackStrategy {

	public EnemyAttackStrategy(Character character) {
		super(character);
	}

	@Override
	public void attack() {
		this.field.getHero().accept(this.character);
	}

}
