package application.model;

public class Person {
	//private String name;
	private static int health;
	private static int maxHealth;
	private static int mana;
	private static int maxMana;

//constructor
	public Person( int health, int maxHealth, int mana, int maxMana) {
		//this.name = name;
		Person.health = health;
		Person.maxHealth = maxHealth;
		Person.mana = mana;
		Person.maxMana = maxMana;
	}

//setter
	/*
	public void setName(String name) {
		this.name = name;
	}
	*/
	public void setHealth(int health) {
		Person.health = health;
	}
	
	public int setMana(int manaGain) {
		return Person.mana;
	}

	// getter
	/*
	public String getName() {
		return this.name;
	}
*/
	public int getHealth() {
		return Person.health;
	}
	
	public int getMaxHealth() {
		return Person.maxHealth;
	}
	
	public int getMana() {
		return Person.mana;
	}
	
	public int getMaxMana() {
		return Person.maxMana;
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
		Person.health += dice1;
		return dice1;
	}
	public void healDice(int dice1) { 
		Person.health += dice1;
		System.out.println("NAME has healed for " +dice1);
		//return getName() + " has healed for " + dice1+"\n";
	}
	
	public void reroll(TwoDice dice) { 
		dice.roll();
		
		System.out.println("Nmae has rolled dice");
		//return getName() + " has rerolled \n";
	}
	
	public void takeDamage(int attackpower) {
		Person.health -= attackpower;
//		System.out.println(getName() + " has taken " + attackpower);
//		return getHealth();
		
		System.out.println("NAME has taken" + attackpower);
		//return getName() + " has taken " + attackpower;
	}
	
	/*

	// toString method returns name with getter
	public String toString() {
		return getName();
	}
	*/
}
