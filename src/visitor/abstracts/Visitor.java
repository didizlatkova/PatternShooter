package visitor.abstracts;

import elements.abstracts.Character;
import elements.abstracts.Tool;
import elements.abstracts.Weapon;


public interface Visitor {

	void visit(Tool tool);

	void visit(Weapon weapon);

	void visit(Character character);

}
