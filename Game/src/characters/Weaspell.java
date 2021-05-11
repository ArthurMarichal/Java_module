package characters;

abstract class Weaspell {
	//Variables
	String weapon;
	int damage;
	//Constructeur
	public Weaspell(String weapon, int damage) {
		this.weapon = weapon;
		this.damage = damage;
	}
	
	
	@Override
	public String toString() {
		return getWeapon() +" " + getDamage();
	}


	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	}