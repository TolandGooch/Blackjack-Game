package labs;

public class Card { 
	int rank;
	int suit;
	public final static int CLUBS =0;
	public final static int DIAMONDS =1;
	public final static int HEARTS =2;
	public final static int SPADES =3;
	public final static int ACE=1;
	public final static int JACK =11;
	public final static int QUEEN =12;
	public final static int KING =13;
    
    public Card(int theRank, int theSuit) {
    	rank = theRank;
        suit = theSuit;
    }

    public int getSuit(){
    	return suit;
    }

    public int getRank(){
    	return rank;
    }
    
    public String getSuitToString(){
    	switch (suit){
    		case CLUBS:
    			return "Clubs";
    		case DIAMONDS:		
    			return "Diamonds";
    		case HEARTS:		
    			return "Hearts";
    		case SPADES:		
    			return "Spades";
    		default:
    			return "error";
    	}
    }
    
    // Added this method
    public int getValue() {
    	switch(this.rank) {
    		case 1: 
    			return 11;
    		case 2:case 3:case 4:case 5:case 6:case 7:case 8:case 9:case 10:
    			return this.rank;
    		case 11:case 12: case 13:
    			return 10;
    		default:
    			return -1;
    	}
    }
    		
    		
    		
    public String getRankToString(){
    	switch (rank){
    	case 1:		
    		return "ACE";
    	case 2:	
    		return "2";
    	case 3:
    		return "3";
    	case 4:
    		return "4";
    	case 5:
    		return "5";
    	case 6:
    		return "6";
    	case 7:
    		return "7";
    	case 8:
    		return "8";
    	case 9:
    		return "9";
    	case 10:
    		return "10";
    	case 11:
    		return "Jack";
    	case 12:
    		return "Queen";
    	case 13:
    		return "King";
    	default: 
    		return "error";
    }
   }

    public String toString() {
        return getRankToString() + " of " + getSuitToString();
    }

}