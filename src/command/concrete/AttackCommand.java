package command.concrete;

import command.abstracts.Command;
import elements.abstracts.Character;
import engine.concrete.Field;

public class AttackCommand implements Command {

	private Field field;
	private Character character;

	public void setField(Field field) {
		this.field = field;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
