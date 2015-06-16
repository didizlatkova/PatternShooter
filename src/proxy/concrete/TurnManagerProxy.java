package proxy.concrete;

import command.concrete.AttackCommand;
import elements.abstracts.weapons.ContinuousDamageWeapon;
import elements.concrete.Hero;
import engine.concrete.Field;
import engine.helpers.CommandParser;
import engine.helpers.Logger;
import proxy.abstracts.TurnManager;

public class TurnManagerProxy implements TurnManager {

	private HeroTurnManager realManager;

	public TurnManagerProxy() {
		this.realManager = new HeroTurnManager();
	}

	@Override
	public void takeTurn(Field field, Hero hero) {
		if (hero.getWeapon() instanceof ContinuousDamageWeapon
				&& ((ContinuousDamageWeapon) hero.getWeapon()).isOn) {
			Logger.getInstance()
					.printMessage(
							String.format(
									"You are currently firing a %s. Do you want to stop? yes/no",
									hero.getWeapon().getName()));
			String input = CommandParser.getInstance().getScanner().nextLine();
			if (input.equals("yes")) {
				((ContinuousDamageWeapon) hero.getWeapon()).isOn = false;
			} else {
				realManager.takeTurn(field, hero, new AttackCommand());
			}
		} else {
			realManager.takeTurn(field, hero);
		}
	}

}
