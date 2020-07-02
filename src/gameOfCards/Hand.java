package gameOfCards;

import java.util.ArrayList;
/*
 * Hand is a java class for each players in the game.
 */
public class Hand {
	
	protected ArrayList<Card> cards;
	
	public Hand() {
		//Constructor to create a hand(player)
		cards=new ArrayList<Card>();
	}	
	
	// Function to add cards for each player
	public void add(Card card) {
		cards.add(card);
	}
	
	//Function to display the cards for each player along with their total points
	public String showHand() {
		String str="";
		for(Card c:cards) {
			str=str+" "+c.toString()+"\n";
		}
		return str;
	}
	
	// Function to flip the card. A card can either face up or face down.
	public void flipCards() {
		for(Card c:cards) {
			c.flipCard();
		}
	}
	
	//Function to move card from one hand to another hand.
	public boolean give(Card card,Hand otherHand) {
		if(!cards.contains(card)) {
			return false;
		}
		else {
			
			cards.remove(card);
			otherHand.add(card);
			return true;
		}
	}
	
	//Function to get the total points for each players card
	public int getTotal() {
		int totalPts=0;
		boolean hasAce=false;
		
		for(int i=0;i<cards.size();i++) {
			totalPts+=cards.get(i).getRank();
			//check if the card is ace
			if(cards.get(i).printRank()=="Ace") {
				hasAce=true;
			}
			//Make ace worth 11 if total points are less then and equal 11(Ace is worth 1 point by default)
			if(hasAce && totalPts<=11) {
				totalPts+=10;
			}
		}
		return totalPts;
	}
	/* 
	 * Function to find total point for each player based on their card weightage.
	 * checking for the card priority - SPADES>HEART>CLUB>DIAMONDS
	*/
	public int getTotalWithPriority() {
		int totalPts=0;
		boolean hasAce=false;
		//Get total point(Any ace by default is 1)
		for(int i=0;i<cards.size();i++) {
			totalPts+=(cards.get(i).getRank()*cards.get(i).getPriority());
			//check if the card is ace
			if(cards.get(i).printRank()=="Ace") {
				hasAce=true;
			}
			//Make ace worth 11 if total points are less then and equal 11
			if(hasAce && totalPts<=11) {
				totalPts+=10;//add more to ace
			}
		}
		return totalPts;
	}
	// Function to get number of cards for each player(Hand).
	public int numOfCardsInHand() {
		return this.cards.size();
	}
	
	//Function to get first card from the list of card for a Hand.
	public Card getCard() {
		Card card=cards.get(0);
		return card;
	}
	
}
