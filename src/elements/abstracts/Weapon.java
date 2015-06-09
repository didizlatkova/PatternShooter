package elements.abstracts;


public abstract class Weapon extends Item {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
