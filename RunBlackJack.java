package labs;

import java.util.Scanner;

public class RunBlackJack {
	Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		RunBlackJack rbj = new RunBlackJack();
		rbj.menu();
		rbj.playBlackJack();
	}

	public void menu() {
		int bet;
		int money = 100;
		boolean playerWins;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("\t ***************************** ");
		System.out.println("\t * Cripple Creek's Blackjack * ");
		System.out.println("\t ***************************** ");
		System.out.println();
		System.out.print(" Please enter you name: ");
		String playerName = keyboard.next();
		System.out.println(" Hello " + playerName + ", Welcome to Blackjack.");

		while (true) {
			System.out.println("You have " + money + " dollars.");

			do {
				System.out.print("How many dollars do you want to bet?  (Enter 0 to end.)? ");
				bet = keyboard.nextInt();
				if (bet < 0 || bet > money) {
					System.out.println("Your answer must be between 0 and " + money + '.');
				}

			} while (bet < 0 || bet > money);
			if (bet == 0)
				break;
			playerWins = playBlackJack();
			if (playerWins) {
				money = money + bet;
			} else {
				money = money - bet;
			}
			System.out.println();
			if (money == 0) {
				System.out.println("Looks like you've are out of money!");
				System.out.println();
				System.out.println(playerName + ", you can recieve additional fees at the cash cage!");
				break;
			}
		}
		System.out.print("You leave with $" + money + '.');
		keyboard.close();
	}

	public boolean playBlackJack() {
		Deck deck = new Deck();
		PlayerHand dealerHand = new PlayerHand();
		PlayerHand playerHand = new PlayerHand();
		char userAction;

		deck.shuffleDeck();
		dealerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());

		
		if (dealerHand.getBlackJackValue() == 21) {
			System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
			System.out.println("User has the " + playerHand.getCard(0) + " and the " + playerHand.getCard(1) + ".");
			System.out.println();
			System.out.println("Dealer has Blackjack.  Dealer wins.");
			return false;
		}

		if (playerHand.getBlackJackValue() == 21) {
			System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
			System.out.println("User has the " + playerHand.getCard(0) + " and the " + playerHand.getCard(1) + ".");
			System.out.println();
			System.out.println("You have Blackjack.  You win.");
			return true;
		}

		while (true) {

			System.out.println();
			System.out.println("Your cards are:");
			for (int i = 0; i < playerHand.getCardCount(); i++) {
				System.out.println("    " + playerHand.getCard(i));
			}
			System.out.println("Your total is " + playerHand.getBlackJackValue());
			System.out.println();
			System.out.println("Dealer is showing the " + dealerHand.getCard(0));
			System.out.println();
			System.out.print("Hit (H) or Stand (S)? ");
			char key = keyboard.nextLine().charAt(0);
			do {
				userAction = Character.toUpperCase(key);
				if (userAction != 'H' && userAction != 'S')
					System.out.print("Please respond H or S:  ");
			} while (userAction != 'H' && userAction != 'S');

			if (userAction == 'S') {
				break;
			} else {
				Card newCard = deck.dealCard();
				playerHand.addCard(newCard);
				System.out.println();
				System.out.println("User hits.");
				System.out.println("Your card is the " + newCard);
				System.out.println("Your total is now " + playerHand.getBlackJackValue());

				if (playerHand.getBlackJackValue() > 21) {
					System.out.println();
					System.out.println("You busted by going over 21.  You lose.");
					System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
					return false;
				}
			}
		}
		System.out.println();
		System.out.println("User stands.");
		System.out.println("Dealer's cards are");
		System.out.println("    " + dealerHand.getCard(0));
		System.out.println("    " + dealerHand.getCard(1));

		while (dealerHand.getBlackJackValue() <= 16) {
			Card newCard = deck.dealCard();
			System.out.println("Dealer hits and gets the " + newCard);
			dealerHand.addCard(newCard);
			if (dealerHand.getBlackJackValue() > 21) {
				System.out.println();
				System.out.println("Dealer busted by going over 21.  You win.");
				return true;
			}
		}
		System.out.println("Dealer's total is " + dealerHand.getBlackJackValue());

		System.out.println();
		if (dealerHand.getBlackJackValue() == playerHand.getBlackJackValue()) {
			System.out.println("Dealer wins on a tie.  You lose.");
			return false;
		} else if (dealerHand.getBlackJackValue() > playerHand.getBlackJackValue()) {
			System.out.println("Dealer wins, " + dealerHand.getBlackJackValue() + " points to "
					+ playerHand.getBlackJackValue() + ".");
			return false;
		} else {
			System.out.println("You win, " + playerHand.getBlackJackValue() + " points to "
					+ dealerHand.getBlackJackValue() + ".");
			return true;
		}
	}
}
