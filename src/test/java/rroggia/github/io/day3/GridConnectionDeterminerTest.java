package rroggia.github.io.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridConnectionDeterminerTest {

	private GridConnectionDeterminer grid;

	@BeforeEach
	public void setup() {
		grid = new GridConnectionDeterminer();
	}

	@Test
	public void determineInitialConnection() {
		String initalPositionExpected = "0,0";

		Set<String> connectionsInTheGrid = grid.determineConnections("");
		assertTrue(connectionsInTheGrid.contains(initalPositionExpected));
	}

	@Test
	public void determineUpConnections() {
		String lastExpectedPosition = "10,0";

		Set<String> connectionsInTheGrid = new GridConnectionDeterminer().determineConnections("U10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineDownConnections() {
		String lastExpectedPosition = "-10,0";

		Set<String> connectionsInTheGrid = grid.determineConnections("D10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineRightConnections() {
		String lastExpectedPosition = "0,10";

		Set<String> connectionsInTheGrid = grid.determineConnections("R10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineLeftConnections() {
		String lastExpectedPosition = "0,-10";

		Set<String> connectionsInTheGrid = grid.determineConnections("L10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

}
