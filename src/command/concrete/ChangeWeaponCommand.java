package command.concrete;

import command.abstracts.Command;
import elements.abstracts.Character;
import elements.abstracts.Weapon;
import elements.concrete.Hero;

public class ChangeWeaponCommand implements Command {

	private Character character;
	private String weaponName;

	public void setCharacter(Character character) {
		this.character = character;
	}

	public ChangeWeaponCommand(String weaponName) {
		this.weaponName = weaponName;
	}

	@Override
	public void execute() {
		Weapon newWeapon = ((Hero) this.character)
				.getWeaponByName(this.weaponName);
		if (newWeapon != null) {
			if (newWeapon.equals(this.character.getWeapon())) {
				System.out.println(String.format("You are already using %s!",
						this.character.getWeapon().getName()));
				return;
			}

			this.character.setWeapon(newWeapon);
			System.out.println(String.format("You are now using %s!",
					this.character.getWeapon().getName()));
		} else {
			System.out.println(String.format("You don't have %s!",
					this.weaponName));
		}
	}
}
