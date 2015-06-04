package visitor.concrete;

import visitor.abstracts.FieldElement;
import visitor.abstracts.Visitor;

public abstract class Enemy implements FieldElement {

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "E";
	}
	
}
