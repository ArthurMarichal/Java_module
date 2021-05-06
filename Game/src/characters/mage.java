package characters;
public class mage {
//Initialisations des varibles.
	//private String image;
	private String name;
	private spells spell;
	private int attackPower;
	private int healthPoints;
//Constructeurs
	public mage() {
		super();
	}

	public mage(String name) {
		super();
		this.name = name;
	}

	public mage( String name, int healthPoints, int attackPower,spells spell, String image) {
		super();
		this.healthPoints = healthPoints;
		this.attackPower = attackPower;
		//this.image = image;
		this.name = name;
		this.spell = spell;
	}

	public String toString() {
		return name +" "+ healthPoints + " PV " + attackPower+ " PA " + spell + "|";
	}
	//Getter et Setter.
	public void setName(String name) { this.name = name; } 

	public String getName() { return name; } 

	public void setSpell(spells spell) { this.spell = spell; }

	public spells getSpell() { return spell; } 
	
	public void setHealth(int healthPoints) { this.healthPoints = healthPoints; } 

	public int getHealth() { return healthPoints; } 
	
	public void setPower(int attackPower) { this.attackPower = attackPower; } 

	public int getPower() { return attackPower;}


}