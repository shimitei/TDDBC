package nagaoka1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class VersionTest {

	@Test
	void validかどうか調べよう() {
		assertTrue(Version.isValid("JDK7u40"));
		assertFalse(Version.isValid("hoge"));
		assertFalse(Version.isValid("JDK7u9x"));
	}

	@Nested
	class parseしよう {

		@Test
		void 正常系() {
			Version v = Version.parse("JDK7u40");
			assertEquals(Integer.valueOf(7), v.familyNumber);
			assertEquals(Integer.valueOf(40), v.updateNumber);
		}

		@Test
		void 異常系() {
			assertThrows(IllegalArgumentException.class, () -> Version.parse("JDK7u9x"));
		}
	}

	@Test
	void 大小比較しよう() {
		final Version u40 = Version.parse("JDK7u40");
		final Version u51 = Version.parse("JDK7u51");
		final Version jdk8u0 = Version.parse("JDK8u0");

		assertTrue(u40.lt(u51));
		assertFalse(u40.gt(u51));
		assertTrue(u40.lt(jdk8u0));
		assertTrue(jdk8u0.gt(u51));
	}

	@Nested
	class 次の番号を計算しよう {
		@Test
		void nextLimitedUpdate() {
			final Version u45 = Version.parse("JDK7u45");

			final Version u60 = u45.nextLimitedUpdate();
			assertEquals(Integer.valueOf(60), u60.updateNumber);
		}
		@Test
		void nextCriticalPatchUpdate() {
			final Version u45 = Version.parse("JDK7u45");

			final Version u51 = u45.nextCriticalPatchUpdate();
			assertEquals(Integer.valueOf(51), u51.updateNumber);
		}
		@Test
		void nextSecurityAlert() {
			final Version u45 = Version.parse("JDK7u45");

			final Version u46 = u45.nextSecurityAlert();
			assertEquals(Integer.valueOf(46), u46.updateNumber);
		}
	}
}
