package factory.concrete;

import java.util.ArrayList;
import java.util.List;

import visitor.abstracts.Item;
import visitor.concrete.*;
import zones.common.weapons.*;
import zones.mountain.characters.*;
import zones.mountain.tools.Karabiner;
import zones.mountain.weapons.*;
import factory.abstracts.ZoneFactory;

public class MountainFactory implements ZoneFactory {

	@Override
	public List<Enemy> createEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Baronom());
		enemies.add(new BigHook());
		enemies.add(new Icelander());
		enemies.add(new MountainEvil());

		return enemies;
	}

	@Override
	public List<Item> createItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new MachineGun());
		items.add(new Rocket());
		items.add(new Karabiner());

		return items;
	}

	@Override
	public Hero createHero() {
		return new Hero(new Gun());
	}

}
