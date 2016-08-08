package labs;

public class BlackJackCard { 
	private int rank;
	private int suit;
	public static int CLUBS =1;
	public static int DIAMONDS =2;
	public static int HEARTS =3;
	public static int SPADES =4;
    
    public BlackJackCard(int rank, int suit) {
    	rank = rank;
        suit = suit;
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
    		return "11";
    	case 12:
    		return "12";
    	case 13:
    		return "13";
    }
   }

    public String toString() {
        System.out.println(getRankToString + " of " + getSuitToString);
        return
    }

	public static int getCLUBS() {
		return CLUBS;
	}

	public static void setCLUBS(int cLUBS) {
		CLUBS = cLUBS;
	}

	public static int getDIAMONDS() {
		return DIAMONDS;
	}

	public static void setDIAMONDS(int dIAMONDS) {
		DIAMONDS = dIAMONDS;
	}

	public static int getHEARTS() {
		return HEARTS;
	}

	public static void setHEARTS(int hEARTS) {
		HEARTS = hEARTS;
	}

	public static int getSPADES() {
		return SPADES;
	}

	public static void setSPADES(int sPADES) {
		SPADES = sPADES;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

            

}
