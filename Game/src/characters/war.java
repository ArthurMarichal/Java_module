package characters;
public class war {
	//Initialisations des varibles.

	//private String image;
	private String name;
	private weapons weapon; 
	int attackPower;
	int healthPoints;
//Constructeurs
	public war() {
		super();
	}

	public war(String name) {
		super();
		this.name = name;
	}

	public war(String name, int healthPoints, int attackPower,weapons weapon, String image ) {
		super();
		this.healthPoints = healthPoints;
		this.attackPower = attackPower;
		//this.image = image;
		this.name = name;
		this.weapon = weapon;
	}

	public String toString() {
		return name +" "+ healthPoints + " PV " + attackPower+ " PA " + weapon + "|";
	}
	//Getter et Setter.
	public void setName(String name) { this.name = name; } 

	public String getName() { return name; } 

	public void setWeapon(weapons weapon) { this.weapon = weapon; }

	public weapons getWeapon() { return weapon; }  
	
	public void setHealth(int healthPoints) { this.healthPoints = healthPoints; } 

	public int getHealth() { return healthPoints; } 
	
	public void setPower(int attackPower) { this.attackPower = attackPower; } 

	public int getPower() { return attackPower; } 
}