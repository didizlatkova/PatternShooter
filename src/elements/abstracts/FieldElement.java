package elements.abstracts;

import visitor.abstracts.Visitor;

public interface FieldElement {

	String getName();
	
	void accept(Visitor visitor);

}
