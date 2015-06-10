package elements.abstracts;

import engine.helpers.ToolType;
import visitor.abstracts.Visitor;

public abstract class Tool extends Item {
	
	public ToolType type;

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
