package factory.abstracts;

import java.util.List;

import visitor.concrete.*;

public interface ZoneFactory {

	List<Enemy> createEnemies();
	
	List<Weapon> createWeapons();
	
	List<Tool> createTools();
	
	Hero createHero();
	
}
