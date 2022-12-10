import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		/*
		 * Deck deck = new Deck(); deck.generateCards(); System.out.println(deck);
		 * //print list
		 * 
		 * //deck.draw(); ArrayList<Card> hand = deck.drawHand();
		 * System.out.println(hand); for(Card testHand: hand) {
		 * 
		 * System.out.println(testHand.checkRank());
		 * 
		 * } System.out.println(deck);
		 */

		HandTest test = new HandTest();
		int counter = 0;
		/*
		 * Deck deck = new Deck(); ArrayList<Card> hand = deck.drawHand();
		 * test.printCards(hand); test.sortedSuit(hand); test.printCards(hand);
		 */
//		Deck deck = new Deck();
//		ArrayList<Card> hand = deck.drawHand();
//		System.out.println(hand);
//		ArrayList<Integer> newHand = test.sortedSuit(hand);
//		System.out.println(newHand);

			Deck deck = new Deck();
			ArrayList<Card> hand = deck.drawHand();

		test.printResults(hand);
			}

		


		/*
		 * Random random = new Random(); int rand = random.nextInt(52);
		 * 
		 * draw(rand); System.out.println("----------------------------\n" + rand);
		 * System.out.println("----------------------------"); printCards(deck);
		 */
	}