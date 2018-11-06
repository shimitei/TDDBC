package tokyo201401;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> cards;
	public List<Card> getCards() {
		return cards;
	}

	public Hand() {
		this.cards = new ArrayList<Card>();
	}

	public int count() {
		return cards.size();
	}

	public Hand add(Card c) {
		this.cards.add(c);
		return this;
	}
}
