package tokyo201401;

import java.util.function.Predicate;

/**
 * ブラックジャック
 * @see https://www.slideshare.net/imagire/tdd-boot-camp-tokyo-for-c-30153762
 */
public class Score {

	private static Predicate<Card> isNotAce = (c) -> { return !c.getLabel().equals(Deck.ACE); };
	private static Predicate<Card> isAce = (c) -> { return c.getLabel().equals(Deck.ACE); };

	public static int sum(Hand hand) {
		int score = hand.getCards().stream().filter(isNotAce).mapToInt(c -> value(c)).sum();
		final int countA = (int) hand.getCards().stream().filter(isAce).count();
		if (countA > 0) {
			final int scoreA = score + countA + 10;
			if (scoreA <= 21) {
				score = scoreA;
			} else {
				score = score + countA;
			}
		}
		return score;
	}

	private static int value(Card c) {
		int result;
		final String label = c.getLabel();
		switch (label) {
		case Deck.JACK: result = 10; break;
		case Deck.QUEEN: result = 10; break;
		case Deck.KING: result = 10; break;
		default: result = Integer.valueOf(label); break;
		}
		return result;
	}

	public static boolean isBust(int score) {
		return (score > 21);
	}
}
