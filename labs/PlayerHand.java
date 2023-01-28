package labs;

public class PlayerHand extends Hand{
	 
	     public int getBlackJackValue() {

	         int valueOfHand;      
	         boolean isAce;  
	         int cardsInHand;    

	         valueOfHand = 0;
	         isAce = false;
	         cardsInHand = getCardCount();

	         for ( int i = 0;  i < cardsInHand;  i++ ) {
	             Card card;  
	             int cardValue;  
	             card = getCard(i);
	             // getValue() is not a method on BlackJackCard
	             // Added on to BlackJackCard class that returns an int
	             cardValue = card.getValue();  
	             if (cardValue > 10) {
	                 cardValue = 10;   
	             }
	             if (cardValue == 1) {
	                 isAce = true;     
	             }
	             valueOfHand = valueOfHand + cardValue;
	          }

	          if ( isAce == true  &&  valueOfHand + 10 <= 21 ){
	              valueOfHand= valueOfHand + 10;
	          }
	          return valueOfHand;
	     } 
	} 
