package gameOfCards;

/*
 * Rank is an enum class that defines all the cards for any particular suit along with their respective card value.
 */

public enum Rank {
	
	ACE(1,"Ace"),DEUCE(2,"2"),THREE(3,"3"),FOUR(4,"4"),FIVE(5,"5"),SIX(6,"6"),SEVEN(7,"7"),
	EIGHT(8,"8"),NINE(9,"9"),TEN(10,"10"),JACK(11,"Jack"),QUEEEN(12,"Queen"),KING(13,"King");
	
	private final int rankValue;
	private final String rankString;
	
	private Rank(int rankValue,String rankString) {
		this.rankValue=rankValue;
		this.rankString=rankString;
	}
	
	public int getRank() {
		return rankValue;
	}
	
	public String printRank() {
		return rankString;
	}
}
