package engine.concrete;

import java.util.ArrayList;
import java.util.List;

import engine.helpers.CommandParser;
import engine.helpers.Logger;
import factory.abstracts.ZoneFactory;
import factory.concrete.*;

public class PatternShooter {

	public static void main(String[] args) {
		List<ZoneFactory> factories = new ArrayList<ZoneFactory>();
		factories.add(new MountainFactory());
		factories.add(new FactoryFactory());
		factories.add(new UnderwaterFactory());

		int level = 1;

		for (ZoneFactory factory : factories) {
			Logger.getInstance().printMessage("Level " + level);
			Logger.getInstance().printRules(factory.getRulesPath());
			Field field = new Field(5, 5, factory);
			Logger.getInstance().printMessage(field.toString());

			Engine.getInstance().start(field);
			if (!Engine.getInstance().gameWon()) {
				break;
			}
			Engine.getInstance().newGame();
			level++;
		}

		CommandParser.getInstance().closeScanner();
	}

}
