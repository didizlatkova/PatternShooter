package visitor.concrete;

import visitor.abstracts.*;
import visitor.abstracts.Character;

public abstract class Enemy extends Character {

	public Enemy(Weapon weapon) {
		super(weapon);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "E";
	}
	
}
