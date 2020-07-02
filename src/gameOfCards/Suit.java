package gameOfCards;

/*
 * Suit is an enum class that defines four suits- Spades, Heart, Club and Diamond
 */
public enum Suit {
	
	SPADES("Spades",4),
	HEART("Hearts",3),
	CLUB("Club",2),
	DIAMONDS("Diamond",1);
	private final String suitText;
	private final int suitPriority;
	
	private Suit(String suitText,int suitPriority) {
		this.suitText=suitText;
		this.suitPriority=suitPriority;
	}
	public String printSuit() {
		return suitText;
	}
	public int printPriority() {
		return suitPriority; 
	}
	
	
}
