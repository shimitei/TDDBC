package nagaoka1;

/**
 * TDDBC長岡1.0/演習
 * お題 : Javaの奇妙なバージョン
 * @see http://devtesting.jp/tddbc/?TDDBC%E9%95%B7%E5%B2%A11.0%2F%E6%BC%94%E7%BF%92
 */
public class Version implements Comparable<Version> {
	public Integer familyNumber;
	public Integer updateNumber;

	public Version(String verStr) {
		if (!isValid(verStr)) {
			throw new IllegalArgumentException();
		}
		final String[] ar = verStr.split("u");
		final String major = ar[0].substring(3);
		final String update = ar[1];
		this.familyNumber = Integer.parseInt(major);
		this.updateNumber = Integer.parseInt(update);
	}

	public Version(Integer familyNumber, Integer updateNumber) {
		this.familyNumber = familyNumber;
		this.updateNumber = updateNumber;
	}

	public static boolean isValid(String verStr) {
		if (verStr == null) {
			return false;
		}
		if (!verStr.startsWith("JDK")) {
			return false;
		}
		final String[] ar = verStr.split("u");
		if (ar.length != 2) {
			return false;
		}

		boolean isDigit = true;
        try {
            Integer.parseInt(ar[1]);
        } catch (Exception e) {
            isDigit = false;
        }
        if (!isDigit) {
        	return false;
        }
		return true;
	}

	public static Version parse(String verStr) {
		return new Version(verStr);
	}

	@Override
	public int compareTo(Version v) {
		final int cf = this.familyNumber.compareTo(v.familyNumber);
		if (cf != 0) {
			return cf;
		}
		final int cu = this.updateNumber.compareTo(v.updateNumber);
		return cu;
	}

	public boolean lt(Version v) {
		return (this.compareTo(v) < 0);
	}

	public boolean gt(Version v) {
		return (this.compareTo(v) > 0);
	}

	public Version nextLimitedUpdate() {
		final Integer next = ((this.updateNumber / 20) + 1) * 20;
		return new Version(this.familyNumber, next);
	}

	public Version nextCriticalPatchUpdate() {
		Integer next = ((this.updateNumber / 5) + 1) * 5;
		if ((next & 1) == 0) {
			next++;
		}
		return new Version(this.familyNumber, next);
	}

	public Version nextSecurityAlert() {
		return new Version(this.familyNumber, this.updateNumber + 1);
	}

}
