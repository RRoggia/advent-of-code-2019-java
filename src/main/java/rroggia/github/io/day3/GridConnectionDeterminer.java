package rroggia.github.io.day3;

import java.util.Set;

public class GridConnectionDeterminer {

	private static final GridConnectionDeterminer INSTANCE = new GridConnectionDeterminer();

	private GridConnectionDeterminer() {
		// override public constructor created by default from java
	}

	public static GridConnectionDeterminer getInstance() {
		return INSTANCE;
	}

	public Set<String> determineConnections(String traces) {
		return Day3.determinePointsWireIsConnectedInTheGrid(traces);
	}
}
