package application.model;

public class Monster {
	private String name;
	private int health;   
	private int attackPower;

//constructor
	public Monster(String name, int health, int attackPower) {
		this.name = name; // "Gremlin";
		this.health = health;// 4;
		this.attackPower = attackPower;
	}

//setter
	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	// getter
	public String getName() {
		return this.name;
	}

	public int getHealth() {
		return this.health;
	}

	public int getAttackPower() {
		return this.attackPower;
	}

	// toString method returns name with getter
	public String takeDamage(int damage) {
		this.health -= damage;
		if(this.health<=0)
		{
			this.health=0;
		}
		return getName() + " has taken " + damage;
	}
}
