package proxy.abstracts;

import elements.concrete.Hero;
import engine.concrete.Field;

public interface TurnManager {

	void takeTurn(Field field, Hero hero);

}
