package rroggia.github.io.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class GridConnectionDeterminerTest {

	@Test // TODO need to implement after refactoring
	public void determineInitialConnection() {
		String initalPositionExpected = "0,0";

		Set<String> upConnectedInTheGrid = Day3.determinePointsWireIsConnectedInTheGrid("");
		assertTrue(upConnectedInTheGrid.contains(initalPositionExpected));
	}

	@Test
	public void determineUpConnections() {
		String lastExpectedPosition = "30,0";

		Set<String> upConnectedInTheGrid = Day3.determinePointsWireIsConnectedInTheGrid("U10,U20");
		assertEquals(30, upConnectedInTheGrid.size());
		assertTrue(upConnectedInTheGrid.contains(lastExpectedPosition));
	}

	@Test
	public void determineDownConnections() {
		String lastExpectedPosition = "-30,0";

		Set<String> upConnectedInTheGrid = Day3.determinePointsWireIsConnectedInTheGrid("D10,D20");
		assertEquals(30, upConnectedInTheGrid.size());
		assertTrue(upConnectedInTheGrid.contains(lastExpectedPosition));
	}

}
