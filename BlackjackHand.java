package labs;

public class BlackjackHand extends Hand{
	 
	     public int getBlackjackValue() {

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



