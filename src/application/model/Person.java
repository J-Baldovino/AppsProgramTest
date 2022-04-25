package application.model;

public class Person {
	//private String name;
	private static int health = 10;
	private static int maxHealth = 10;
	private static int mana = 0;
	private static int maxMana = 10;
	private static int battlesWon = 0;
	private static int shield = 0;
	private static int score = 0;
	private static String name="";

	public void reset() {
		Person.health = 10;
		Person.maxHealth = 10;
		Person.mana = 0;
		Person.maxMana = 10;
		Person.battlesWon = 0;
		Person.shield = 0;
		Person.score = 0;
		Person.name = "";
	}
	public void setScore() {
		Person.score += 100;
	}
	public int getScore() {
		return Person.score;
	}
	public void setHealth(int health) {
		Person.health = health;
	}
	
	public int setMana(int manaGain) {
		return Person.mana;
	}
	
	public void setBattlesWon() {
		Person.battlesWon++;
	}
	
	public static void setName(String n)
	{
		Person.name=n;
	}
	
	public String retName()
	{
		return Person.name;
	}

	public int getHealth() {
		return Person.health;
	}
	
	public int getBattlesWon() {
		return Person.battlesWon;
	}
	
	public int getMaxHealth() {
		return Person.maxHealth;
	}
	
	public int getMana() {
		return Person.mana;
	}
	
	public int addMana(int manaToAdd) {
		Person.mana += manaToAdd;
		if(Person.mana > maxMana)
		{
			Person.mana = 10; 
		}
		return manaToAdd;
	}
	
	public void subMana(int manaToSub) {
		if(Person.mana - manaToSub < 0)
		{
			Person.mana = 0; 
		}
		else
		{
			Person.mana -= manaToSub;
		}

	}
	
	public int getMaxMana() {
		return Person.maxMana;
	}
	
	
	public String getHealthRatio() {
		return Integer.toString(getHealth()) + " / " + Integer.toString(getMaxHealth());
	}

	public int getShield() {
		return Person.shield;
	}
	
	public int basicStrike(int diceRoll) {
		return diceRoll;

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
	}
	
	public void reroll(TwoDice dice) { 
		dice.roll();
		
		System.out.println("Nmae has rolled dice");
	}
	
	public void takeDamage(int attackpower) {
		int damage = attackpower - Person.shield;
		
		if(damage <= 0)
		{
			damage = 0;
		}
		
		Person.health -= damage;
		if(Person.health<0)
		{
			Person.health=0;
		}

		
		System.out.println("NAME has taken" + attackpower);

	}
	

	
	public void mana(int dice1) {
    	Person.mana += dice1;
    	
    	if(Person.mana >= 10) {
    		Person.mana = 10;
    	}
    	
    	//Set textbox to current mana
    
    }
	
	//Need to make sure that the mana is enough
	
	 public int strike(int dice1) {
		 
		 return dice1;
	    	
	    }
	    
	    public int multistrike(int dice1) {
	    	
	    	
	    	return dice1 * dice1;
	    }
	    
	    public int heal(int dice1) {
	    	
	    	if(Person.mana >= 4) {
	    	Person.mana -= 4;
	    	}
	    	else {
	    		//NO MANA WAIT FOR NEXT TURN
	    		dice1 = 0;
	    		
	    	}
	    	
	    			return dice1;
	    }
	    
	    public void healing(int dice1) {
	    	Person.health+=dice1;
	    	if( Person.health >= Person.maxHealth )
	    	{
	    		Person.health=Person.maxHealth;
	    	}
	    }
	    
	    public int defend(int dice1) {
	    	if(Person.mana >= 2) {
	    	Person.mana -= 2;
	    	}
	    	
	    	else {
	    		dice1 = 0;
	    	}
	    	
	    	return dice1;
	    }
	    
	    public int defending(int dice1) {
	    	Person.shield+= dice1;
	    	
	    	return dice1;
	    }
	    
	    public void resetShield() {
	    	Person.shield = 0;
	    }
}
