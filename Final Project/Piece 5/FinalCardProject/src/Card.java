
public class Card {


	private char rank;
	private char suit;

	public Card(char inputRank, char inputSuit) {
		rank = inputRank;
		suit = inputSuit;

	}

	public Card(Card to_be_copied) { //copies cards to other cards
		this.rank = to_be_copied.getRank();
		this.suit = to_be_copied.getSuit();
	}

	public char getRank() {
		return this.rank;
	}

	public char getSuit() {
		return this.suit;
	}

	public int checkRank() {
		if(2 <= Character.getNumericValue(rank) && Character.getNumericValue(rank) <= 9) {
			return Character.getNumericValue(rank);
		}
		int newRank = -1;
		if(rank == 'T') {
			newRank = 10;
		}
		if(rank == 'J') {
			newRank = 11;
		}
		if(rank == 'Q') {
			newRank = 12;
		}
		if(rank == 'K') {
			newRank = 13;
		}
		if(rank == 'A') {
			newRank = 14;
		}
		return newRank;
	}
	
	public int checkSuit() {
		
		int newSuit = -1; //HDSC
		if(suit == 'H') {
			newSuit = 1;
		}
		if(suit == 'D') {
			newSuit = 2;
		}
		if(suit == 'S') {
			newSuit = 3;
		}
		if(suit == 'C') {
			newSuit = 4;
		}
		
		return newSuit;
	}
	
	

	@Override
	public String toString() {
		return "(" + this.rank + this.suit + ")";
	}

}
