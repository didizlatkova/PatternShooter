package strategy.concrete;

import elements.abstracts.characters.Character;
import strategy.abstracts.AttackStrategy;

public class EnemyAttackStrategy extends AttackStrategy {

	@Override
	public void attack(Character character) {
		this.field.getHero().accept(character);
	}

}
