package visitor.abstracts;

import visitor.concrete.Weapon;

public abstract class Character {
	
	private Weapon weapon;

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Character(Weapon weapon){
		this.setWeapon(weapon);
	}
	
}
