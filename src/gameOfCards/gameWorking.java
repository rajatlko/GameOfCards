package gameOfCards;

import java.util.List;

/*
 * GameWorking is the service class for the Game of Cards which contains the business logic for the game.
 */
public class gameWorking {
	private Deck d1;
	
	gameWorking(){
		d1=new Deck();
		d1.populate();
	}
	
	public void cardSchuffle() {
		d1.shuffle();
	}
	
	public void dealTheCards(List<Hand> lst,int numOfCards) {
		d1.deal(lst, numOfCards);
	}
	public void showDeckCards() {
		System.out.println(d1.showHand());
	}
	
	public void showPlayersCard(List<Hand> lst) {
		for(int i=0;i<lst.size();i++) {
			lst.get(i).flipCards();
			System.out.println(lst.get(i).showHand());
		}
	}
	
	//Function to find the winner in a game
	public void getWinner(List<Hand> lst) {
		Hand winner=lst.get(0);
		int winnerIndex=0;
		for(int i=0;i<lst.size();i++) {
			if(lst.get(i).getTotal()>winner.getTotal()) {
				winner=lst.get(i);
				winnerIndex=i;
			}
			else if(lst.get(i).getTotal()==winner.getTotal()) {
				if(lst.get(i).getTotalWithPriority()> winner.getTotalWithPriority()) {
					 winner=lst.get(i);
					 winnerIndex=i;
				}
			}
			
		}		
		System.out.println("Winner of the Game is Player: "+winnerIndex);
		System.out.println("It has : "+winner.showHand());
		d1.dealBack(lst); //returning back all the cards to deck
	}
}
