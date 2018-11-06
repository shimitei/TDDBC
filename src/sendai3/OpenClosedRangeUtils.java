package sendai3;

public class OpenClosedRangeUtils {

	public static boolean isConnected(OpenRange openRange, ClosedRange closedRange) {
		return !(closedRange.contains(openRange.getLowerEndpoint()) && closedRange.contains(openRange.getUpperEndpoint()));
	}
}
