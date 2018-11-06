package tokyo201401;

public class Player {

	private Game game;
	private Hand cards;
	private boolean stand = false;

	public Hand getCards() {
		return this.cards;
	}
	public boolean isStand() {
		return this.stand;
	}

	static Player createPlayer(Game game) {
		final Player result = new Player();
		result.cards = new Hand();
		result.game = game;
		return result;
	}

	public void hit() {
		if (stand) return;
		this.cards.add(this.game.hit());
	}

	public void stand() {
		this.stand = true;
	}
}
