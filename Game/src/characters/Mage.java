package characters;
public class Mage extends Characters{
//Initialisations des varibles.	
	private Spells spell;

//Constructeurs
	public Mage(int attackPower, int healthPoints, String name, Spells spell) {
		super(attackPower, healthPoints, name);
		// TODO Auto-generated constructor stub
		this.spell = spell;
	}


	public String toString()
	{
		return getName() + " " + getHealth() + " PV " + getPower() + " PA " + getSpell();
	}
	//Getter et Setter.
	

	public void setSpell(Spells spell) { this.spell = spell; }

	public Spells getSpell() { return spell; } 
	



}