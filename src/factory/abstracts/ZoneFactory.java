package factory.abstracts;

import java.util.List;

import elements.abstracts.Item;
import elements.abstracts.characters.Enemy;
import elements.concrete.*;

public interface ZoneFactory {

	List<Enemy> createEnemies();

	List<Item> createItems();

	Hero createHero();

	String getRulesPath();

}
