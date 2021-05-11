package characters;

public class Monster extends Characters {

	public Monster(int attackPower, int healthPoints, String name) {
		super(attackPower, healthPoints, name);
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		return getName() + " " + getHealth() + " PV " + getPower() + " PA ";
	}

}
