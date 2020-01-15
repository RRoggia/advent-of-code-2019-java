package rroggia.github.io.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class GridConnectionDeterminerTest {

	private static final GridConnectionDeterminer GRID_DETERMINER_CONNECTIONS = GridConnectionDeterminer.getInstance();

	@Test // TODO need to implement after refactoring
	public void determineInitialConnection() {
		String initalPositionExpected = "0,0";

		Set<String> connectionsInTheGrid = GRID_DETERMINER_CONNECTIONS.determineConnections("");
		assertTrue(connectionsInTheGrid.contains(initalPositionExpected));
	}

	@Test
	public void determineUpConnections() {
		String lastExpectedPosition = "10,0";

		Set<String> connectionsInTheGrid = GRID_DETERMINER_CONNECTIONS.determineConnections("U10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineDownConnections() {
		String lastExpectedPosition = "-10,0";

		Set<String> connectionsInTheGrid = GRID_DETERMINER_CONNECTIONS.determineConnections("D10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineRightConnections() {
		String lastExpectedPosition = "0,10";

		Set<String> connectionsInTheGrid = GRID_DETERMINER_CONNECTIONS.determineConnections("R10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineLeftConnections() {
		String lastExpectedPosition = "0,-10";

		Set<String> connectionsInTheGrid = GRID_DETERMINER_CONNECTIONS.determineConnections("L10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

}
