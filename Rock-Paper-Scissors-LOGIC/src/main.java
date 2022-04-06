import java.util.Scanner;

class main{
  public static void main(String[] args) {
	  
	  
	  int user = 10;
		
		int computer = 10;
	  
	  try (//Initialize the Scanner and print a welcome message
		Scanner scnr = new Scanner(System.in)) {
			System.out.println("Welcome to the battle");
			
			

			//Use a while(true) loop and only break the loop if the user wants to quit
			while(true) {
			
				//Get the user's move through user input
				System.out.print("What is your move? To make a move, enter fire, water, or lighting. To quit the game, enter quit. ");
				String myMove = scnr.nextLine();
				
				//Check if the user wants to quit the game
				if(myMove.equals("quit")) {
					break;
				}

				//Check if the user's move is valid (rock, paper, or scissors)
				if(!myMove.equals("fire") && !myMove.equals("water") && !myMove.equals("lighting")) {

					System.out.println("Your move isn't valid!");
				
				} else {

					//Get a random number in between 0 and 3 and convert it to an integer so that the possibilities are 0, 1, or 2
					int rand = (int)(Math.random()*3);
					
					//Convert the random number to a string using conditionals and print the opponent's move
					String opponentMove = "";
					if(rand == 0) {
						opponentMove = "water";
					} else if(rand == 1) {
						opponentMove = "lightning";
					} else {
						opponentMove = "fire";
					}
					System.out.println("Opponent move: " + opponentMove);
					
					
						
					//Print the results of the game: tie, lose, win
					if(myMove.equals(opponentMove)) {
						System.out.println("It's a tie!");
					} 
					else if((myMove.equals("water") && opponentMove.equals("fire")) || (myMove.equals("fire") && opponentMove.equals("lightning")) || (myMove.equals("lightning") && opponentMove.equals("water"))) {
						System.out.println("You won!");
						computer -= 2;
						System.out.println("Your life = " +  user);
						System.out.println("Enemy life = " + computer);
						if(computer <= 0) {
							System.out.println("computer died");
							
						}
						
					} 
					else {
						System.out.println("You lost!");
						
						user -=2;
						
						System.out.println("Your life = " +  user);
						System.out.println("Enemy life = " + computer);
						
						if(user <= 0) {
							System.out.println("You died");
						}
						
						
					}

				}

			}
		}	
		
		//Print a final message for the user
		System.out.println("Thanks for playing!");

  }
}