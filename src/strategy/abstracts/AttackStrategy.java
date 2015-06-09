package strategy.abstracts;

import engine.concrete.Field;

public interface AttackStrategy {

	void attack();
	
	void setField(Field field);
	
}
