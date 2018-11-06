package tokyo201401;

public class Game {
	private static Deck deck = new Deck();
	private Player player;
	private Player dealer;

	public Player getPlayer() {
		return player;
	}

	public static Game newGame() {
		final Game result = new Game();
		result.player = Player.createPlayer(result);
		result.dealer = Player.createPlayer(result);
		result.player.hit();
		result.dealer.hit();
		result.player.hit();
		result.dealer.hit();
		return result;
	}

	public Card hit() {
		return deck.hit();
	}
}
