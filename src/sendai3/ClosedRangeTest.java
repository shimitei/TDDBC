package sendai3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ClosedRangeTest {

	@Test
	void 下端点と上端点を与えて閉区間を生成しよう() {
		final ClosedRange c3to8 = new ClosedRange(3, 8);
		assertEquals(3, c3to8.getLowerEndpoint());
		assertEquals(8, c3to8.getUpperEndpoint());
	}

	@Test
	void 下端点8上端点3は生成出来ない() {
		assertThrows(IllegalArgumentException.class, () -> new ClosedRange(8, 3));
	}

	@Test
	void 閉区間から文字列表記を取得しよう() {
		final ClosedRange c3to8 = new ClosedRange(3, 8);
		assertEquals("[3,8]", c3to8.toString());
	}

	@Test
	void 閉区間が指定した整数を含むか判定しよう() {
		final ClosedRange c3to8 = new ClosedRange(3, 8);
		assertTrue(c3to8.contains(5));
		assertFalse(c3to8.contains(-1));
	}

	@Test
	void 閉区間が別の閉区間と等しいか判定しよう() {
		final ClosedRange c3to8 = new ClosedRange(3, 8);
		assertTrue(c3to8.equals(new ClosedRange(3, 8)));
		assertFalse(c3to8.equals(new ClosedRange(1, 6)));
	}

	@Test
	void 閉区間が別の閉区間と接続しているか判定しよう() {
		final ClosedRange c3to8 = new ClosedRange(3, 8);
		assertTrue(c3to8.isConnectedTo(new ClosedRange(1, 6)));
		assertTrue(c3to8.isConnectedTo(new ClosedRange(8, 15)));
		assertFalse(c3to8.isConnectedTo(new ClosedRange(9, 12)));
	}
}
