import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> deck;
	// static Card hand = null;

	public Deck() {
		deck = new ArrayList<>();
		generateCards();
	}

	public void generateCards() {
		ArrayList<Card> cards = new ArrayList<Card>();
		String temp = "HDSC";
		String temp2 = "23456789TJQKA";

		for (int j = 0; j < 4; j++)
			for (int i = 0; i < 13; i++)
				cards.add(new Card(temp2.charAt(i), temp.charAt(j)));

		deck = cards;
	}


	public Card draw() {
		if(deck.isEmpty()) {
			return null;
		}

		Random random = new Random();
		int random1 = random.nextInt(deck.size());

		return deck.remove(random1);
	}

	public ArrayList<Card> drawHand() {
		ArrayList<Card> hand = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			hand.add(draw());
		}
		return hand;
	}



	/*
	 * public static void addBackCard() {
	 * 
	 * Card copy_card; copy_card = new Card(hand); deck.add(copy_card); hand = null;
	 * 
	 * }
	 */

	@Override
	public String toString() {
		String test = "";
		for (Card test1 : deck) {
			test += test1 + " ";
		}
		return test;
	}

}
