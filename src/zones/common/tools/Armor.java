package zones.common.tools;

import elements.abstracts.Tool;
import elements.abstracts.Weapon;
import engine.helpers.ToolType;

public class Armor extends Tool {

	public Armor() {
		this.type = ToolType.Armor;
	}

	@Override
	public String toString() {
		return "A";
	}

	@Override
	public String getName() {
		return "Armor";
	}

	@Override
	public void takeAttack(Weapon weapon) {
		
	}

}
