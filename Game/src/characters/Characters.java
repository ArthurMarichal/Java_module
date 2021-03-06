package characters;

abstract class Characters {

	private int attackPower;
	private int healthPoints;
	private String name;
	
	public Characters(int attackPower, int healthPoints, String name) {
		super();
		this.attackPower = attackPower;
		this.healthPoints = healthPoints;
		this.name = name;
	}
	public String toString()
	{
		return getName() + " " + getHealth() + " PV " + getPower() + " PA"; 
	}

	public void setName(String name) { 
		this.name = name; 
	} 

	public String getName() { return name; } 
	
	public void setHealth(int healthPoints) { this.healthPoints = healthPoints; } 

	public int getHealth() { return healthPoints; } 
	
	public void setPower(int attackPower) { this.attackPower = attackPower; } 

	public int getPower() { return attackPower;}
}
