package factory.abstracts;

import java.util.List;

import visitor.abstracts.Item;
import visitor.concrete.*;

public interface ZoneFactory {

	List<Enemy> createEnemies();
	
	List<Item> createItems();
		
	Hero createHero();
	
}
