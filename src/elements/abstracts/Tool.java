package elements.abstracts;


public abstract class Tool extends Item {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
