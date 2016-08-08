package labs;

import java.util.Scanner;

public class RunBlackJack {
	Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
		playBlackJack();
	}

	public static void menu() {
		int bet;
		int money;
		boolean playerWins;

		Scanner keyboard = new Scanner(System.in);
		System.out.print(" *** Blackjack *** ");
		System.out.print(" Please enter you name: ");
		String playerName = keyboard.next();
		System.out.print(" Hello " + playerName + ", Welcome to Blackjack.");

		while (true) {
			System.out.println("You have " + money + " dollars.");
			do {
				System.out.print("How many dollars do you want to bet?  (Enter 0 to end.)? ");

				bet = keyboard.nextInt();
				if (bet < 0 || bet > money)
					System.out.println("Your answer must be between 0 and " + money + '.');
			} while (bet < 0 || bet > money);
			if (bet == 0)
				break;
			playerWins = playBlackJack();
			if (playerWins)
				money = money + bet;
			else
				money = money - bet;
			System.out.println();
			if (money == 0) {
				System.out.println("Looks like you've are out of money!");
				break;
			}

			System.out.print("You leave with $" + money + '.');
			keyboard.close();
		}
	}

public static boolean playBlackJack() {
		Deck deck;
		BlackjackHand dealerHand;
		BlackjackHand playerHand;
		
		deck.shuffle();
		dealerHand.addCard( deck.dealCard() );
		dealerHand.addCard( deck.dealCard() );
		playerHand.addCard( deck.dealCard() );
		playerHand.addCard( deck.dealCard() );
		
		if (dealerHand.getBlackjackValue() == 21) {
            System.out.print("Dealer has the " + dealerHand.getCard(0)
                                    + " and the " + dealerHand.getCard(1) + ".");
            System.out.print("User has the " + playerHand.getCard(0)
                                      + " and the " + playerHand.getCard(1) + ".");
            System.out.println();
            System.out.println("Dealer has Blackjack.  Dealer wins.");
            return false;
       }
       
       if (playerHand.getBlackjackValue() == 21) {
            System.out.println("Dealer has the " + dealerHand.getCard(0)
                                    + " and the " + dealerHand.getCard(1) + ".");
            System.out.println("User has the " + playerHand.getCard(0)
                                      + " and the " + playerHand.getCard(1) + ".");
            System.out.println();
            System.out.println("You have Blackjack.  You win.");
            return true;
       }
       
       while (true) {
    	   
           System.out.println();
           System.out.println("Your cards are:");
           for ( int i = 0; i < playerHand.getCardCount(); i++ ){
              System.out.println("    " + playerHand.getCard(i));
           }
           System.out.println("Your total is " + playerHand.getBlackjackValue());
           System.out.println();
           System.out.println("Dealer is showing the " + dealerHand.getCard(0));
           System.out.println();
           System.out.print("Hit (H) or Stand (S)? ");
           char userAction;  // User's response, 'H' or 'S'.
           do {
              userAction = Character.toUpperCase(userAction);
              if (userAction != 'H' && userAction != 'S')
                 System.out.print("Please respond H or S:  ");
           } while (userAction != 'H' && userAction != 'S');

           /* If the user Hits, the user gets a card.  If the user Stands,
              the loop ends (and it's the dealer's turn to draw cards).
           */

           if ( userAction == 'S' ) {
                   // Loop ends; user is done taking cards.
               break;
           } else {  // userAction is 'H'.  Give the user a card.  
                   // If the user goes over 21, the user loses.
               Card newCard = deck.dealCard();
               playerHand.addCard(newCard);
               System.out.println();
               System.out.println("User hits.");
               System.out.println("Your card is the " + newCard);
               System.out.println("Your total is now " + playerHand.getBlackjackValue());
               
               if (playerHand.getBlackjackValue() > 21) {
                   System.out.println();
                   System.out.println("You busted by going over 21.  You lose.");
                   System.out.println("Dealer's other card was the " 
                                                      + dealerHand.getCard(1));
                   return false;  
                }
                	   
           }}
	}
