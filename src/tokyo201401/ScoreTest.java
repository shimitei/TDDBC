package tokyo201401;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ScoreTest {

	@Test
	void 得点計算_1枚() {
		assertEquals(11, Score.sum(new Hand().add(new Card("A"))));
		assertEquals(2, Score.sum(new Hand().add(new Card("2"))));
		assertEquals(3, Score.sum(new Hand().add(new Card("3"))));
		assertEquals(4, Score.sum(new Hand().add(new Card("4"))));
		assertEquals(5, Score.sum(new Hand().add(new Card("5"))));
		assertEquals(6, Score.sum(new Hand().add(new Card("6"))));
		assertEquals(7, Score.sum(new Hand().add(new Card("7"))));
		assertEquals(8, Score.sum(new Hand().add(new Card("8"))));
		assertEquals(9, Score.sum(new Hand().add(new Card("9"))));
		assertEquals(10, Score.sum(new Hand().add(new Card("10"))));
		assertEquals(10, Score.sum(new Hand().add(new Card("J"))));
		assertEquals(10, Score.sum(new Hand().add(new Card("Q"))));
		assertEquals(10, Score.sum(new Hand().add(new Card("K"))));
	}

	@Test
	void 得点計算_2枚() {
		assertEquals(20, Score.sum(new Hand().add(new Card("10")).add(new Card("J"))));
		assertEquals(12, Score.sum(new Hand().add(new Card("3")).add(new Card("9"))));
		assertEquals(12, Score.sum(new Hand().add(new Card("A")).add(new Card("A"))));
		assertEquals(13, Score.sum(new Hand().add(new Card("A")).add(new Card("A")).add(new Card("A"))));
		assertEquals(14, Score.sum(new Hand().add(new Card("A")).add(new Card("A")).add(new Card("A")).add(new Card("A"))));
		assertEquals(21, Score.sum(new Hand().add(new Card("A")).add(new Card("J"))));
		assertEquals(13, Score.sum(new Hand().add(new Card("A")).add(new Card("3")).add(new Card("9"))));
	}

	@Test
	void プレイヤーのカードの合計値が21を超えると負け() {
		assertFalse(Score.isBust(21));
		assertTrue(Score.isBust(22));
	}
}
