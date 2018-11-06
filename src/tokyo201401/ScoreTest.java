package tokyo201401;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ScoreTest {

	@Test
	void 得点計算_1枚() {
		assertEquals(11, Score.sum(Arrays.asList("A")));
		assertEquals(2, Score.sum(Arrays.asList("2")));
		assertEquals(3, Score.sum(Arrays.asList("3")));
		assertEquals(4, Score.sum(Arrays.asList("4")));
		assertEquals(5, Score.sum(Arrays.asList("5")));
		assertEquals(6, Score.sum(Arrays.asList("6")));
		assertEquals(7, Score.sum(Arrays.asList("7")));
		assertEquals(8, Score.sum(Arrays.asList("8")));
		assertEquals(9, Score.sum(Arrays.asList("9")));
		assertEquals(10, Score.sum(Arrays.asList("10")));
		assertEquals(10, Score.sum(Arrays.asList("J")));
		assertEquals(10, Score.sum(Arrays.asList("Q")));
		assertEquals(10, Score.sum(Arrays.asList("K")));
	}

	@Test
	void 得点計算_2枚() {
		assertEquals(20, Score.sum(Arrays.asList("10", "J")));
		assertEquals(12, Score.sum(Arrays.asList("3", "9")));
		assertEquals(12, Score.sum(Arrays.asList("A", "A")));
		assertEquals(13, Score.sum(Arrays.asList("A", "A", "A")));
		assertEquals(14, Score.sum(Arrays.asList("A", "A", "A", "A")));
		assertEquals(21, Score.sum(Arrays.asList("A", "J")));
		assertEquals(13, Score.sum(Arrays.asList("A", "3", "9")));
	}
}
