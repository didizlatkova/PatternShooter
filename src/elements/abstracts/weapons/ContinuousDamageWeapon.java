package elements.abstracts.weapons;

public abstract class ContinuousDamageWeapon extends Weapon {

	public boolean isOn;

	@Override
	public void fire() {
		this.isOn = true;
		super.fire();
	}

	public ContinuousDamageWeapon(int damagePoints) {
		super(damagePoints);
	}

}
