package characters;
public class War extends Characters{
//Initialisations des varibles.	
	private Weapons weapon;

//Constructeurs
	/**
	 * 
	 * @param attackPower
	 * @param healthPoints
	 * @param name
	 * @param weapon
	 */
	public War(int attackPower, int healthPoints, String name, Weapons weapon) {
		super(attackPower, healthPoints, name);
		// TODO Auto-generated constructor stub
		this.weapon = weapon;
	}


	public String toString()
	{
		return getName() + " " + getHealth() + " PV " + getPower() + " PA " + getWeapon();
	}
	//Getter et Setter.
	

	public void setWeapon(Weapons weapon) { this.weapon = weapon; }

	public Weapons getWeapon() { return weapon; } 
	



}
