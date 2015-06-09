package factory.abstracts;

import java.util.List;

import elements.abstracts.Enemy;
import elements.abstracts.Item;
import elements.concrete.*;

public interface ZoneFactory {

	List<Enemy> createEnemies();

	List<Item> createItems();

	Hero createHero();

}
