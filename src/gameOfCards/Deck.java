package gameOfCards;

import java.util.List;
import java.util.Random;

/*
 * Deck is a type of Hand. It has all the properties of Hand with some added functionalities.
 */
public class Deck extends Hand {
	
	Random rand=new Random();
	
	//Function to populate deck with pack of all cards.
	public void populate() {
		// loop for all of the suit and for each suit, create card of every rank.
		for(Suit suit:Suit.values()) {
			for(Rank rank:Rank.values()) {
				Card card=new Card(rank,suit);
				card.flipCard();
				this.add(card);
			}
		}
	}
	
	//Function to shuffle the deck of cards.
	public void shuffle() {
		for(int i=cards.size()-1;i>0;i--) {
			//swap the card between the beginning and
			//last card of the loop
			int pick=rand.nextInt(i);
			Card randCard=cards.get(pick);
			Card lastCard=cards.get(i);
			cards.set(i,randCard);
			cards.set(pick, lastCard);
		}
	}
	//Function to distribute cards from deck to other hands
	public void deal(List<Hand> hand,int perHand) {
		for(int i=0;i<perHand;i++) {
			for(int j=0;j<hand.size();j++) {
				this.give(cards.get(0),hand.get(j));
			}
		}
	}
	//Function to take back all the cards given to all hands back to Deck
	public void dealBack(List<Hand> hand)
	{
		for(int i=0;i<hand.size();i++) 
		{
			int num=hand.get(i).numOfCardsInHand();
			for(int j=0; j<num; j++) 
			{
				hand.get(i).give(hand.get(i).getCard(),this);
			}
		}
	}
	

	public void flipCard(Card c) {
		c.flipCard();
	}
	
	
}
