package factory.concrete;

import java.util.ArrayList;
import java.util.List;

import zones.common.tools.Armor;
import zones.common.weapons.*;
import zones.mountain.characters.*;
import zones.mountain.weapons.*;
import elements.abstracts.Item;
import elements.abstracts.characters.Enemy;
import elements.concrete.*;
import factory.abstracts.ZoneFactory;

public class MountainFactory implements ZoneFactory {

	private static final int HERO_HEALTH_POINTS = 100;
	private static final int ENEMY_HEALTH_POINTS = 50;
	private static final String RULES_PATH = "mountain.txt";

	@Override
	public List<Enemy> createEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Baronom(ENEMY_HEALTH_POINTS));
		enemies.add(new BigHook(ENEMY_HEALTH_POINTS));
		enemies.add(new Icelander(ENEMY_HEALTH_POINTS));
		enemies.add(new MountainEvil(ENEMY_HEALTH_POINTS));

		return enemies;
	}

	@Override
	public List<Item> createItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new MachineGun());
		items.add(new Bomb());
		items.add(new Karabiner());
		items.add(new Armor());

		return items;
	}

	@Override
	public Hero createHero() {
		return new Hero(new Gun(), HERO_HEALTH_POINTS);
	}

	@Override
	public String getRulesPath() {
		return RULES_PATH;
	}

}
