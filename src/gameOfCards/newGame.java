package gameOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
 * newGame is the main class for our card game	 * 
 */

public class newGame {

		public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		boolean bool=true;
		System.out.println("---**--- Welcome to the Game Of Cards !! ---**---");
		System.out.println("Do you want to play the game ? Yes/No");		
		String userChoice=scn.next();
		
		/* 
		 * Displaying catalogue for Card Game		 
		 */
		if(userChoice.equalsIgnoreCase("Yes")) {
			List<Hand> Players=new ArrayList<>();
			gameWorking gwk=new gameWorking();
			boolean status=false;
			while(bool) {
			System.out.println("1. Add/Remove players from the game.");
			System.out.println("2. Shuffle the deck");
			System.out.println("3. Print the cards present on the deck.");
			System.out.println("4. Start the Game!!");
			System.out.println("5. Show Cards of each Players");
			System.out.println("6. Find winnner");
			System.out.println("7. Exit");
			System.out.println("Enter your choice");
			int choice = scn.nextInt();
			
			switch(choice) {
			case 1: {
						// Code to add or remove players from the game.
						System.out.println(" No of players are :"+ Players.size());
						System.out.println("To add a player press 1 and to remove a player press 2");
						int num=scn.nextInt();
						if(num==1) {
							Hand h=new Hand();
							Players.add(h);
						}
						else if(num==2) {
							if(Players.isEmpty()) {
								System.out.println("There are no players to remove");
							}
							else {
								Players.remove(Players.size()-1);
							}
						}
						break;
					}
			case 2:{
						// Code to shuffle deck of cards
						gwk.cardSchuffle();
						System.out.println("Deck has been shuffled!");
						break;
					}
			case 3:{
						// Code to show deck of cards
						gwk.showDeckCards();
						break;
					}
			case 4:{
						// Code to start new game
						if(Players.size()!=0) {
							status=true;
							System.out.println("how many cards you want to deal ? ");
							int numOfCards=scn.nextInt();
							gwk.dealTheCards(Players, numOfCards);
						}
						else {
							System.out.println("There is no one to play the game. Please add some players and then start again");
						}
						break;
					}
			case 5:{
						// Code to show players card
						if(status && Players.size()!=0) {
							gwk.showPlayersCard(Players);
						}
						else {
							System.out.println("please start the game first");
						}
						break;
					}
			case 6:{
						// Code to find and display winner for the game
						if(status) {
							gwk.getWinner(Players);
						}
						else {
							System.out.println("Please start the game first");
						}
						break;
					}
			case 7:{
						bool=false;
						status=false;
						break;
					}
			
			}		// end of switch	
			}
		}
		System.out.println("---Thank You for Visiting---");
	}
}
