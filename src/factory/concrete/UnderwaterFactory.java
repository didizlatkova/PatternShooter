package factory.concrete;

import java.util.ArrayList;
import java.util.List;

import zones.common.tools.Armor;
import zones.underwater.characters.*;
import zones.underwater.tools.*;
import zones.underwater.weapons.DepthBomb;
import zones.underwater.weapons.Watergun;
import elements.abstracts.Item;
import elements.abstracts.characters.Enemy;
import elements.concrete.Hero;
import factory.abstracts.ZoneFactory;

public class UnderwaterFactory implements ZoneFactory {

	private static final int HERO_HEALTH_POINTS = 100;
	private static final int ENEMY_HEALTH_POINTS = 100;
	private static final String RULES_PATH = "underwater.txt";

	@Override
	public List<Enemy> createEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Dumbfishead(ENEMY_HEALTH_POINTS));
		enemies.add(new Sharker(ENEMY_HEALTH_POINTS));
		enemies.add(new Whalesknighter(ENEMY_HEALTH_POINTS));
		enemies.add(new Amphibianshipswrecker(ENEMY_HEALTH_POINTS));

		return enemies;
	}

	@Override
	public List<Item> createItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new DepthBomb());
		items.add(new BreathMask());
		items.add(new Underwaterscooter());
		items.add(new Armor());

		return items;
	}

	@Override
	public Hero createHero() {
		return new Hero(new Watergun(), HERO_HEALTH_POINTS);
	}

	@Override
	public String getRulesPath() {
		return RULES_PATH;
	}

}
