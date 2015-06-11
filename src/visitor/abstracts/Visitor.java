package visitor.abstracts;

import elements.abstracts.Tool;
import elements.abstracts.characters.Character;
import elements.abstracts.weapons.Weapon;


public interface Visitor {

	void visit(Tool tool);

	void visit(Weapon weapon);

	void visit(Character character);

}
