package tokyo201401;

import java.util.List;

/**
 * ブラックジャック
 * @see https://www.slideshare.net/imagire/tdd-boot-camp-tokyo-for-c-30153762
 */
public class Score {

	public static int sum(List<String> list) {
		int score = list.stream().filter(s -> !s.equals("A")).mapToInt(s -> value(s)).sum();
		final int countA = (int) list.stream().filter(s -> s.equals("A")).count();
		if (countA > 0) {
			final int scoreA = score + countA + 10;
			if (scoreA <= 21) {
				score = scoreA;
			} else {
				score = score + countA;
			}
		}
		return score;
	}

	private static int value(String s) {
		int result;
		switch (s) {
		case "J": result = 10; break;
		case "Q": result = 10; break;
		case "K": result = 10; break;
		default: result = Integer.valueOf(s); break;
		}
		return result;
	}
}
