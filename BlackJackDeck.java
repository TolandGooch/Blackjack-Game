package labs;

public class BlackjackDeck {
	private Card [] deck;
	private int cardsUsed;
	
	public BlackjackDeck(){
	deck = new Card[52] ; 
	int countOfDeck = 0;
       for ( int suit = 0; suit <= 3; suit++ ){
			//for (Rank r : BlackJackRank.values()) {
            for (int rank = 1; rank <=13; rank++) {  
    	   		deck[countOfDeck] = new Card(rank, suit);
    	   		countOfDeck++;
            }             
        }
       cardsUsed = 0;
	}
      
	public void shuffleDeck() {
		for (int i = 1; i < 53; i ++) {
			int randNum = (int) (Math.random() * (i-1));
			Card temp = deck[i];
			deck[i] = deck[randNum];
			deck[randNum] = temp;
		}
		cardsUsed = 0;
	}

	public int cardsLeftInDeck() {
      return 52 - cardsUsed;
  }
  
  public Card dealCard() {
      if (cardsUsed == 52)
         shuffleDeck();
      cardsUsed++;
      return deck[cardsUsed - 1];
  }

}
