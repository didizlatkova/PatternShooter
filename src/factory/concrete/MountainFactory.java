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
	
	private static final int HEALTH_POINTS = 100;

	@Override
	public List<Enemy> createEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Baronom(HEALTH_POINTS));
		enemies.add(new BigHook(HEALTH_POINTS));
		enemies.add(new Icelander(HEALTH_POINTS));
		enemies.add(new MountainEvil(HEALTH_POINTS));

		return enemies;
	}

	@Override
	public List<Item> createItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new MachineGun());
		items.add(new Rocket());
		items.add(new Karabiner());
		items.add(new Armor());

		return items;
	}

	@Override
	public Hero createHero() {
		return new Hero(new Gun(), HEALTH_POINTS);
	}

}
