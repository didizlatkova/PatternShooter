package factory.concrete;

import java.util.ArrayList;
import java.util.List;

import zones.common.tools.Armor;
import zones.common.weapons.*;
import zones.factory.characters.*;
import zones.factory.tools.*;
import elements.abstracts.Item;
import elements.abstracts.characters.Enemy;
import elements.concrete.Hero;
import factory.abstracts.ZoneFactory;

// ha-ha-ha, look at my awesome name!
public class FactoryFactory implements ZoneFactory {

	private static final int HERO_HEALTH_POINTS = 200;
	private static final int ENEMY_HEALTH_POINTS = 100;
	private static final String RULES_PATH = "factory.txt";

	@Override
	public List<Enemy> createEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new Sulfurhead(ENEMY_HEALTH_POINTS));
		enemies.add(new Slimeman(ENEMY_HEALTH_POINTS));
		enemies.add(new Plasmodium(ENEMY_HEALTH_POINTS));
		enemies.add(new Gorgonel(ENEMY_HEALTH_POINTS));

		return enemies;
	}

	@Override
	public List<Item> createItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new MachineGun());
		items.add(new GasMask());
		items.add(new GlycerinBalls());
		items.add(new Armor());

		return items;
	}

	@Override
	public Hero createHero() {
		return new Hero(new Bomb(), HERO_HEALTH_POINTS);
	}

	@Override
	public String getRulesPath() {
		return RULES_PATH;
	}

}
