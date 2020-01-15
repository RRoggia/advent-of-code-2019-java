package rroggia.github.io.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ClosestPointCalculatorTest {

	@Test
	public void calculateWithAbsoluteNumber() {
		var intersections = Arrays.asList("10,24", "-10,-24", "10,-24", "-10,24");
		int closestPoint = ClosestPointCalculator.getInstance().calculate(intersections);
		assertEquals(34, closestPoint);
	}

	@Test
	public void calculateClosestPoint() {
		var intersections = Arrays.asList("-1,-60", "1,3", "50,50");
		int closestPoint = ClosestPointCalculator.getInstance().calculate(intersections);
		assertEquals(4, closestPoint);
	}

}
