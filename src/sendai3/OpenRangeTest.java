package sendai3;

import static org.junit.jupiter.api.Assertions.*;

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
}
