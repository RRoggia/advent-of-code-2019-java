package rroggia.github.io.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class GridIntersectionDeterminerTest {

	private static final GridIntersectionDeterminer GRID = GridIntersectionDeterminer.getInstance();

	@Test
	public void determineIntersection() {
		Set<String> firstWireConnections = Set.of("0,0");
		Set<String> secondWireConnections = Set.of("0,0");

		List<String> intersections = GRID.determineIntersections(firstWireConnections, secondWireConnections);
		assertEquals(1, intersections.size());
	}

	@Test
	public void multipleIntersections() {
		var firstWireConnections = Set.of("0,0", "1,0", "2,0", "3,0", "4,0", "5,0", "6,0", "7,0");
		var secondWireConnections = Set.of("0,0", "1,0", "2,0", "3,0", "4,0", "5,0");

		List<String> intersections = GRID.determineIntersections(firstWireConnections, secondWireConnections);
		assertEquals(6, intersections.size());
	}

}
