package characters;
public class Spells extends Weaspell{

	
	public String toString(){
		return "Son sort : " + getWeapon() + ", Ses dégats : " + getDamage();
	}
	public Spells(String weapon, int damage) {
		super(weapon, damage);
	
	}
}