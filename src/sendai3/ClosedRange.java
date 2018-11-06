package sendai3;

/**
 * TDDBC仙台03課題：整数の区間
 * @see http://devtesting.jp/tddbc/?TDDBC%E4%BB%99%E5%8F%B003%2F%E8%AA%B2%E9%A1%8C
 */
public class ClosedRange {

	private int lowerEndPoint;
	private int upperEndPoint;

	public int getLowerEndpoint() {
		return lowerEndPoint;
	}

	public int getUpperEndpoint() {
		return upperEndPoint;
	}

	public ClosedRange(int lower, int upper) {
		if (lower > upper) {
			throw new IllegalArgumentException();
		}
		this.lowerEndPoint = lower;
		this.upperEndPoint = upper;
	}

	@Override
	public String toString() {
		return String.format("[%d,%d]", this.lowerEndPoint, this.upperEndPoint);
	}

	public boolean contains(int n) {
		return (this.lowerEndPoint <= n) && (this.upperEndPoint >= n);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lowerEndPoint;
		result = prime * result + upperEndPoint;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClosedRange other = (ClosedRange) obj;
		if (lowerEndPoint != other.lowerEndPoint)
			return false;
		if (upperEndPoint != other.upperEndPoint)
			return false;
		return true;
	}

	public boolean isConnectedTo(ClosedRange closedRange) {
		return contains(closedRange.getLowerEndpoint()) || contains(closedRange.getUpperEndpoint());
	}

	public boolean isConnectedTo(OpenRange openRange) {
		return OpenClosedRangeUtils.isConnected(openRange, this);
	}
}
