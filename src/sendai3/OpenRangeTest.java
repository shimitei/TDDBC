package sendai3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class OpenRangeTest {

	@Test
	void 下端点と上端点を与えて開区間を生成しよう() {
		final OpenRange o = new OpenRange(3, 8);
		assertEquals(3, o.getLowerEndpoint());
		assertEquals(8, o.getUpperEndpoint());
	}

	@Test
	void 下端点8上端点3は生成出来ない() {
		assertThrows(IllegalArgumentException.class, () -> new OpenRange(8, 3));
	}

	@Test
	void 開区間から文字列表記を取得しよう() {
		final OpenRange o = new OpenRange(3, 8);
		assertEquals("(3,8)", o.toString());
	}

	@Test
	void 開区間が指定した整数を含むか判定しよう() {
		final OpenRange o = new OpenRange(3, 8);
		assertFalse(o.contains(3));
		assertFalse(o.contains(8));
		assertFalse(o.contains(5));
		assertTrue(o.contains(-1));
	}

	@Test
	void 開区間が別の開区間と等しいか判定しよう() {
		final OpenRange o = new OpenRange(3, 8);
		assertTrue(o.equals(new OpenRange(3, 8)));
		assertFalse(o.equals(new OpenRange(1, 6)));
	}

	@Test
	void 開区間が別の開区間と接続しているか判定しよう() {
		final OpenRange o = new OpenRange(3, 8);
		assertTrue(o.isConnectedTo(new OpenRange(1, 6)));
		assertTrue(o.isConnectedTo(new OpenRange(8, 15)));
		assertTrue(o.isConnectedTo(new OpenRange(3, 8)));
	}

	@Test
	void 閉区間と開区間と等しいか判定しよう() {
		final ClosedRange c3to8 = new ClosedRange(3, 8);
		final OpenRange o = new OpenRange(3, 8);
		assertNotEquals(c3to8, o);
	}

	@Test
	void 閉区間が開区間と接続しているか判定しよう() {
		final OpenRange o = new OpenRange(3, 8);
		assertTrue(o.isConnectedTo(new ClosedRange(1, 6)));
		assertTrue(o.isConnectedTo(new ClosedRange(8, 15)));
		assertFalse(o.isConnectedTo(new ClosedRange(3, 8)));
	}

	@Test
	void 指定した全ての整数を含むか判定しよう() {
		final OpenRange o = new OpenRange(3, 8);
		assertTrue(o.containsAll(Arrays.asList(9,-1)));
		assertFalse(o.containsAll(Arrays.asList(4,7,3)));
	}

	@Test
	void 開区間と別の開区間との共通集合を取得しよう() {
		final OpenRange o1 = new OpenRange(3, 8);

		final OpenRange o2 = o1.getIntersection(new OpenRange(4, 10));
		assertEquals(3, o2.getLowerEndpoint());
		assertEquals(10, o2.getUpperEndpoint());
	}

	@Test
	void 文字列表記を解析して区間を生成しよう() {
		final OpenRange o = OpenRange.parse("(3,8)");
		assertEquals(3, o.getLowerEndpoint());
		assertEquals(8, o.getUpperEndpoint());
	}
}
