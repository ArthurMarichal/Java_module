package characters;
public class Weapons extends Weaspell{
	
	public String toString(){
		return "Son arme : " + getWeapon() + ", Ses dégats : " + getDamage();
	}
	public Weapons(String weapon, int damage) {
		super(weapon, damage);
	
	}
	
	
}