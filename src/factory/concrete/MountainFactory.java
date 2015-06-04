package factory.concrete;

import java.util.ArrayList;
import java.util.List;

import visitor.concrete.Enemy;
import visitor.concrete.Hero;
import visitor.concrete.Tool;
import visitor.concrete.Weapon;
import zones.mountain.characters.MountainEvil;
import factory.abstracts.ZoneFactory;

public class MountainFactory implements ZoneFactory {

	@Override
	public List<Enemy> createEnemies() {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(new MountainEvil());
		enemies.add(new MountainEvil());
		enemies.add(new MountainEvil());
		enemies.add(new MountainEvil());
		
		return enemies;
	}

	@Override
	public List<Weapon> createWeapons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tool> createTools() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hero createHero() {
		return new Hero();
	}

}
