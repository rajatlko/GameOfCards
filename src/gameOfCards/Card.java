package gameOfCards;

/* 
 * Card class is used to define and handle the functionality of each card.
 */
public class Card {
	
	private Suit suit;
	private Rank rank;
	protected boolean isFaceUp;
	
	public Card(Rank rank,Suit suit) {
		this.rank=rank;
		this.suit=suit;
		isFaceUp=false;
	}
	
	public String getSuit() {
		return suit.printSuit();
	}
	
	public int getRank() {
		return rank.getRank();
	}
	
	public String printRank() {		
		 return rank.printRank();
	}
	public int getPriority() {
		return suit.printPriority();
	}
	
	public String toString() {
		String str="";
		if(isFaceUp) {
		str+=rank.printRank()+" of "+suit.printSuit()+"\t";
		//
		System.out.println();
		}else {
			str="FaceDown(Nothing to see here)";
		}
		return str;
	}
	public void flipCard() {
		isFaceUp=true;
	}
}
