package visitor.concrete;

import visitor.abstracts.*;
import visitor.abstracts.Character;

public class Hero extends Character implements FieldElement {

	public Hero(Weapon weapon) {
		super(weapon);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "H";
	}

}
