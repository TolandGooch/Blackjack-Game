package labs;

public class Deck {
	private Card [] deck;
	private int cardsUsed;
	
	public Deck(){
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
		// Out of bounds (will try to access the 52nd element in a length 52 array)
                // for (int i = 1; i < 53; i ++) { 
		for (int i = 0; i < 52; i ++) {
			// Will begin at a negative number
                        // int randNum = (int) (Math.random() * (i - 1));
			int randNum = (int) (Math.random() * (i));
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
