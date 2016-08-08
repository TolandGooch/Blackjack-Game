package labs;

public class BlackJackDeck {
	private Card [] deck;
	private int cardsUsed;
	
	public BlackJackDeck(){
	Card []deck = new Card[52] ; 
	int countOfDeck = 0;
       for ( int suit = 0; suit <4; suit++ ){
			//for (Rank r : BlackJackRank.values()) {
            for (int rank = 1; rank <=13; rank++) {  
    	   		deck[countOfDeck] = Card(rank, suit);
    	   		countOfDeck++;
            }             
        }
       cardsUsed =0;
	}
      
	public void shuffleDeck() {
		for (int i = 1; i < 53; i ++) {
			int randNum = (int) (Math.random() * (i-1));
			Card temp = deck[i];
			deck[i] = deck[randNum];
			deck[randNum] = temp;
		}
	}

}
