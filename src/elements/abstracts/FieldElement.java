package elements.abstracts;

public interface FieldElement {

	String getName();
	
	void accept(Visitor visitor);

}
