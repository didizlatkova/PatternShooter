package visitor.abstracts;

import visitor.concrete.Tool;
import visitor.concrete.Weapon;

public interface Visitor {

	void visit(Tool tool);

	void visit(Weapon weapon);

	void visit(Character character);

}
