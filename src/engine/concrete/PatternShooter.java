package engine.concrete;

import command.concrete.CommandParser;

import engine.helpers.Logger;
import factory.abstracts.ZoneFactory;
import factory.concrete.MountainFactory;

public class PatternShooter {

	public static void main(String[] args) {
		ZoneFactory factory = new MountainFactory();
		Logger.getInstance().printRules(factory.getRulesPath());
		Field field = new Field(5, 5, factory);
		Logger.getInstance().printMessage(field.toString());

		Engine.getInstance().start(field);

		CommandParser.getInstance().close();
	}

}
