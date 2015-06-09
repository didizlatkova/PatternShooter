package elements.abstracts;


public interface Visitor {

	void visit(Tool tool);

	void visit(Weapon weapon);

	void visit(Character character);

}
