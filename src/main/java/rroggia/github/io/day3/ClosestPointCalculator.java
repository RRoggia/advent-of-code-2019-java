package rroggia.github.io.day3;

import java.util.List;

public class ClosestPointCalculator {

	private static final ClosestPointCalculator INSTANCE = new ClosestPointCalculator();

	private ClosestPointCalculator() {

	}

	public static ClosestPointCalculator getInstance() {
		return INSTANCE;
	}

	public int calculate(List<String> intersections) {
		int closestDistance = Integer.MAX_VALUE;
		for (String intersection : intersections) {
			String[] split = intersection.split(",");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);

			int abs = Math.abs(x);
			int abs2 = Math.abs(y);
			if (abs + abs2 < closestDistance) {
				closestDistance = abs + abs2;
			}
		}
		return closestDistance;
	}

}
