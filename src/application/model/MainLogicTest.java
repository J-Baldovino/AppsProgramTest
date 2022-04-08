//package application.model;
//
//import java.util.ArrayList;
//
//public class MainLogicTest {
//	public static void main(String[] args) {
//
//		Person player;
//		player = new Person("Hero", 10);
//
//		TwoDice dice;
//		dice = new TwoDice();
//		dice.roll();
//		
//		ArrayList<Monster> list = new ArrayList<>();
//		Monster gremlin;
//		gremlin = new Monster("Gremlin", 10, 3);
//		list.add(gremlin);
//		Monster gremlin2;
//		gremlin2 = new Monster("Gremlin2", 10, 7);
//		list.add(gremlin2);
		

//		System.out.println(player.getName() + " has " + player.getHealth() + " hp");
//		System.out.println(gremlin.getName() + " has " + gremlin.getHealth() + " hp and " + gremlin.getAttackPower() + " Attack Power");
//		
//		
//		System.out.println("Dice one: " + dice.getDie1() + " Dice two: " + dice.getDie2());

//		System.out.println(player.takeDamage(list.get(0).getAttackPower()));
//		System.out.println(gremlin.takeDamage( player.basicStrike(dice.getDie1())) ); //player stike goes into gremlin takeDamage to do damage
//		System.out.println(gremlin.takeDamage( player.multiplicationStrike(dice.getDie1(), dice.getDie2())));
//		System.out.println(gremlin.takeDamage( player.dicePair(dice.getDie1(), dice.getDie2())))
//		System.out.println(gremlin.takeDamage( player.luckySeven(dice.getDie1(), dice.getDie2())));
//		System.out.println(list.get(0).takeDamage( player.drainDice(dice.getDie1())));
//		System.out.print(player.healDice(dice.getDie2()));
//		System.out.print(player.reroll(dice));
//		System.out.println("Dice one: " + dice.getDie1() + " Dice two: " + dice.getDie2());
//		System.out.println(list.get(0).takeDamage( player.drainDice(dice.getDie1())));
		
		
		//how its going to be 
//		while( player.getHealth() > 0 && list.get(0).getHealth() > 0)
//		{
//			dice.roll();
//			System.out.println("Dice one: " + dice.getDie1() + " Dice two: " + dice.getDie2());
//			//System.out.println(list.get(0).takeDamage( player.basicStrike(dice.getDie1())) );
//			System.out.println(player.takeDamage(list.get(0).getAttackPower()));
//			if(player.getHealth() <= 0)
//			{
//				System.out.println(player.getName() + " has died");
//			}
//			if(list.get(0).getHealth() <= 0)
//			{
//				System.out.println(list.get(0).getName()+ " has died" );
//			}
//		}
//		
//		
//		System.out.println(player.getName() + " has " + player.getHealth() + " hp");
//		System.out.println(gremlin.getName() + " has " + gremlin.getHealth() + " hp");
//	}
//}



//if (gremlin.getHealth() <= 0) {
//System.out.println(gremlin.getName() + " is dead");
//} else {
//System.out.println(gremlin.getName() + " attacks with " + gremlin.getAttackPower() + " now " + player.getName() + " has: " + player.takeDamage(gremlin.getAttackPower()) + " hp");
//}
//
//if(player.getHealth() <= 0)
//{
//System.out.print("You lost");
//}