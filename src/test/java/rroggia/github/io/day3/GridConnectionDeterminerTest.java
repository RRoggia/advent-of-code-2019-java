package rroggia.github.io.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class GridConnectionDeterminerTest {

	private static final GridConnectionDeterminer GRID = GridConnectionDeterminer.getInstance();

	@Test
	public void determineInitialConnection() {
		String initalPositionExpected = "0,0";

		Set<String> gridConnections = GRID.determineConnections("");
		assertTrue(gridConnections.contains(initalPositionExpected));

		gridConnections = GRID.determineConnections("   ");
		assertTrue(gridConnections.contains(initalPositionExpected));
	}

	@Test
	public void determineUpConnections() {
		String lastExpectedPosition = "0,10";

		Set<String> gridConnections = GRID.determineConnections("U10");
		assertEquals(11, gridConnections.size());
		assertTrue(gridConnections.contains(lastExpectedPosition));
	}

	@Test
	public void determineDownConnections() {
		String lastExpectedPosition = "0,-10";

		Set<String> gridConnections = GRID.determineConnections("D10");
		assertEquals(11, gridConnections.size());
		assertTrue(gridConnections.contains(lastExpectedPosition));
	}

	@Test
	public void determineRightConnections() {
		String lastExpectedPosition = "10,0";

		Set<String> gridConnections = GRID.determineConnections("R10");
		assertEquals(11, gridConnections.size());
		assertTrue(gridConnections.contains(lastExpectedPosition));
	}

	@Test
	public void determineLeftConnections() {
		String lastExpectedPosition = "-10,0";

		Set<String> gridConnections = GRID.determineConnections("L10");
		assertEquals(11, gridConnections.size());
		assertTrue(gridConnections.contains(lastExpectedPosition));
	}

	@Test
	public void determineExampleConnection() {
		Set<String> gridConnections = GRID.determineConnections("R75,D30,R83,U83,L12,D49,R71,U7,L72");
		assertTrue(gridConnections.contains("145,11"));
	}

	@Test
	public void determineWrongInvalidWireTraces() {
		assertThrows(RuntimeException.class, () -> GRID.determineConnections("X10"));

	}
}
