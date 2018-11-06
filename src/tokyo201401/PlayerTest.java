package tokyo201401;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	void プレイヤーには最初にカードが2枚配られる() {
		final Player p = Game.newGame().getPlayer();
		assertEquals(2, p.getCards().count());
	}

	@Test
	void プレイヤーはヒットすることでカードを追加でもらうことができる() {
		final Player p = Game.newGame().getPlayer();
		p.hit();
		assertEquals(3, p.getCards().count());
	}

	@Test
	void スタンドを選択するとプレイヤーはゲーム終了まで何もできない() {
		final Player p = Game.newGame().getPlayer();
		p.stand();
		p.hit();
		assertEquals(2, p.getCards().count());
	}
}
