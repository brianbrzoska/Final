import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HandTest {

	public HandTest() {
		// TODO Auto-generated constructor stub
	}

	public int testMethod() {
		ArrayList<Integer> handEval = new ArrayList<>();
		handEval.addAll(Arrays.asList(5, 2, 3, 4, 5, 2, 5, 2));
		Collections.sort(handEval);
		System.out.println(handEval);
		return Collections.frequency(handEval, 0);
	}

	public void dnd() {
		Deck deck1 = new Deck();
		ArrayList<Card> handEval1 = deck1.drawHand();
		System.out.println(handEval1);
		ArrayList<Integer> ranks = new ArrayList<>();
		for (Card card : handEval1) {
			ranks.add(card.checkRank());
		}
		Collections.sort(ranks);
	}

	public ArrayList<Integer> sorted(ArrayList<Card> newList2) {
		ArrayList<Integer> ranks = new ArrayList<>();
		for (Card card : newList2) {
			ranks.add(card.checkRank());
		}
		Collections.sort(ranks);
		return ranks;
	}

	public ArrayList<Integer> sortedSuit(ArrayList<Card> newList2) {
		ArrayList<Integer> suits = new ArrayList<>();
		for (Card card : newList2) {
			suits.add(card.checkSuit());
		}
		Collections.sort(suits);
		return suits;
	}

	public boolean isPair(ArrayList<Card> newList) {
		ArrayList<Integer> tempList = sorted(newList);
		if (tempList.get(0) == tempList.get(1)) {
			if (tempList.get(2) == tempList.get(3)) {
				return false;
			}
			if (tempList.get(2) == tempList.get(4)) {
				return false;
			}
			if (tempList.get(3) == tempList.get(4)) {
				return false;
			}
			if (Collections.frequency(tempList, tempList.get(0)) == 2) {
				return true;
			}
			return false;
		}

		if (tempList.get(1) == tempList.get(2)) {
			if (tempList.get(3) == tempList.get(4)) {
				return false;
			}
			if (Collections.frequency(tempList, tempList.get(1)) == 2) {
				return true;
			}
			return false;
		}

		if (tempList.get(2) == tempList.get(3)) {
			if (Collections.frequency(tempList, tempList.get(2)) == 2) {
				return true;
			}
			return false;
		}

		if (tempList.get(3) == tempList.get(4)) {
			return true;
		}

		return false;
	}

	public boolean twoPair(ArrayList<Card> hand) {
		ArrayList<Integer> tempList = sorted(hand);
		if (tempList.get(0) == tempList.get(1)) {
			if (tempList.get(2) == tempList.get(3)) {
				if (Collections.frequency(tempList, tempList.get(0)) == 2) {
					if (Collections.frequency(tempList, tempList.get(3)) == 2) {
						return true;
					}
					return false;
				}
				return false;
			}
			if (tempList.get(3) == tempList.get(4)) {
				return true;
			}
			return false;
		}

		if (tempList.get(1) == tempList.get(2)) {
			if (tempList.get(3) == tempList.get(4)) {
				if (Collections.frequency(tempList, tempList.get(1)) == 2) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean isThree(ArrayList<Card> hand) {
		ArrayList<Integer> tempList = sorted(hand);
		if (tempList.get(0) == tempList.get(1)) {
			if (tempList.get(1) == tempList.get(2)) {
				if (Collections.frequency(tempList, tempList.get(2)) == 3) {
					if (tempList.get(3) != tempList.get(4)) {
						return true;
					}
				}
			}
			return false;

		}

		if (tempList.get(1) == tempList.get(2)) {
			if (tempList.get(2) == tempList.get(3)) {
				if (Collections.frequency(tempList, tempList.get(3)) == 3) {
					return true;
				}
			}
			return false;
		}

		if (tempList.get(2) == tempList.get(3)) {
			if (tempList.get(3) == tempList.get(4)) {
				return true;
			}
		}

		return false;
	}

	public boolean isFour(ArrayList<Card> hand) {
		ArrayList<Integer> tempList = sorted(hand);
		if (Collections.frequency(tempList, tempList.get(2)) == 4) {
			return true;
		}

		return false;
	}

	public boolean fullHouse(ArrayList<Card> hand) {
		ArrayList<Integer> tempList = sorted(hand);

		if (Collections.frequency(tempList, tempList.get(2)) != 3) {
			return false;
		}
		if (Collections.frequency(tempList, tempList.get(0)) == 2) {
			return true;
		}
		if (Collections.frequency(tempList, tempList.get(4)) == 2) {
			return true;
		}

		return false;
	}

	public boolean flush(ArrayList<Card> hand) {
		ArrayList<Integer> tempList = sortedSuit(hand);
		if (Collections.frequency(tempList, tempList.get(0)) == 5) {
			return true;
		}
		return false;
	}

	public boolean straight(ArrayList<Card> hand) {
		ArrayList<Integer> tempList = sorted(hand);

		if ((tempList.get(0) + 1) == (tempList.get(1))) {
			if ((tempList.get(1) + 1) == (tempList.get(2))) {
				if ((tempList.get(2) + 1) == (tempList.get(3))) {
					if ((tempList.get(3) + 1) == tempList.get((4))) {
						return true;
					}
				}
			}
		}

		if (tempList.get(4) == 14) {
			for (int i = 0; i < 4; i++) {
				if (tempList.get(i) != i + 2) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean straightFlush(ArrayList<Card> hand) {
		return straight(hand) && flush(hand);
	}

	public boolean checkAll(ArrayList<Card> hand) {
		if (isPair(hand) == false) {
			if (twoPair(hand) == false) {
				if (isThree(hand) == false) {
					if (isFour(hand) == false) {
						if (fullHouse(hand) == false) {
							if (straight(hand) == false) {
								if (straightFlush(hand) == false) {
									if (royalFlush(hand) == false) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}

		return false;

	}

	public boolean royalFlush(ArrayList<Card> hand) {
		if (!straightFlush(hand)) {
			return false;
		}
		ArrayList<Integer> tempList = sorted(hand);
		if (tempList.get(2) == 12) {
			return true;
		}
		return false;
	}

	public void printCards(ArrayList<Card> cards) {
		for (Card i : cards) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	double counter1 = 0;
	double counter2 = 0;
	double counter3 = 0;
	double counter4 = 0;
	double counter5 = 0;
	double counter6 = 0;
	double counter7 = 0;
	double counter8 = 0;
	double counter9 = 0;
	double counter10 = 0;

	public void printResults(ArrayList<Card> hand) {
		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (isPair(testHand) == true) {
				counter1++;
			}
		}
		System.out.println("Chance to receive a pair: " + ((counter1) / 1000000));

		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (twoPair(testHand) == true) {
				counter2++;
			}
		}
		System.out.println("Chance to receive two pairs: " + ((counter2) / 1000000));

		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (isThree(testHand) == true) {
				counter3++;
			}
		}
		System.out.println("Chance to receive three of a kind: " + ((counter3) / 1000000));
	
	
		for (int i = 0; i < 100000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (isFour(testHand) == true) {
				counter4++;
			}
		}
		System.out.println("Chance to receive four of a kind: " + ((counter4) / 1000000));
		
		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (royalFlush(testHand) == true) {
				counter5++;
			}
		}
		System.out.println("Chance to receive a royal flush: " + ((counter5) / 1000000));
		
		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (fullHouse(testHand) == true) {
				counter6++;
			}
		}
		System.out.println("Chance to receive a full house: " + ((counter6) / 1000000));
	
		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (straight(testHand) == true) {
				counter7++;
			}
		}
		System.out.println("Chance to receive a straight: " + ((counter7) / 1000000));
		
		
		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (flush(testHand) == true) {
				counter8++;
			}
		}
		System.out.println("Chance to receive a flush: " + ((counter8) / 1000000));
		
		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (straightFlush(testHand) == true) {
				counter9++;
			}
		}
		System.out.println("Chance to receive a straight flush: " + ((counter9) / 1000000));
		
		for (int i = 0; i < 1000000; i++) {
			Deck deck = new Deck();
			ArrayList<Card> testHand = deck.drawHand();
			if (checkAll(testHand) == true) {
				counter10++;
			}
		}
		System.out.println("Chance to have none: " + ((counter10) / 1000000));
	}
		
		
	}

