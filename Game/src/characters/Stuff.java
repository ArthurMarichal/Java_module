package characters;

public class Stuff extends Weaspell {

	public Stuff(String weapon, int damage) {
		super(weapon, damage);
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return getWeapon() +" " + getDamage();
	}
}
