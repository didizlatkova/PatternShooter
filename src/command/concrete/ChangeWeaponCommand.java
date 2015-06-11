package command.concrete;

import command.abstracts.Command;
import elements.abstracts.Item;
import elements.abstracts.characters.Character;
import elements.abstracts.weapons.Weapon;
import elements.concrete.Hero;

public class ChangeWeaponCommand implements Command {

	private Hero character;
	private String weaponName;

	public void setCharacter(Character character) {
		this.character = (Hero) character;
	}

	public ChangeWeaponCommand(String weaponName) {
		this.weaponName = weaponName;
	}

	@Override
	public void execute() {
		Item newWeapon = (this.character).getItemByName(this.weaponName);
		if (newWeapon != null && newWeapon instanceof Weapon) {
			if (newWeapon.equals(this.character.getWeapon())) {
				System.out.println(String.format("You are already using %s!",
						this.character.getWeapon().getName()));
				return;
			}

			this.character.setWeapon((Weapon) newWeapon);
			System.out.println(String.format("You are now using %s!",
					this.character.getWeapon().getName()));
		} else {
			System.out.println(String.format("You don't have %s!",
					this.weaponName));
		}
	}
}
