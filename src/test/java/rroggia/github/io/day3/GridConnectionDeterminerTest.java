package rroggia.github.io.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class GridConnectionDeterminerTest {

	@Test // TODO need to implement after refactoring
	public void determineInitialConnection() {
		String initalPositionExpected = "0,0";

		Set<String> connectionsInTheGrid = Day3.determinePointsWireIsConnectedInTheGrid("");
		assertTrue(connectionsInTheGrid.contains(initalPositionExpected));
	}

	@Test
	public void determineUpConnections() {
		String lastExpectedPosition = "10,0";

		Set<String> connectionsInTheGrid = Day3.determinePointsWireIsConnectedInTheGrid("U10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineDownConnections() {
		String lastExpectedPosition = "-10,0";

		Set<String> connectionsInTheGrid = Day3.determinePointsWireIsConnectedInTheGrid("D10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineRightConnections() {
		String lastExpectedPosition = "0,10";

		Set<String> connectionsInTheGrid = Day3.determinePointsWireIsConnectedInTheGrid("R10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineLeftConnections() {
		String lastExpectedPosition = "0,-10";

		Set<String> connectionsInTheGrid = Day3.determinePointsWireIsConnectedInTheGrid("L10");
		assertEquals(11, connectionsInTheGrid.size());
		assertTrue(connectionsInTheGrid.contains(lastExpectedPosition));
	}

}
