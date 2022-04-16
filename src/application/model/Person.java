package application.model;

public class Person {
	private String name;
	private int health;
	private int maxHealth;
	private int mana;
	private int maxMana;

//constructor
	public Person(String name, int health, int maxHealth, int mana, int maxMana) {
		this.name = name;
		this.health = health;
		this.maxHealth = maxHealth;
		this.mana = mana;
		this.maxMana = maxMana;
	}

//setter
	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int setMana(int manaGain) {
		return this.mana;
	}

	// getter
	public String getName() {
		return this.name;
	}

	public int getHealth() {
		return this.health;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	public int getMaxMana() {
		return this.maxMana;
	}
	
	
	public String getHealthRatio() {
		return Integer.toString(getHealth()) + " / " + Integer.toString(getMaxHealth());
	}

	public int basicStrike(int diceRoll) {
//		System.out.println(getName() + " uses basic strike for " + attackpower + "!");
		return diceRoll;
//		return getName() + " uses basic strike for " + attackpower + "!";
	}
	public int multiplicationStrike(int dice1, int dice2) {
		return dice1 * dice2;
	}
	public int snakeEyes(int dice1, int dice2) { //it means rolling 2 ones
		if(dice1 == 1 && dice2 == 1)
		{
			return 12;
		}
		else {
			return 0;
		}
	}
	public int dicePair(int dice1, int dice2) { 
		if(dice1 == dice2)
		{
			return dice1 * dice2 * 2;
		}
		else {
			return 0;
		}
	}
	public int luckySeven(int dice1, int dice2) { 
		if(dice1 + dice2 == 7)
		{
			return 14;
		}
		else {
			return 0;
		}
	}
	public int drainDice(int dice1) { 
		this.health += dice1;
		return dice1;
	}
	public String healDice(int dice1) { 
		this.health += dice1;
		return getName() + " has healed for " + dice1+"\n";
	}
	
	public String reroll(TwoDice dice) { 
		dice.roll();
		return getName() + " has rerolled \n";
	}
	
	public String takeDamage(int attackpower) {
		this.health -= attackpower;
//		System.out.println(getName() + " has taken " + attackpower);
//		return getHealth();
		return getName() + " has taken " + attackpower;
	}

	// toString method returns name with getter
	public String toString() {
		return getName();
	}
}
