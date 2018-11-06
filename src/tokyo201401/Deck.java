package tokyo201401;

import java.util.Random;

public class Deck {
	private Random rnd = new Random();
	public static final String ACE = "A";
	public static final String JACK = "J";
	public static final String QUEEN = "Q";
	public static final String KING = "K";

	public Card hit() {
		final int num = rnd.nextInt(13) + 1;
		String label;
		switch (num) {
			case 1: label = ACE; break;
			case 11: label = JACK; break;
			case 12: label = QUEEN; break;
			case 13: label = KING; break;
			default: label = String.valueOf(num); break;
		}
		return new Card(label);
	}

}
