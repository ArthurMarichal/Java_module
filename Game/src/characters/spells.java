package characters;
public class spells{
	//Varibles.
	String spell;
	int damage;
	//Constructeurs.
	public spells(String spell, int damage) {
		this.spell = spell;
		this.damage = damage;
	}
	public String toString(){
		return "Son sort : " + spell + ", Ses dégats : " + damage;
	}
	
	
}